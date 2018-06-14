package br.com.fiap.OTO.test;

import javax.persistence.EntityManager;

import br.com.fiap.OTO.entity.Remedio;
import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.dao.impl.RemedioDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Listagem {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		RemedioDAO dao = new RemedioDAOImpl(em);

		System.out.println("REMEDIOS");
		for (Remedio r : dao.listar()) {
			System.out.println(r.getCodigo());
			System.out.println(r.getNome());
			System.out.println(r.getDescricao());
			System.out.println(r.getVencimento());
			System.out.println(r.getBula().getRecomendacao());
			System.out.println(r.getBula().getSintoma());
		}

		em.close();
	}
}
