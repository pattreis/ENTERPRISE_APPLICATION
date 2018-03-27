package br.com.fiap.ads.dao;

import br.com.fiap.ads.exception.CommitException;
import br.com.fiap.ads.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	T pesquisar(K codigo);
	
	void commit() throws CommitException;
	
}



