package br.com.fiap.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Livro;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class ConsultasJPQL {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAO dao = new LivroDAOImpl(em);
		List<Livro> lista = null;
		Livro livro = null;

		lista = dao.listaPorData(new GregorianCalendar(1990, Calendar.JANUARY, 1),
				new GregorianCalendar(2018, Calendar.JUNE, 12));
		System.out.println("BUSCA LIVROS ENTRE DATAS INICIO E FIM");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Livro: " + lista.get(i).getTitulo());
		}

		lista = dao.listaPorTitulo("Har");
		System.out.println("");
		System.out.println("BUSCA POR NOME");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Livro: " + lista.get(i).getTitulo());
		}

		System.out.println("");
		System.out.println("TOTAL DE LIVROS CADASTRADOS: " + dao.totalLivros());

		lista = dao.listaPorNomeAutor("J.");
		System.out.println("");
		System.out.println("LISTA POR NOME DO AUTOR");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getCodigo());
			System.out.println("Livro: " + lista.get(i).getTitulo());
			System.out.println("Autor " + lista.get(i).getAutor().getNome());
		}

		livro = dao.pesquisaPorAutor("C");
		System.out.println("");
		System.out.println("PESQUISA POR NOME DO AUTOR");
		System.out.println(livro.getCodigo());
		System.out.println("Livro: " + livro.getTitulo());
		System.out.println("Autor: " + livro.getAutor().getNome());

		em.close();
	}
}
