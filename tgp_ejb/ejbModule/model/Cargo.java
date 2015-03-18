package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cargo_id")
	private int cargoId;

	private String cargo;

	@Column(name="desc_cargo")
	private String descCargo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cargo")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to UsuarioAtividade
	@OneToMany(mappedBy="cargo")
	private List<UsuarioAtividade> usuarioAtividades;

	public Cargo() {
	}

	public int getCargoId() {
		return this.cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescCargo() {
		return this.descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCargo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCargo(null);

		return usuario;
	}

	public List<UsuarioAtividade> getUsuarioAtividades() {
		return this.usuarioAtividades;
	}

	public void setUsuarioAtividades(List<UsuarioAtividade> usuarioAtividades) {
		this.usuarioAtividades = usuarioAtividades;
	}

	public UsuarioAtividade addUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		getUsuarioAtividades().add(usuarioAtividade);
		usuarioAtividade.setCargo(this);

		return usuarioAtividade;
	}

	public UsuarioAtividade removeUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		getUsuarioAtividades().remove(usuarioAtividade);
		usuarioAtividade.setCargo(null);

		return usuarioAtividade;
	}

}