package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class TesteBusca {
	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();

		PedidoDAO pedidoDao = new PedidoDAOImpl(em);

		Pedido pedido = pedidoDao.pesquisar(1);
		System.out.println("Pedido "+ pedido.getDescricao());
		System.out.println("Pedido "+ pedido.getNota());
		
		
		
		em.close();
		factory.close();
	}

}
