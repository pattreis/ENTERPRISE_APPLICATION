package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "T_ESTUDO_PS_LIVRO")
@SequenceGenerator(name = "livro", sequenceName = "SQ_T_ESTUDO_PS_LIVRO", allocationSize = 1)

public class Livro {

	@Id
	@Column(name = "CD_LIVRO")
	@GeneratedValue(generator = "livro", strategy = GenerationType.IDENTITY)
	private int codigo;

	private String titulo;

	private Calendar dtlancamento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_autor")
	private Autor autor;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "livros")
	private List<Livraria> livrarias;

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

	public Calendar getDtlancamento() {
		return dtlancamento;
	}

	public void setDtlancamento(Calendar dtlancamento) {
		this.dtlancamento = dtlancamento;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Livraria> getLivrarias() {
		return livrarias;
	}

	public void setLivrarias(List<Livraria> livrarias) {
		this.livrarias = livrarias;
	}

}
