package br.unibh;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

public class Testes {

	@Before
	public void preparaBanco() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a1 = new Aluno(null, new Long(1234), "Rosa Ferreira", "56473890213",
				new Date());
		Aluno a2 = new Aluno(null, new Long(34544), "Claudia Ribeiro", "54738906543",
				new Date());
		Aluno a3 = new Aluno(null, new Long(23423), "Katia Lopes", "12345678909",
				new Date());
		dao.insert(a1);
		dao.insert(a2);
		dao.insert(a3);
	}

	@After
	public void limpaBanco() {
		AlunoDAO dao = new AlunoDAO();
		dao.clean();
	}

	@Test
	public void testeBuscarAluno() {

		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getCpf(), "56473890213");
	}

	@Test
	public void testeInsertAluno() {

		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, 12321L, "Kelly Versiani", "98765432101",
				new Date());
		dao.insert(a);
		Aluno a2 = dao.find(4L);
		Assert.assertEquals(a2.getCpf(), "98765432101");
	}

	@Test
	public void testeAtualizaAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find("56473890213");
		a.setNome("Rosa Ferreira Lopes");
		dao.update(a);
		Aluno a2 = dao.find("56473890213");
		Assert.assertEquals(a2.getNome(), "Rosa Ferreira Lopes");
	}

	@Test
	public void testeExcluirAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find("54738906543");
		dao.delete(a);
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 2);
	}

	@Test
	public void testeSelecionarTodosAluno() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 3);
	}

	@Before
	public void preparaBancoProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor p1 = new Professor(null, "Lucas", "76438923561", new BigDecimal(
				123456));
		Professor p2 = new Professor(null, "Pedro", "12345678912",
				new BigDecimal(123456));
		Professor p3 = new Professor(null, "Julia", "12345678912",
				new BigDecimal(123456));
		dao.insert(p1);
		dao.insert(p2);
		dao.insert(p3);
	}

	@After
	public void limpaBancoProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		dao.clean();
	}

	@Test
	public void testeBuscarProfessor() {

		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(2L);
		Assert.assertEquals(a.getCpf(), "12345678912");
	}

	@Test
	public void testeInsertProfessor() {

		ProfessorDAO dao = new ProfessorDAO();
		Professor p = new Professor(null, "Frederico Lopes", "16382974536",
				new BigDecimal("50750"));
		dao.insert(p);
		Professor p2 = dao.find(4L);
		Assert.assertEquals(p2.getCpf(), "16382974536");
	}

	@Test
	public void testeAtualizaProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor p = dao.find("76438923561");
		p.setNome("Lucas Lopes");
		dao.update(p);
		Professor p1 = dao.find("76438923561");
		Assert.assertEquals(p1.getNome(), "Lucas Lopes");
	}
	
	
	@Test
	public void testeExcluirProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor p = dao.find("76438923561");
		dao.delete(p);
		List<Professor> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 2);
	}

	@Test
	public void testeSelecionarTodosProfessor() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 3);
	}

}