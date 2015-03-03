package br.unibh;

import java.util.Date;

public class Aluno extends Pessoa{
	
	private Long matricula;
	private Date dataAniversairo;
	
	
	public Aluno(Long matricula, String nome, String cpf, Date dataAniversairo) {
		super(nome, cpf);
		this.matricula = matricula;
		this.dataAniversairo = dataAniversairo;
	}
	
		
	
	public Aluno(Long matricula, String nome, String cpf) {
		super(nome, cpf);
		this.matricula = matricula;
	}
	
	
	public Aluno(Long matricula, String nome) {
		super(nome, null);
		this.matricula = matricula;
	}



	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	public Date getDataAniversairo() {
		return dataAniversairo;
	}
	public void setDataAniversairo(Date dataAniversairo) {
		this.dataAniversairo = dataAniversairo;
	}



	@Override
	public String toString() {
		return super.toString()+ "Aluno [matricula=" + matricula + ", dataAniversairo="
				+ dataAniversairo + "]";
	}


	
	
	
	
	

}
