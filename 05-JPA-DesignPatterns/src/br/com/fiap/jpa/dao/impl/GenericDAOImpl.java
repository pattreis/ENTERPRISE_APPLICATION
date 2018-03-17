package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EntityNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void insert(T object) {
		em.persist(object);
	}

	@Override
	public void update(T object) {
		em.merge(object);
	}

	@Override
	public T find(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void remove(K id) throws EntityNotFoundException {
		T entity = em.find(clazz, id);

		if (entity == null)
			throw new EntityNotFoundException("Entity not found.");

		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();

			e.printStackTrace();

			throw new CommitException("Unable to commit!");
		}
	}

}
