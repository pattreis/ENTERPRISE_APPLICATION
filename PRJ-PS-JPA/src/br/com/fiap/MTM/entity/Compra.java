package br.com.fiap.MTM.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PS_ESTUDO_JPA_COMPRA")
@SequenceGenerator(name = "compra", sequenceName = "SQ_T_PS_ESTUDO_JPA_COMPRA", allocationSize = 1)
public class Compra {
	@Id
	@Column(name = "cd_compra")
	@GeneratedValue(generator = "compra", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "dt_compra")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCompra;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_PS_ESTUDO_JPA_COMPRA_ITEM", joinColumns = {
			@JoinColumn(name = "cd_compra") }, inverseJoinColumns = { @JoinColumn(name = "cd_item") })
	private List<Item> itens;

	public Compra() {
		setItens(new ArrayList<Item>());
	}

	public void addItem(Item novo) {
		this.itens.add(novo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
