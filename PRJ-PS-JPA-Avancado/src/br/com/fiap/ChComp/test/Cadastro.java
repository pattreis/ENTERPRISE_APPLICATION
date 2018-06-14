package br.com.fiap.ChComp.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.ChComp.entity.Cliente;
import br.com.fiap.ChComp.entity.Quarto;
import br.com.fiap.ChComp.entity.Reserva;
import br.com.fiap.ChComp.entity.TipoQuarto;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ReservaDAO dao = new ReservaDAOImpl(em);

		Cliente cliente = new Cliente();
		cliente.setNome("Pedro");
		cliente.setCpf("435.321.345.69");
		cliente.setIdade(20);

		Quarto quarto = new Quarto();
		quarto.setTipo(TipoQuarto.PRESIDENCIAL);
		quarto.setComodos(5);
		quarto.setPreco(500.00);

		Reserva reserva = new Reserva();
		reserva.setCliente(cliente);
		reserva.setQuarto(quarto);
		reserva.setDataReserva(new GregorianCalendar(2018, Calendar.JUNE, 13));

		dao.inserir(reserva);
		dao.commit();

		em.close();
	}
}
