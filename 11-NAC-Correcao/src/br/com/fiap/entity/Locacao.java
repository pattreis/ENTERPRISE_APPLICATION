package br.com.fiap.entity;

import java.util.Calendar;

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
@Table(name="NAC_LOCACAO")
@SequenceGenerator(name="locacao", sequenceName="SQ_NAC_LOCACAO", allocationSize = 1)
public class Locacao {

	@Id
	@Column(name="CD_LOCACAO")
	@GeneratedValue(generator="locacao", strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="DT_INICIO", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column(name="DT_FIM", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataFim;

	@ManyToOne
	@JoinColumn(name="cliente_codigo")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="apartamento_codigo")
	private Apartamento apartamento;
	
	
	public Locacao(Calendar dataInicio, Calendar dataFim) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	
	
	
}
