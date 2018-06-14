package br.com.fiap.MTM.test;

import javax.persistence.EntityManager;

import br.com.fiap.MTM.entity.Compra;
import br.com.fiap.MTM.entity.Item;
import br.com.fiap.dao.CompraDAO;
import br.com.fiap.dao.impl.CompraDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Listagem {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);

		System.out.println("COMPRAS");
		for (Compra c : dao.listar()) {
			System.out.println(c.getCodigo());
			System.out.println(c.getDataCompra());
			System.out.println("ITENS");
			for (Item i : c.getItens()) {
				System.out.println(i.getCodigo());
				System.out.println(i.getNome());
				System.out.println(i.getPreco());
				System.out.println(i.getQuantidade());
			}
		}

		em.close();
	}
}
