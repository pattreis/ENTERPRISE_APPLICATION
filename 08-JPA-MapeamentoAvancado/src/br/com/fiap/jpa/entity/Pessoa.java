package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Pessoa")// @DiscriminatorValue TODOS AS PESSOAS SERÃO GRAVADOS COMO "PESSOA"

@Entity
@Table(name = "T_PESSOA")
@SequenceGenerator(name = "pessoa", sequenceName = "SQ_T_PESSOA", allocationSize = 1)
public class Pessoa {

	@Id
	@Column(name = "cd_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_pessoa", length = 100, nullable = false)
	private String nome;

	@Column(name = "ds_endereco", length = 200)
	private String endereco;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
