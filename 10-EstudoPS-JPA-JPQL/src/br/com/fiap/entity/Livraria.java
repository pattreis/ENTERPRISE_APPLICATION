package br.com.fiap.entity;

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

@Entity(name = "Livraria")
@Table(name = "T_ESTUDO_PS_LIVRARIA")
@SequenceGenerator(name = "livraria", sequenceName = "SQ_T_ESTUDO_PS_AUTOR", allocationSize = 1)
public class Livraria {

	@Id
	@Column(name = "cd_livraria")
	@GeneratedValue(generator = "livraria", strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(name = "nm_livraria", nullable = false, length = 150)
	private String nome;

	@ManyToMany
	@JoinTable(name = "T_ESTUDO_PS_LIVRARIA_LIVRO", joinColumns = {
			@JoinColumn(name = "cd_livraria") }, inverseJoinColumns = { @JoinColumn(name = "cd_livro") })
	private List<Livro> livros;

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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
