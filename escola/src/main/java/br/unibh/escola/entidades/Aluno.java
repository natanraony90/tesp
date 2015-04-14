package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

	@Entity
	@Table(name = "TB_ALUNO")
	public class Aluno extends Pessoa {

	@NotBlank
	@NotNull
	@Column(unique = true)
	private Long matricula;

	@NotNull
	@Column(name = "dataAniversairo")
	@Temporal(value = TemporalType.DATE)
	private Date dataAniversairo;

	public Aluno(Long id, Long matricula, String nome, String cpf,
			Date dataAniversairo) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversairo = dataAniversairo;
	}

	public Aluno(Long id, Long matricula, String nome, String cpf) {
		super(id, nome, cpf);
		this.matricula = matricula;
	}

	public Aluno(Long id, Long matricula, String nome) {
		super(id, nome, null);
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

	public static boolean verificaMatricula(String matricula) {
		if (matricula == null) {
			return false;
		} else if (matricula.trim().equals("")) {
			return false;
		} else if (matricula.length() != 8) {
			return false;

		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "Aluno [matricula=" + matricula
				+ ", dataAniversairo=" + dataAniversairo + "]";
	}

}
