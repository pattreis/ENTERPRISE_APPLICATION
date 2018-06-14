package br.com.fiap.OTO.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.OTO.entity.Bula;
import br.com.fiap.OTO.entity.Remedio;
import br.com.fiap.OTO.entity.Sintoma;
import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.dao.impl.RemedioDAOImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		RemedioDAO dao = new RemedioDAOImpl(em);

		Bula bula = new Bula();
		bula.setRecomendacao("Tomar com água");
		bula.setSintoma(Sintoma.DOR);

		Remedio remedio = new Remedio();
		remedio.setNome("Doril");
		remedio.setDescricao("Remedio para dor de cabeça");
		remedio.setVencimento(new GregorianCalendar(2020, Calendar.AUGUST, 23));
		remedio.setBula(bula);

		dao.inserir(remedio);
		dao.commit();

		System.out.println("Cadastrado!");

		em.close();
	}
}
