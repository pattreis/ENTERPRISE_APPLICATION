package br.com.fiap.dao.data;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class LivroData {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAO dao = new LivroDAOImpl(em);

		Autor autor = new Autor();
		autor.setNome("J.R.R. Tolken");

		Autor autor2 = new Autor();
		autor2.setNome("George R.R. Martin");

		Autor autor3 = new Autor();
		autor3.setNome("J.K. Rowling");

		Autor autor4 = new Autor();
		autor4.setNome("Clive Staples Lewis");

		Autor autor5 = new Autor();
		autor5.setNome("Cassandra Clare");

		Livro livro = new Livro();
		livro.setAutor(autor);
		livro.setTitulo("O Senhor dos Anéis");
		livro.setLancamento(new GregorianCalendar(1954, Calendar.JULY, 29));

		Livro livro2 = new Livro();
		livro2.setAutor(autor2);
		livro2.setTitulo("Game of Thrones");
		livro2.setLancamento(new GregorianCalendar(1996, Calendar.AUGUST, 1));

		Livro livro3 = new Livro();
		livro3.setAutor(autor3);
		livro3.setTitulo("Harry Potter - E a Pedra Filosofal");
		livro3.setLancamento(new GregorianCalendar(1997, Calendar.JUNE, 26));

		Livro livro4 = new Livro();
		livro4.setAutor(autor4);
		livro4.setTitulo("As Crônicas de Nárnia - Príncipe Caspian");
		livro4.setLancamento(new GregorianCalendar(1951, Calendar.OCTOBER, 15));

		Livro livro5 = new Livro();
		livro5.setAutor(autor5);
		livro5.setTitulo("Cidade de Vidro");
		livro5.setLancamento(new GregorianCalendar(2009, Calendar.MARCH, 24));

		dao.inserir(livro);
		dao.inserir(livro2);
		dao.inserir(livro3);
		dao.inserir(livro4);
		dao.inserir(livro5);

		dao.commit();

	}
}
