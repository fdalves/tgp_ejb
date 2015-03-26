package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projeto database table.
 * 
 */
@Entity


@NamedQueries(
{@NamedQuery(name="Projeto.findAll", query="SELECT p FROM Projeto p"),
@NamedQuery(name="Projeto.findByNome", query="SELECT p from Projeto p where p.nomeProjeto = :nomeProjeto"),
@NamedQuery(name="Projeto.findBySigla", query="SELECT p from Projeto p where p.siglaProjeto = :siglaProjeto")})


public class Projeto implements Serializable {
	public List<DocProjeto> getDocAtividades() {
		return docAtividades;
	}

	public void setDocAtividades(List<DocProjeto> docAtividades) {
		this.docAtividades = docAtividades;
	}

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_NOME = "Projeto.findByNome";
	public static final String FIND_BY_SIGLA = "Projeto.findBySigla";
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="projeto_id")
	private int projetoId;

	@Column(name="desc_projeto")
	private String descProjeto;

	@Column(name="nome_projeto")
	private String nomeProjeto;

	@Column(name="sigla_projeto")
	private String siglaProjeto;
	
	@Column(name="escopo_fechado")
	private Boolean escopoFecahdo;
	
	@Column(name="data_ini")
	private Date data_ini;
	
	@Column(name="data_fim")
	private Date data_fim;

	//bi-directional many-to-one association to Atividade
	@OneToMany(mappedBy="projeto")
	private List<Atividade> atividades;

	//bi-directional many-to-one association to UsuarioProjeto
	@OneToMany(mappedBy="projeto",fetch = FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<UsuarioProjeto> usuarioProjetos;
	
	
	//bi-directional many-to-one association to DocAtividade
	@OneToMany(mappedBy="projeto")
	private List<DocProjeto> docAtividades;

	public Projeto() {
	}

	public int getProjetoId() {
		return this.projetoId;
	}

	public void setProjetoId(int projetoId) {
		this.projetoId = projetoId;
	}

	public String getDescProjeto() {
		return this.descProjeto;
	}

	public void setDescProjeto(String descProjeto) {
		this.descProjeto = descProjeto;
	}

	public String getNomeProjeto() {
		return this.nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getSiglaProjeto() {
		return this.siglaProjeto;
	}

	public void setSiglaProjeto(String siglaProjeto) {
		this.siglaProjeto = siglaProjeto;
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Atividade addAtividade(Atividade atividade) {
		getAtividades().add(atividade);
		atividade.setProjeto(this);

		return atividade;
	}

	public Atividade removeAtividade(Atividade atividade) {
		getAtividades().remove(atividade);
		atividade.setProjeto(null);

		return atividade;
	}

	public List<UsuarioProjeto> getUsuarioProjetos() {
		return this.usuarioProjetos;
	}

	public void setUsuarioProjetos(List<UsuarioProjeto> usuarioProjetos) {
		this.usuarioProjetos = usuarioProjetos;
	}

	public UsuarioProjeto addUsuarioProjeto(UsuarioProjeto usuarioProjeto) {
		getUsuarioProjetos().add(usuarioProjeto);
		usuarioProjeto.setProjeto(this);

		return usuarioProjeto;
	}

	public UsuarioProjeto removeUsuarioProjeto(UsuarioProjeto usuarioProjeto) {
		getUsuarioProjetos().remove(usuarioProjeto);
		usuarioProjeto.setProjeto(null);

		return usuarioProjeto;
	}

	public Boolean getEscopoFecahdo() {
		return escopoFecahdo;
	}

	public void setEscopoFecahdo(Boolean escopoFecahdo) {
		this.escopoFecahdo = escopoFecahdo;
	}

	public Date getData_ini() {
		return data_ini;
	}

	public void setData_ini(Date data_ini) {
		this.data_ini = data_ini;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	
	
}