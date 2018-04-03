package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;

public class ConsoleView {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		
		// Lisar as cidades
			//cria o DAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		// Busca as cidades
		List<Cidade> lista = cidadeDao.listar(); 
		
		
		//Exibe o nome e o esado
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome()+ " - "+ cidade.getUf());
		}
		
		lista = cidadeDao.buscarPorNome("Londrina");
		
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome()+ " - "+ cidade.getUf());
		}
		
		
		
		System.out.println("Digite a UF desejada\n");
		List<Cliente> listaCliente = clienteDao.listarPorUf(sc.nextLine());
		
		
		for (Cliente cliente : listaCliente) {
			System.out.println("CPF: "+cliente.getCpf());
			System.out.println("NOME: "+cliente.getNome());
		}
		
		em.close();
		fabrica.close();
	}

}



