package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the tipo_usuario database table.
 * 
 */
@Entity(name="ConfigAtividade")
@Table(name="config_atividade")
@NamedQuery(name="ConfigAtividade.findAll", query="SELECT c FROM ConfigAtividade c")
public class ConfigAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="config_atividade_id")
	private int configAtividadeId;

	@Column(name="quant_horas_dias")
	private float quantHorasDias;

	@Column(name="quant_dias_feriado_folga")
	private int quantDiasFolgaFeriado;
	
	@Column(name="trab_sab")
	private boolean trabSab;
	
	@Column(name="trab_dom")
	private boolean trabDom;
	
	@OneToOne(optional=true)
    @JoinColumn(name="atividade_id", unique=true, nullable=true)
    public Atividade atividade;	

	public ConfigAtividade() {
	}

	public int getConfigAtividadeId() {
		return configAtividadeId;
	}

	public void setConfigAtividadeId(int configAtividadeId) {
		this.configAtividadeId = configAtividadeId;
	}

	

	public float getQuantHorasDias() {
		return quantHorasDias;
	}

	public void setQuantHorasDias(float quantHorasDias) {
		this.quantHorasDias = quantHorasDias;
	}

	public int getQuantDiasFolgaFeriado() {
		return quantDiasFolgaFeriado;
	}

	public void setQuantDiasFolgaFeriado(int quantDiasFolgaFeriado) {
		this.quantDiasFolgaFeriado = quantDiasFolgaFeriado;
	}

	public boolean isTrabSab() {
		return trabSab;
	}

	public void setTrabSab(boolean trabSab) {
		this.trabSab = trabSab;
	}

	public boolean isTrabDom() {
		return trabDom;
	}

	public void setTrabDom(boolean trabDom) {
		this.trabDom = trabDom;
	}

	
	

}