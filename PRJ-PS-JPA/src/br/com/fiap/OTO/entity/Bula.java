package br.com.fiap.OTO.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PS_ESTUDO_JPA_BULA")
@SequenceGenerator(name = "bula", sequenceName = "SQ_T_PS_ESTUDO_JPA_BULA", allocationSize = 1)
public class Bula {
	@Id
	@Column(name = "cd_bula")
	@GeneratedValue(generator = "bula", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_recomendacao")
	private String recomendacao;

	@Column(name = "sintoma")
	@Enumerated(EnumType.STRING)
	private Sintoma sintoma;

	@OneToOne(mappedBy = "bula", cascade = CascadeType.ALL)
	private Remedio remedio;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}
}
