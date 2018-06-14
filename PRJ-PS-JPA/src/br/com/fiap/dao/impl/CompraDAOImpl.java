package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.MTM.entity.Compra;
import br.com.fiap.dao.CompraDAO;

public class CompraDAOImpl extends GenericDAOImpl<Compra, Integer> implements CompraDAO {
	public CompraDAOImpl(EntityManager em) {
		super(em);
	}
}
