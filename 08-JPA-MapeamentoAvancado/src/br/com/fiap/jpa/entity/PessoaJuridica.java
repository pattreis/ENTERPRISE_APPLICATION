package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorColumn(name="PJ") // TODOS AS PESSOAS JURIDICAS SERÃO GRAVADOS COMO "PJ"

@Entity
@Table(name = "T_PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa {

	@Column(name = "nr_cnpj")
	private String cnpj;

	@Column(name = "nm_razao_social")
	private String razao;

	public PessoaJuridica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaJuridica(String nome, String endereco, String cnpj, String razao) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.razao = razao;
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

}
