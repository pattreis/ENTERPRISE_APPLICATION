package br.com.fiap.test;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AutorDAO;
import br.com.fiap.dao.LivroDAO;
import br.com.fiap.dao.impl.AutorDAOImpl;
import br.com.fiap.dao.impl.LivroDAOImpl;
import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Livro;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Listagem {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LivroDAO daoLivro = new LivroDAOImpl(em);
		AutorDAO daoAutor = new AutorDAOImpl(em);

		System.out.println("LISTAGEM DE LIVROS");
		for (Livro l : daoLivro.listar()) {
			System.out.println(l.getTitulo());
			System.out.println(l.getLancamento());
			System.out.println(l.getAutor().getNome());
		}

		System.out.println("LISTAGEM DE AUTORES");
		for (Autor a : daoAutor.listar()) {
			System.out.println(a.getNome());
			System.out.println("LIVROS");
			for (Livro l : a.getLivros()) {
				System.out.println(l.getTitulo());
				System.out.println(l.getLancamento());
			}
		}

		em.close();
	}
}
