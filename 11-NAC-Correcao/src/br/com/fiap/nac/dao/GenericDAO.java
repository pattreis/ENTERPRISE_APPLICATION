package br.com.fiap.nac.dao;

import java.util.List;

import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity);
	void remover(K codigo) throws IdNotFoundException;
	void alterar(T entity);
	T pesquisar(K codigo);
	
	List<T> listar();
	void salvar() throws DBException;
	
	
}
