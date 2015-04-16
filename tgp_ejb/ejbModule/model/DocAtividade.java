package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the doc_atividade database table.
 * 
 */
@Entity
@Table(name="doc_atividade")
@NamedQuery(name="DocAtividade.findAll", query="SELECT d FROM DocAtividade d")
public class DocAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="doc_atividade_id")
	private int docAtividadeId;

	@Column(name="desc_doc")
	private String descDoc;

	@Lob
	private byte[] doc;

	@Column(name="local_fisico")
	private String localFisico;

	@Column(name="nome_doc")
	private String nomeDoc;
	
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="extensao")
	private String extensao;

	//bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name="atividade_id")
	private Atividade atividade;

	public DocAtividade() {
	}

	public int getDocAtividadeId() {
		return this.docAtividadeId;
	}

	public void setDocAtividadeId(int docAtividadeId) {
		this.docAtividadeId = docAtividadeId;
	}

	public String getDescDoc() {
		return this.descDoc;
	}

	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}

	public byte[] getDoc() {
		return this.doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	public String getLocalFisico() {
		return this.localFisico;
	}

	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}

	public String getNomeDoc() {
		return this.nomeDoc;
	}

	public void setNomeDoc(String nomeDoc) {
		this.nomeDoc = nomeDoc;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	

}