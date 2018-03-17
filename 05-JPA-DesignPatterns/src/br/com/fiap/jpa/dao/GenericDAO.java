package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundException;

public interface GenericDAO<T, K> {

	void insert(T object);

	void update(T object);

	T find(K id);

	void remove(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;

}
