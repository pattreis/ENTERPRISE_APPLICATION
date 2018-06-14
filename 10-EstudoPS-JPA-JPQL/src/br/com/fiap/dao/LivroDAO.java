package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer>{

	List<Livro> listarPorData(Calendar inicio, Calendar fim);
	
	List<Livro> listarPorNome(String nome);
	
	Livro pesquisar(String nome);
	
	long pesquisarQuantidadeLivro();
	
	Livro pesquisarPorAutor(String nome);
	
	List<Livro> listarPorAtutor(String nome);
	
	Livro pesquisarPorLivraria(String nome);
	
	List<Livro> listarPorLivraria(String nome);
}
