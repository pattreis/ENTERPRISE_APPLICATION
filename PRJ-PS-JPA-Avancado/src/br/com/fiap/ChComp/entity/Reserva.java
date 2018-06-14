package br.com.fiap.ChComp.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Reserva")
@Table(name = "T_PS_ESTUDO_JPA_AVANCADO_RESERVA")
@IdClass(ReservaPK.class)
@SequenceGenerator(name = "reserva", sequenceName = "SQ_T_PS_ESTUDO_JPA_AVANCADO_RESERVA", allocationSize = 1)
public class Reserva {
	@Id
	@Column(name = "cd_reserva")
	@GeneratedValue(generator = "reserva", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "dt_reserva")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataReserva;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_cliente")
	private Cliente cliente;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_quarto")
	private Quarto quarto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}
