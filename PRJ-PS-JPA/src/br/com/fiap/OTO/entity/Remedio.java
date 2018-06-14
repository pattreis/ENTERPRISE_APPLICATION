package br.com.fiap.OTO.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PS_ESTUDO_JPA_REMEDIO")
@SequenceGenerator(name = "remedio", sequenceName = "SQ_T_PS_ESTUDO_JPA_REMEDIO", allocationSize = 1)
public class Remedio {
	@Id
	@Column(name = "cd_remedio")
	@GeneratedValue(generator = "remedio", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_remedio")
	private String nome;

	@Column(name = "ds_remedio")
	private String descricao;

	@Column(name = "dt_vencimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar vencimento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_bula")
	private Bula bula;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public Bula getBula() {
		return bula;
	}

	public void setBula(Bula bula) {
		this.bula = bula;
	}
}
