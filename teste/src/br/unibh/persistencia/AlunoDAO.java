package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.List;

import br.unibh.entidades.Aluno;

public class AlunoDAO implements DAO<Aluno,Long>{
	
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	

	@Override
	public Aluno find(Long id) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().
			prepareStatement("select * from tb_aluno where id=?");
			p.setLong(1, id);
			ResultSet r = p.executeQuery();
			if(r.next()){
				return new Aluno(r.getLong("id"),
						r.getLong("matricula"), 
						r.getString("nome"), 
						r.getString("cpf"), 
						r.getString("data_aniversario")==null?
								null:df.parse(r.getString("data_aniversario"))
								);				
			}
			JDBCUtil.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Aluno t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().
			prepareStatement("insert into tb_aluno(matricula, nome, cpf, data_aniversario) values(?,?,?,?)");
			p.setLong(1, t.getMatricula());
			p.setString(2, t.getNome());
			p.setString(3, t.getCpf());
			if (t.getDataAniversairo()==null){
				p.setNull(3, Types.NULL);}
			else{
				p.setString(3, df.format(t.getDataAniversairo()));
			}
			
			p.executeQuery();					
			
			JDBCUtil.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}