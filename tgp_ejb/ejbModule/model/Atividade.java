package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the atividade database table.
 * 
 */
@Entity
@NamedQuery(name="Atividade.findAll", query="SELECT a FROM Atividade a")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="aitividade_id")
	private int aitividadeId;

	@Column(name="atividade_nome")
	private String atividadeNome;

	@Column(name="desc_atividade")
	private String descAtividade;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_ini")
	private Date dtIni;

	//bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name="projeto_id")
	private Projeto projeto;

	//bi-directional many-to-one association to DocAtividade
	@OneToMany(mappedBy="atividade")
	private List<DocAtividade> docAtividades;

	//bi-directional many-to-one association to UsuarioAtividade
	@OneToMany(mappedBy="atividade")
	private List<UsuarioAtividade> usuarioAtividades;

	public Atividade() {
	}

	public int getAitividadeId() {
		return this.aitividadeId;
	}

	public void setAitividadeId(int aitividadeId) {
		this.aitividadeId = aitividadeId;
	}

	public String getAtividadeNome() {
		return this.atividadeNome;
	}

	public void setAtividadeNome(String atividadeNome) {
		this.atividadeNome = atividadeNome;
	}

	public String getDescAtividade() {
		return this.descAtividade;
	}

	public void setDescAtividade(String descAtividade) {
		this.descAtividade = descAtividade;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtIni() {
		return this.dtIni;
	}

	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<DocAtividade> getDocAtividades() {
		return this.docAtividades;
	}

	public void setDocAtividades(List<DocAtividade> docAtividades) {
		this.docAtividades = docAtividades;
	}

	public DocAtividade addDocAtividade(DocAtividade docAtividade) {
		getDocAtividades().add(docAtividade);
		docAtividade.setAtividade(this);

		return docAtividade;
	}

	public DocAtividade removeDocAtividade(DocAtividade docAtividade) {
		getDocAtividades().remove(docAtividade);
		docAtividade.setAtividade(null);

		return docAtividade;
	}

	public List<UsuarioAtividade> getUsuarioAtividades() {
		return this.usuarioAtividades;
	}

	public void setUsuarioAtividades(List<UsuarioAtividade> usuarioAtividades) {
		this.usuarioAtividades = usuarioAtividades;
	}

	public UsuarioAtividade addUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		getUsuarioAtividades().add(usuarioAtividade);
		usuarioAtividade.setAtividade(this);

		return usuarioAtividade;
	}

	public UsuarioAtividade removeUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		getUsuarioAtividades().remove(usuarioAtividade);
		usuarioAtividade.setAtividade(null);

		return usuarioAtividade;
	}

}