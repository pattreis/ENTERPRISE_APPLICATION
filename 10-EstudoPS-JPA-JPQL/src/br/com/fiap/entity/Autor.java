package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="T_ESTUDO_PS_AUTOR")
@SequenceGenerator(name="autor", sequenceName="SQ_T_ESTUDO_PS_AUTOR", allocationSize = 1)
public class Autor {

	@Id
	@Column(name="cd_autor")
	@GeneratedValue(generator="autor", strategy=GenerationType.IDENTITY)
	private int codigo;	
	
	@Column(name="nm_autor", length = 100, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy="autor", cascade = CascadeType.ALL, orphanRemoval=true )
	private List<Livro> livros;	
	
	public Autor() {
		setLivros(new ArrayList<Livro>());
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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
}
