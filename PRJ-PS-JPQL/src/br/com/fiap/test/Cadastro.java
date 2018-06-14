package br.com.fiap.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		// COM Cascade
		LivroDAO dao = new LivroDAOImpl(em);

		Autor autor = new Autor();
		autor.setNome("J.R.R. Tolken");

		Livro livro = new Livro();
		livro.setAutor(autor);
		livro.setTitulo("O Senhor dos Anéis");
		livro.setLancamento(new GregorianCalendar(1954, Calendar.JULY, 29));

		dao.inserir(livro);
		dao.commit();

		System.out.println("Cadastrado!");

		em.close();
	}
}
