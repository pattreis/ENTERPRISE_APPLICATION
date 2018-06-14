package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.OTM.entity.Livro;
import br.com.fiap.dao.LivroDAO;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO {
	public LivroDAOImpl(EntityManager em) {
		super(em);
	}
}
