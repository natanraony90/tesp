package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


	@Entity
	@PrimaryKeyJoinColumn
	@Table(name = "TB_SALA", uniqueConstraints = @UniqueConstraint(columnNames = "capacidade"))
	@NamedQueries({ @NamedQuery(name = "Sala.findByCapacidade", query = "select s from Sala s where s.capacidade like :capacidade") })
	public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "codigo", length = 10, nullable = false, unique = true)
	private String codigo;
	
	@NotNull
	@Column(name = "capacidade", nullable = false)
	private int capacidade;
	
	
	@Column(name="qBranco", nullable=true) 
	private boolean qBranco;
	
	@Column(name="dtShow", nullable=true)
	private boolean dtShow;
	
	@Column(name="PC", nullable=true)
	private boolean PC;
	
	@Column(name = "observacao", length = 255, nullable = true)
	private String observacao;
	
	@Column(name="status", nullable=true)
	private int status;
	
	@Column(name="dataTerminoManutencao", nullable=true)
	@Temporal(value = TemporalType.DATE)
	private Date dataTerminoManutencao;
	
	public Sala(){}

	public Sala(Long id, String codigo, boolean qBranco, boolean dtShow, boolean PC, 
			String observacao, int status, Date dataTerminoManutencao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.qBranco = qBranco;
		this.dtShow = dtShow;
		this.PC = PC;
		this.observacao = observacao;
		this.status = status;
		this.dataTerminoManutencao = dataTerminoManutencao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isqBranco() {
		return qBranco;
	}

	public void setqBranco(boolean qBranco) {
		this.qBranco = qBranco;
	}

	public boolean isdtShow() {
		return dtShow;
	}

	public void setdtShow(boolean dtShow) {
		this.dtShow = dtShow;
	}

	public boolean isPC() {
		return PC;
	}

	public void setPC(boolean PC) {
		this.PC = PC;
	}

	public String getobservacao() {
		return observacao;
	}

	public void setobservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getstatus() {
		return status;
	}

	public void setstatus(int status) {
		this.status = status;
	}

	public Date getdataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setdataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", codigo=" + codigo + ", capacidade="
				+ capacidade + ", qBranco=" + qBranco + ", dtShow=" + dtShow
				+ ", PC=" + PC + ", observacao=" + observacao + ", status="
				+ status + ", dataTerminoManutencao=" + dataTerminoManutencao
				+ "]";
	}
	
	
	
	
}
