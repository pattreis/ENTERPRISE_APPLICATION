package br.com.fiap.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.entity.Apartamento;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Locacao;
import br.com.fiap.entity.Sexo;
import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.LocacaoDAOImpl;
import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class teste {

	public static void main(String[] args) {
		
		EntityManagerFactory fb = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fb.createEntityManager();
		
		Cliente cliente = new Cliente("Testand", Calendar.getInstance(), Sexo.MASCULINO);
		Apartamento ap = new Apartamento("AV Teste", "testes", null);
		
		Locacao locacao = new Locacao(Calendar.getInstance(), Calendar.getInstance());
		locacao.setApartamento(ap);
		locacao.setCliente(cliente);
		
		//Cadastrar
		
		LocacaoDAO dao = new LocacaoDAOImpl(em);
		try {
		
			dao.cadastrar(locacao);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		em.close();
		fb.close();
		
		
		//Pesquisar
		
		
		
	}

}
