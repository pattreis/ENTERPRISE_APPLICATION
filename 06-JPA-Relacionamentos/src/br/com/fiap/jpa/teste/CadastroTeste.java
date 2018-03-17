package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();

		PedidoDAOImpl pedidoDao = new PedidoDAOImpl(em);
		NotaFiscalDAOImpl notaDao = new NotaFiscalDAOImpl(em);

		Pedido pedido = new Pedido(Calendar.getInstance(), "Pizza");
		NotaFiscal notaFiscal = new NotaFiscal(Calendar.getInstance(), 35.90, pedido);

		try {
			
			//pedidoDao.inserir(pedido);
			notaDao.inserir(notaFiscal);
			notaDao.commit();
			

		} catch (CommitException e) {
			e.printStackTrace();
		}

		em.close();
		factory.close();

	}

}
