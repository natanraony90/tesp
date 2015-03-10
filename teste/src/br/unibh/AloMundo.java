package br.unibh;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.JDBCUtil;

public class AloMundo {

	public static void main(String[] args) {

		/*for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + " - Alô Mundo");
		}*/
		
		Aluno a1 = new Aluno(1L, 1234L, "João", "98798798799", new Date());
		Aluno a2 = new Aluno(2L, 4321L, "Maria", "98798798799", new Date());
		Aluno a3 = new Aluno(3L, 1245L, "Julia", "1234456690");
		Aluno a4 = new Aluno(4L, 3214L, "Natã");
		Professor p1 = new Professor(5L, "Pedro", "12312312345", new BigDecimal(12000));
		Professor p2 = new Professor(6L, "Gabriel", "1237654829");
		
		System.out.println("BONUS === " + Professor.BONUS);
		System.out.println(Aluno.verificaMatricula("12312313"));
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(p1);
		System.out.println(p2);
		
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement(
					"select * from tb_aluno").executeQuery();
			
			while(res.next()){
				System.out.println(res.getLong("id")+"\t"+res.getString("nome"));
			}
			
			JDBCUtil.closeConnection();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
