package br.com.fiap.ChComp.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.ChComp.entity.Reserva;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Listagem {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ReservaDAO dao = new ReservaDAOImpl(em);

		List<Reserva> reservas = dao.listar();
		System.out.println("LISTA DE RESERVAS");
		for (int i = 0; i < reservas.size(); i++) {
			System.out.println(reservas.get(i).getCodigo());
			System.out.println(reservas.get(i).getDataReserva());
			System.out.println("Cliente");
			System.out.println(reservas.get(i).getCliente().getNome());
			System.out.println(reservas.get(i).getCliente().getIdade());
			System.out.println(reservas.get(i).getCliente().getCpf());
			System.out.println("Quarto");
			System.out.println(reservas.get(i).getQuarto().getTipo());
			System.out.println(reservas.get(i).getQuarto().getComodos());
			System.out.println(reservas.get(i).getQuarto().getPreco());
		}

		em.close();
	}
}
