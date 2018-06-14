package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.OTM.entity.Autor;
import br.com.fiap.dao.AutorDAO;

public class AutorDAOImpl extends GenericDAOImpl<Autor, Integer> implements AutorDAO {
	public AutorDAOImpl(EntityManager em) {
		super(em);
	}
}
