package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MEDICO")

public class Medico {

	@Id
	@Column(name = "cd_crm")
	private int crm;

	@Column(name = "nm_medico", nullable = false, length = 100)
	private String nome;

	@Column(name = "ds_especialidade", nullable = false, length = 100)
	private String especialidade;

	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medico(int crm, String nome, String especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
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
