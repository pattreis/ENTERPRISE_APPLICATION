package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "T_MEDICO")
@SecondaryTable(name="T_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name = "cd_crm")
	private int crm;

	@Column(name = "nm_medico", nullable = false, length = 100)
	private String nome;

	@Column(name = "ds_especialidade", nullable = false, length = 100)
	private String especialidade;

	@Column(name="vl_salario", table = "T_MEDICO_FINANCEIRO")
	private double salario;
	
	@Column(name="nr_conta_corrente", table = "T_MEDICO_FINANCEIRO")
	private int contaCorrente;
	
	
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Medico(int crm, String nome, String especialidade, double salario, int contaCorrente) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
		this.salario = salario;
		this.contaCorrente = contaCorrente;
	}




	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
