package br.com.fiap.OTM.test;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.KeyNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Remocao {
	public static void main(String[] args) throws KeyNotFoundException, CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAO dao = new LivroDAOImpl(em);

		dao.remover(2);
		dao.commit();

		System.out.println("Removido!");

		em.close();
	}
}
