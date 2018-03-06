package br.com.fiap.ads.dao.impl;


import javax.persistence.EntityManager;
import br.com.fiap.ads.dao.MotoristaDAO;
import br.com.fiap.ads.entity.Motorista;
import br.com.fiap.ads.exception.CarNotFoundException;
import br.com.fiap.ads.exception.CommitException;

public class MotoristaDAOImpl {
	
	private EntityManager em;
	
	public MotoristaDAOImpl(EntityManager m) {
		super();
		this.em = em;
	}
	
	


}
