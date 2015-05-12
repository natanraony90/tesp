package br.unibh.escola.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_DISCIPLINA")
@NamedQueries({ @NamedQuery(name="Disciplina.findByNomeECurso", query = "select d from Disciplina a where d.nome and d.curso like :(nome) || (curso)")
})

public class Disciplina {
	
	public Disciplina(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@NotBlank
	@NotNull
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "nome", length = 100, nullable = false)
	private String curso;
	
	@NotNull
	@Max(160)
	private Long matricula;
	
	@NotNull
	@Column(name="tipo")
	private int tipo;
	
	@NotBlank
	@NotNull
	@Size(min = 5, max = 4000)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "nome", length = 4000, nullable = false)
	private String ementa;
	
	@NotBlank
	@NotNull
	@Size(min = 5, max = 4000)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "nome", length = 4000, nullable = false)
	private String bibliografia;
	
	@NotBlank
	@NotNull
	@Size(min = 5, max = 4000)
	@Pattern(regexp = "[A-Za-z À-ú ]*", message = "Deve conter apenas letras e espaços")
	@Column(name = "nome", length = 4000, nullable = false)
	private String distribuicaoAvaliacao;
	
	@NotBlank
	@Size(min = 5, max = 4000)
	@Column(name = "nome", length = 4000, nullable = false)
	private String observacao;
	
	@NotNull
	private Sala sala;

	@NotNull
	private Professor professor;
	
	@NotNull
	private List<Aluno> alunos;
	
	@Column(name = "versao")
	private int versao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getDistribuicaoAvaliacao() {
		return distribuicaoAvaliacao;
	}

	public void setDistribuicaoAvaliacao(String distribuicaoAvaliacao) {
		this.distribuicaoAvaliacao = distribuicaoAvaliacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}
	
}
