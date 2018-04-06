package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;

public class ConsoleView {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		Scanner sc = new Scanner(System.in);

		// Lisar as cidades
		// cria o DAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		PacoteDAO pacoteDAO = new PacoteDAOImpl(em);

		// Instanciando uma lista de cidades com todas as cidades.
		List<Cidade> lista = cidadeDao.listar();

		// Exibe o nome das cidade e o estado
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " - " + cidade.getUf());
		}

		// Exibe a cidade e o estado de acordo com o nome da cidade pesquisada.
		lista = cidadeDao.buscarPorNome("Londrina");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " - " + cidade.getUf());
		}

		// Combinando metodo de listar pacotes com laço foreach.
		for (Pacote pacote : pacoteDAO.listar()) {
			System.out.println("Destino: " + pacote.getDescricao() + "\tValor Passagem: " + pacote.getPreco());
		}

		// Utilizando Método de buscar cidades por UF
		System.out.println("Digite a UF desejada\n");
		List<Cliente> listaCliente = clienteDao.listarPorUf(sc.nextLine());

		// Exibe as cidades da pesquisa acima.
		for (Cliente cliente : listaCliente) {
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("NOME: " + cliente.getNome());
			System.out.println("CIDADE: " + cliente.getEndereco().getCidade().getNome());
			System.out.println("UF: " + cliente.getEndereco().getCidade().getUf());
		}

		
		listaCliente = clienteDao.listarPorQtdDias(10);
		
		// Exibe as cidades da pesquisa acima.
		for (Cliente cliente : listaCliente) {
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("NOME: " + cliente.getNome());
		}

		em.close();
		fabrica.close();
	}

}
