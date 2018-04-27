package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fb = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fb.createEntityManager();

		PessoaFisica pf = new PessoaFisica("Fudencio Santos", "Rua dos bobos nº 0", "054.357.895-30", "45.865.478-1");
		PessoaJuridica pj = new PessoaJuridica("INDIOS SUL LTDA", "Av Indiana Jones, 2450", "10.564.547.0001-90",
				"INDIOADOS DA SUL LTDA");

		PessoaDAO dao = new PessoaDAOImpl(em);

		try {

			dao.inserir(pf);
			dao.inserir(pj);
			dao.commit();

		} catch (CommitException e) {
			e.printStackTrace();
		}

	}
}
