package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ChComp.entity.Reserva;
import br.com.fiap.dao.ReservaDAO;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva, Integer> implements ReservaDAO {
	public ReservaDAOImpl(EntityManager em) {
		super(em);
	}
}
