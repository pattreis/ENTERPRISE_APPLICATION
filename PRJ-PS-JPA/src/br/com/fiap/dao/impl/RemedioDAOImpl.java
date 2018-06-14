package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.OTO.entity.Remedio;
import br.com.fiap.dao.RemedioDAO;

public class RemedioDAOImpl extends GenericDAOImpl<Remedio, Integer> implements RemedioDAO {
	public RemedioDAOImpl(EntityManager em) {
		super(em);
	}
}
