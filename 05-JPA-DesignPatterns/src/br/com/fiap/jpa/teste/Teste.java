package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.AlunoDAOImpl;
import br.com.fiap.jpa.dao.impl.LivroDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		try {
			EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
			EntityManager em = factory.createEntityManager();
			
			LivroDAOImpl livroDao = new LivroDAOImpl(em);
			AlunoDAOImpl alunoDao = new AlunoDAOImpl(em); 

			Livro livro = new Livro("Dominando C#", "Leandro Romano");
			Aluno aluno = new Aluno("RM75244", "Leandro Romano");
			
			/* Insert */
			livroDao.insert(livro);
			alunoDao.insert(aluno);
			
			/* Update */
			alunoDao.update(aluno);
			livroDao.update(livro);
			
			/* Find */
			Aluno aluno2 = alunoDao.find("RM75244");
			Livro livro2 = livroDao.find(1);
			
			/* Remove */
			alunoDao.remove("RM75244");
			livroDao.remove(1);
			
			alunoDao.commit();
			livroDao.commit();
			
			em.close();
			factory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
