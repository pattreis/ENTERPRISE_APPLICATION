package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.entity.NotaFiscal;

public class NotaFiscalDAOImpl extends GenericDAOImpl<NotaFiscal, Integer> implements GenericDAO<NotaFiscal, Integer> {

	public NotaFiscalDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
}
