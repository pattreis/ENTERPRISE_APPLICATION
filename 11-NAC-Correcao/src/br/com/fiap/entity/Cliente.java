package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="NAC_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_NAC_CLIENTE", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(generator="cliente",strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="NM_CLIENTE", length=100, nullable = false)	
	private String nome;
	
	@Column(name="DT_NASCIMENO")
	@Temporal(TemporalType.DATE)
	private Calendar dtNasc;
	
	@Column(name="ST_SEXO")
	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

	@OneToMany(mappedBy="cliente")
	private List<Locacao> locacoes;
	
	
	
	public Cliente() {
		super();		
	}

	public Cliente(String nome, Calendar dtNasc, Sexo sexo) {
		super();
		this.nome = nome;
		this.dtNasc = dtNasc;
		this.sexo = sexo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOme() {
		return nome;
	}

	public void setOme(String ome) {
		this.nome = ome;
	}

	public Calendar getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Calendar dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}
