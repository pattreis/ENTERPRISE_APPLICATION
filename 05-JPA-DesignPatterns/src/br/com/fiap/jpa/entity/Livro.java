package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_LIVRO")
@SequenceGenerator(name = "livro", sequenceName = "SQ_T_LIVRO", allocationSize = 1)
public class Livro {

	@Id
	@GeneratedValue(generator = "livro", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_livro")
	private int codigo;

	@Column(name = "nm_titulo")
	private String titulo;

	@Column(name = "nm_autor")
	private String autor;
	
	public Livro() {
		super();
	}

	public Livro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
