package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_atividade database table.
 * 
 */
@Entity
@Table(name="usuario_atividade")
@NamedQuery(name="UsuarioAtividade.findAll", query="SELECT u FROM UsuarioAtividade u")
public class UsuarioAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_atividade_id")
	private int usuarioAtividadeId;

	@Column(name="desc_cargo")
	private String descCargo;

	//bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name="aitividade_id")
	private Atividade atividade;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="cargo_id")
	private Cargo cargo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public UsuarioAtividade() {
	}

	public int getUsuarioAtividadeId() {
		return this.usuarioAtividadeId;
	}

	public void setUsuarioAtividadeId(int usuarioAtividadeId) {
		this.usuarioAtividadeId = usuarioAtividadeId;
	}

	public String getDescCargo() {
		return this.descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}