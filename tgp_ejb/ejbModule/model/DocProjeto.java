package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the doc_atividade database table.
 * 
 */
@Entity
@Table(name="doc_projeto")
@NamedQuery(name="DocProjeto.findAll", query="SELECT d FROM DocProjeto d")
public class DocProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="doc_projeto_id")
	private int docProjetoId;

	@Column(name="desc_doc")
	private String descDoc;

	@Lob
	private byte[] doc;

	@Column(name="local_fisico")
	private String localFisico;

	@Column(name="nome_doc")
	private String nomeDoc;

	//bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name="projeto_id")
	private Projeto projeto;

	public DocProjeto() {
	}

	public int getDocProjetoId() {
		return docProjetoId;
	}

	public void setDocProjetoId(int docProjetoId) {
		this.docProjetoId = docProjetoId;
	}

	public String getDescDoc() {
		return descDoc;
	}

	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	public String getLocalFisico() {
		return localFisico;
	}

	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}

	public String getNomeDoc() {
		return nomeDoc;
	}

	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	
	
	
	
}