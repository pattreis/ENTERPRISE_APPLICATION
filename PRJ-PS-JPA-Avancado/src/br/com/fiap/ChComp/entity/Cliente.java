package br.com.fiap.ChComp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PS_ESTUDO_JPA_AVANCADO_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_T_PS_ESTUDO_JPA_AVANCADO_CLIENTE", allocationSize = 1)
public class Cliente {
	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_cliente")
	private String nome;

	private String cpf;

	private int idade;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
