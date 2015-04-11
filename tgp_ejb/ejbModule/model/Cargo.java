package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="cargo_id")
	private int cargoId;

	
	@OneToOne(optional=true)
    @JoinColumn(name="usuario_atividade_id", unique=true, nullable=true)	
	private UsuarioAtividade usuarioAtividade;
	
	
	@Column(name="testador")
	private boolean testador;
	@Column(name="programador")
	private boolean programador;
	@Column(name="analista")
	private boolean analista;
	@Column(name="gerente")
	private boolean gerente;
	
	public Cargo() {
	}

	public int getCargoId() {
		return cargoId;
	}

	public void setCargoId(int cargoId) {
		this.cargoId = cargoId;
	}

	public UsuarioAtividade getUsuarioAtividade() {
		return usuarioAtividade;
	}

	public void setUsuarioAtividade(UsuarioAtividade usuarioAtividade) {
		this.usuarioAtividade = usuarioAtividade;
	}

	public boolean isTestador() {
		return testador;
	}

	public void setTestador(boolean testador) {
		this.testador = testador;
	}

	public boolean isProgramador() {
		return programador;
	}

	public void setProgramador(boolean programador) {
		this.programador = programador;
	}

	public boolean isAnalista() {
		return analista;
	}

	public void setAnalista(boolean analista) {
		this.analista = analista;
	}

	public boolean isGerente() {
		return gerente;
	}

	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}

	
	
	

	

}