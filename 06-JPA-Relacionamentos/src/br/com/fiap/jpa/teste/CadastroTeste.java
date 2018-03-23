package br.com.fiap.jpa.teste;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Imposto;
import br.com.fiap.jpa.entity.ItemPedido;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();

		NotaFiscalDAOImpl notaDao = new NotaFiscalDAOImpl(em);

		// instancia o pedido
		Pedido pedido = new Pedido(Calendar.getInstance(), "Pizza");
		
		// instancia a nota fiscal passando o pedido 
		NotaFiscal notaFiscal = new NotaFiscal(Calendar.getInstance(), 16.98, pedido);

		// instancia os itens de pedido
		ItemPedido item1 = new ItemPedido("Cerveja", 10.99);
		ItemPedido item2 = new ItemPedido("Chocolate", 5.99);

		// instancia os impostos
		Imposto imp1 = new Imposto(0.08, "ICMS");
		Imposto imp2 = new Imposto(0.06, "IOF");

		// cria lista de impostos
		List<Imposto> listaImposto = new ArrayList<>();
		listaImposto.add(imp1);
		listaImposto.add(imp2);

		// setando a lista de impostos da nota fiscal
		notaFiscal.setImpostos(listaImposto);

		// adicionando os itens de pedido, utilizando um método da classe Pedido
		pedido.adicionarItem(item1);
		pedido.adicionarItem(item2);

		try {
			
			// inserindo a nota fiscal no banco, automaticamente irá inserir o pedido e itens de pedido devido ao cascade
			notaDao.inserir(notaFiscal);
			// efetiva as alterações de inserção no banco de dados.
			notaDao.commit();

		} catch (CommitException e) {
			e.printStackTrace();
		}

		em.close();
		factory.close();

	}

}
