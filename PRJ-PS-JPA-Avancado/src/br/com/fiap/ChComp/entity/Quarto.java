package br.com.fiap.ChComp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PS_ESTUDO_JPA_AVANCADO_QUARTO")
@SequenceGenerator(name = "quarto", sequenceName = "SQ_T_PS_ESTUDO_JPA_AVANCADO_QUARTO")
public class Quarto {
	@Id
	@Column(name = "cd_quarto")
	@GeneratedValue(generator = "quarto", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "tipo_quarto")
	@Enumerated(EnumType.STRING)
	private TipoQuarto tipo;

	@Column(name = "nr_comodos")
	private int comodos;

	@Column(name = "vl_preco")
	private double preco;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public int getComodos() {
		return comodos;
	}

	public void setComodos(int comodos) {
		this.comodos = comodos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
