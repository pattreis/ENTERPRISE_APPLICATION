package br.com.fiap.MTM.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PS_ESTUDO_JPA_ITEM")
@SequenceGenerator(name = "item", sequenceName = "SQ_PS_ESTUDO_JPA_ITEM", allocationSize = 1)
public class Item {
	@Id
	@Column(name = "cd_item")
	@GeneratedValue(generator = "item", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_cliente")
	private String nome;

	@Column(name = "nr_quantidade")
	private int quantidade;

	@Column(name = "vl_preco")
	private double preco;

	@ManyToMany(mappedBy = "itens", cascade = CascadeType.ALL)
	private List<Compra> compras;

	public Item() {
		setCompras(new ArrayList<Compra>());
	}

	public void addCompra(Compra nova) {
		this.compras.add(nova);
	}

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}
