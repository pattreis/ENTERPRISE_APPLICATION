package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Livro")
@Table(name = "T_PS_ESTUDO_JPQL_LIVRO")
@SequenceGenerator(name = "livro", sequenceName = "SQ_T_PS_ESTUDO_JPA_LIVRO", allocationSize = 1)
public class Livro {
	@Id
	@Column(name = "cd_livro")
	@GeneratedValue(generator = "livro", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_titulo", length = 150, nullable = false)
	private String titulo;

	@Column(name = "dt_lancamento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lancamento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_autor")
	private Autor autor;

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

	public Calendar getLancamento() {
		return lancamento;
	}

	public void setLancamento(Calendar lancamento) {
		this.lancamento = lancamento;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
