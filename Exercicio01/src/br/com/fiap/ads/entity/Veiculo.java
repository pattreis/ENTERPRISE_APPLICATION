package br.com.fiap.ads.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VEICULO")
@SequenceGenerator(name = "veiculo", sequenceName = "SQ_TB_VEICULO", allocationSize = 1)
public class Veiculo implements Serializable {

	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(generator = "veiculo", strategy = GenerationType.SEQUENCE)
	private int cd_veiculo;

	@Column(name = "ds_placa", nullable = false, length = 100)
	private String ds_placa;

	@Column(name = "ds_cor", length = 50)
	private String ds_cor;

	@Column(name = "nr_ano")
	private int nr_ano;

	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Veiculo(int cd_veiculo, String ds_placa, String ds_cor, int nr_ano) {
		super();
		this.cd_veiculo = cd_veiculo;
		this.ds_placa = ds_placa;
		this.ds_cor = ds_cor;
		this.nr_ano = nr_ano;
	}

	public int getCd_veiculo() {
		return cd_veiculo;
	}

	public void setCd_veiculo(int cd_veiculo) {
		this.cd_veiculo = cd_veiculo;
	}

	public String getDs_placa() {
		return ds_placa;
	}

	public void setDs_placa(String ds_placa) {
		this.ds_placa = ds_placa;
	}

	public String getDs_cor() {
		return ds_cor;
	}

	public void setDs_cor(String ds_cor) {
		this.ds_cor = ds_cor;
	}

	public int getNr_ano() {
		return nr_ano;
	}

	public void setNr_ano(int nr_ano) {
		this.nr_ano = nr_ano;
	}

}
