package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the usuario_projeto database table.
 * 
 */
@Entity
@Table(name="usuario_projeto")
@NamedQuery(name="UsuarioProjeto.findAll", query="SELECT u FROM UsuarioProjeto u")
public class UsuarioProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="usuario_projeto_id")
	private int usuarioProjetoId;

	//bi-directional many-to-one association to Projeto
	@ManyToOne
	@JoinColumn(name="projeto_id")
	private Projeto projeto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public UsuarioProjeto() {
	}

	public int getUsuarioProjetoId() {
		return this.usuarioProjetoId;
	}

	public void setUsuarioProjetoId(int usuarioProjetoId) {
		this.usuarioProjetoId = usuarioProjetoId;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}