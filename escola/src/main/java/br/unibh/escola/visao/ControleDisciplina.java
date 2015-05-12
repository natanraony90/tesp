package br.unibh.escola.visao;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.negocio.ServicoDisciplina;

@ManagedBean(name = "disciplinamb")
@ViewScoped
public class ControleDisciplina {
	@Inject
	private Logger log;
	@Inject
	private ServicoDisciplina sa;
	private Disciplina disciplina;
	private String nomeArg;
	private String cursoArg;
	private Long id;
	private List<Disciplina> disciplinas;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Disciplina");
		try {
			disciplinas = sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (disciplina.getId() == null) {
				disciplina = sa.insert(disciplina);
			} else {
				disciplina = sa.update(disciplina);
			}
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "
					+ e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel",
					facesMsg);
			return;
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Disciplina gravada com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			disciplinas = sa.findByNomeECurso(nomeArg, cursoArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		disciplina = new Disciplina();
	}

	public void cancelar() {
		disciplina = null;
	}

	public void editar() {
		try {
			disciplina = sa.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public void excluir() {
		try {
			sa.delete(sa.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}
	
	public String getTipoString(int t) {
		String result;

		switch(t){
		case 1:
			result = "Presencial";
			break;
		case 2:
			result = "À distância";
			break;
		case 3:
			result = "Presencial e à distância";
			break;
		default:
			result = "";
			break;
		}

		return result;
	}
}