package br.com.fiap.ads.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_MOTORISTA")
public class Motorista implements Serializable {

	@Id
	@Column(name = "nr_carteira")
	private int nr_carteira;

	@Column(name = "nm_motorista", nullable = false, length = 100)
	private String nm_motorista;

	@Column(name = "dt_nascimento", length = 10)
	@Temporal(TemporalType.TIMESTAMP)
	private String dt_nascimento;

	@Lob
	@Column(name = "fl_carteira")
	private byte[] fl_carteira;

	@Column(name = "ds_genero")
	private GeneroMotorista ds_genero;

	@OneToMany(mappedBy = "motorista", cascade = CascadeType.PERSIST)
	private List<Corrida> corridas;

	public Motorista() {
		super();
	}

	public Motorista(int nr_carteira, String nm_motorista, String dt_nascimento, byte[] fl_carteira,
			GeneroMotorista ds_genero) {
		super();
		this.nr_carteira = nr_carteira;
		this.nm_motorista = nm_motorista;
		this.dt_nascimento = dt_nascimento;
		this.fl_carteira = fl_carteira;
		this.ds_genero = ds_genero;
	}

	public int getNr_carteira() {
		return nr_carteira;
	}

	public void setNr_carteira(int nr_carteira) {
		this.nr_carteira = nr_carteira;
	}

	public String getNm_motorista() {
		return nm_motorista;
	}

	public void setNm_motorista(String nm_motorista) {
		this.nm_motorista = nm_motorista;
	}

	public String getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public byte[] getFl_carteira() {
		return fl_carteira;
	}

	public void setFl_carteira(byte[] fl_carteira) {
		this.fl_carteira = fl_carteira;
	}

	public GeneroMotorista getDs_genero() {
		return ds_genero;
	}

	public void setDs_genero(GeneroMotorista ds_genero) {
		this.ds_genero = ds_genero;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

}
