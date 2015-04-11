package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity


@NamedQueries(
{@NamedQuery(name="Usuario.findAll",   query="SELECT u FROM Usuario u"),
@NamedQuery(name="Usuario.findByLogin", query="SELECT u from Usuario u where u.login = :login"),
@NamedQuery(name="Usuario.findByEmail", query="SELECT u from Usuario u where u.email = :email")})

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_LOGIN = "Usuario.findByLogin";
	public static final String FIND_BY_EMAIL = "Usuario.findByEmail";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="usuario_id")
	private int usuarioId;

	@Lob
	private byte[] foto;

	private String login;

	private String nome;

	private String senha;

	private String email;
	
	private String superUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name="ultimo_login")
	private Date ultimoLogin;

	

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="id_tipo_usuario_id")
	private TipoUsuario tipoUsuario;

	//bi-directional many-to-one association to UsuarioAtividade
	@OneToMany(mappedBy="usuario")
	private List<UsuarioAtividade> usuarioAtividades;

	//bi-directional many-to-one association to UsuarioProjeto
	@OneToMany(mappedBy="usuario")
	private List<UsuarioProjeto> usuarioProjetos;

	public Usuario() {
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoLogin() {
		return this.ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<UsuarioAtividade> getUsuarioAtividades() {
		return this.usuarioAtividades;
	}

	public void setUsuarioAtividades(List<UsuarioAtividade> usuarioAtividades) {
		this.usuarioAtividades = usuarioAtividades;
	}

	public UsuarioAtividade addUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		getUsuarioAtividades().add(usuarioAtividade);
		usuarioAtividade.setUsuario(this);

		return usuarioAtividade;
	}

	public UsuarioAtividade removeUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		getUsuarioAtividades().remove(usuarioAtividade);
		usuarioAtividade.setUsuario(null);

		return usuarioAtividade;
	}

	public List<UsuarioProjeto> getUsuarioProjetos() {
		return this.usuarioProjetos;
	}

	public void setUsuarioProjetos(List<UsuarioProjeto> usuarioProjetos) {
		this.usuarioProjetos = usuarioProjetos;
	}

	public UsuarioProjeto addUsuarioProjeto(UsuarioProjeto usuarioProjeto) {
		getUsuarioProjetos().add(usuarioProjeto);
		usuarioProjeto.setUsuario(this);

		return usuarioProjeto;
	}

	public UsuarioProjeto removeUsuarioProjeto(UsuarioProjeto usuarioProjeto) {
		getUsuarioProjetos().remove(usuarioProjeto);
		usuarioProjeto.setUsuario(null);

		return usuarioProjeto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSuperUser() {
		return superUser;
	}

	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}
	
	

}