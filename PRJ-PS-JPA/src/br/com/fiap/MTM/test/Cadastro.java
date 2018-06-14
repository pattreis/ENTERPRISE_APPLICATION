package br.com.fiap.MTM.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.MTM.entity.Compra;
import br.com.fiap.MTM.entity.Item;
import br.com.fiap.dao.CompraDAO;
import br.com.fiap.dao.impl.CompraDAOImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CompraDAO dao = new CompraDAOImpl(em);

		Item item = new Item();
		item.setNome("Bolacha de chocolate");
		item.setPreco(2.5);
		item.setQuantidade(2);

		Item item2 = new Item();
		item2.setNome("Refrigerante Guaraná Antartica");
		item2.setPreco(5.6);
		item2.setQuantidade(3);

		Compra compra = new Compra();
		compra.setDataCompra(new GregorianCalendar(2018, Calendar.JUNE, 17));
		compra.addItem(item);
		compra.addItem(item2);

		dao.inserir(compra);
		dao.commit();

		System.out.println("Cadastrado!");

		em.close();
	}
}
