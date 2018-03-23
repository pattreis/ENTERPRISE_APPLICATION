package br.com.fiap.ads.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_CORRIDA")
@SequenceGenerator(name = "corrida", sequenceName = "SQ_T_CORRIDA")
public class Corrida {

	@Id
	@Column(name = "cd_corrida")
	@GeneratedValue(generator = "corrida", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_origem", nullable = false, length = 300)
	private String origem;

	@Column(name = "ds_destino", nullable = false, length = 300)
	private String destino;

	@Column(name = "dt_corrida")
	@Temporal(TemporalType.TIMESTAMP)
	private String dtCorrida;

	@Column(name = "vl_corrida", nullable = false)
	private double valor;

	@ManyToOne
	@JoinColumn(name = "cd_motorista")
	private Motorista motorista;

	public Corrida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Corrida(int codigo, String origem, String destino, String dtCorrida, double valor) {
		super();
		this.codigo = codigo;
		this.origem = origem;
		this.destino = destino;
		this.dtCorrida = dtCorrida;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDtCorrida() {
		return dtCorrida;
	}

	public void setDtCorrida(String dtCorrida) {
		this.dtCorrida = dtCorrida;
	}

	public double getVl_corrida() {
		return valor;
	}

	public void setVl_corrida(double valor) {
		this.valor = valor;
	}

}
