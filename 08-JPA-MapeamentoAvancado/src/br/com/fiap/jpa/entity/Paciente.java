package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PACIENTE")
@SequenceGenerator(name = "seqPaciente", sequenceName = "SQ_T_PACIENTE")
public class Paciente {

	@Id
	@Column(name = "cd_paciente")
	@GeneratedValue(generator = "seqPaciente", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_paciente", nullable = false, length = 100)
	private String nome;

	@Column(name = "dt_nascimetno")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtNascimento;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(String nome, Calendar dtNascimento) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
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

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
