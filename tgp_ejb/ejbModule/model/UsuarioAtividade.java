package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the usuario_atividade database table.
 * 
 */
@Entity(name="UsuarioAtividade")
@Table(name="usuario_atividade")
@NamedQueries(
{@NamedQuery(name="UsuarioAtividade.findAll", query="SELECT u FROM UsuarioAtividade u"),
 @NamedQuery(name="UsuarioAtividade.findByAtividade", query="SELECT u FROM UsuarioAtividade u where u.atividade.atividadeId = :atividadeId "),
 @NamedQuery(name="UsuarioAtividade.findByUsuario", query="SELECT u FROM UsuarioAtividade u where u.usuario.usuarioId = :usuarioId ")})

public class UsuarioAtividade implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_ATIVIDADE = "UsuarioAtividade.findByAtividade";
	public static final String FIND_BY_USUARIO = "UsuarioAtividade.findByUsuario";

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="usuario_atividade_id")
	private int usuarioAtividadeId;

	private int tempId;
	
	@Column(name="desc_cargo")
	private String descCargo;
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//bi-directional many-to-one association to Atividade
	@ManyToOne
	@JoinColumn(name="atividade_id")
	private Atividade atividade;

	//bi-directional many-o-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@OneToOne(optional=true, mappedBy="usuarioAtividade")
    private Cargo cargo;
	
	
	@Column(name="horas_apropriadas")
	private Integer horasApropriadas;
	
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

	

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public int getTempId() {
		return tempId;
	}

	public void setTempId(int tempId) {
		this.tempId = tempId;
	}

	public Integer getHorasApropriadas() {
		return horasApropriadas;
	}

	public void setHorasApropriadas(Integer horasApropriadas) {
		this.horasApropriadas = horasApropriadas;
	}
	
	

}