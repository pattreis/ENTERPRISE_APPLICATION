package br.com.fiap.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDAO;
import br.com.fiap.entity.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Livro> listarPorData(Calendar inicio, Calendar fim) {
		return em.createQuery("from Livro l where l.lancamento > :i and l.lancamento <:f", Livro.class)
				.setParameter("i", inicio).setParameter("f", fim).setMaxResults(5).getResultList();		
	}

	@Override
	public List<Livro> listarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro pesquisar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long pesquisarQuantidadeLivro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Livro pesquisarPorAutor(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> listarPorAtutor(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro pesquisarPorLivraria(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> listarPorLivraria(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
