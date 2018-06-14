package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.OTO.entity.Bula;
import br.com.fiap.dao.BulaDAO;

public class BulaDAOImpl extends GenericDAOImpl<Bula, Integer> implements BulaDAO {
	public BulaDAOImpl(EntityManager em) {
		super(em);
	}
}
