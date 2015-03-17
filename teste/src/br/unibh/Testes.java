package br.unibh;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.entidades.Aluno;
import br.unibh.persistencia.AlunoDAO;

public class Testes {
	
	@Test
	public void testeBuscarAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "12345678901");
	}
	
	@Test
	public void testeInserirAluno(){
		
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, 54372L, "Lucas Raony", "65483902671", new Date());
		dao.insert(a);
	}

}
