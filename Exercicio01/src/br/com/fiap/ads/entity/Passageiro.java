package br.com.fiap.ads.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName="SQ_T_PASSAGEIRO")
public class Passageiro {
	
	@Id
	@Column(name="cd_passageiro")
	@GeneratedValue(generator="passageiro", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_passageiro", nullable=false, length=200)
	private String nm_passageiro;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private String dt_nascimento;
	
	@Column(name="ds_genero", length=200)
	private Genero genero;
	
	@OneToMany(mappedBy="passageiro")
	private List<Corrida> corridas;	
	
	
	public Passageiro(String passageiro, String dt_nascimento, Genero genero) {
		super();
		this.nm_passageiro = passageiro;
		this.dt_nascimento = dt_nascimento;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPassageiro() {
		return nm_passageiro;
	}

	public void setPassageiro(String passageiro) {
		this.nm_passageiro = passageiro;
	}

	public String getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(String dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}
	
	
	

}
