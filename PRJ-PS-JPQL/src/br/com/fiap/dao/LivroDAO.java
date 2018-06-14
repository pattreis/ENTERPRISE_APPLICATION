package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer> {
	List<Livro> listaPorData(Calendar inicio, Calendar fim);

	List<Livro> listaPorTitulo(String titulo);

	long totalLivros();

	List<Livro> listaPorNomeAutor(String autor);

	Livro pesquisaPorAutor(String autor);
}
