package br.com.fiap.ads.dao.impl;


import javax.persistence.EntityManager;

import br.com.fiap.ads.dao.GenericDAO;
import br.com.fiap.ads.dao.VeiculoDAO;
import br.com.fiap.ads.entity.Veiculo;
import br.com.fiap.ads.exception.CommitException;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements GenericDAO<Veiculo, Integer>{

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
