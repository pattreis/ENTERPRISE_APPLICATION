package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.entity.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO {
	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> listaPorData(Calendar inicio, Calendar fim) {
		return em.createQuery("from Livro l where l.lancamento > :i and l.lancamento <:f", Livro.class)
				.setParameter("i", inicio).setParameter("f", fim).setMaxResults(5).getResultList();
	}

	@Override
	public List<Livro> listaPorTitulo(String titulo) {
		return em.createQuery("from Livro l where l.titulo like :t", Livro.class).setParameter("t", "%" + titulo + "%")
				.getResultList();
	}

	@Override
	public long totalLivros() {
		return em.createQuery("select count(l.titulo) from Livro l", Long.class).getSingleResult();
	}

	@Override
	public List<Livro> listaPorNomeAutor(String autor) {
		return em.createQuery("from Livro l where l.autor.nome like :n", Livro.class)
				.setParameter("n", "%" + autor + "%").getResultList();
	}

	@Override
	public Livro pesquisaPorAutor(String autor) {
		return em.createQuery("from Livro l where l.autor.nome like :n", Livro.class)
				.setParameter("n", "%" + autor + "%").setMaxResults(1).getSingleResult();
	}
}
