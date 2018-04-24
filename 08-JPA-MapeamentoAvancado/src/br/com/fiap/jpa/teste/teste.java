package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class teste {

	public static void main(String[] args) {

		EntityManagerFactory fb = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fb.createEntityManager();

		Medico medico = new Medico(1234, "Sergio Marcone", "Pediatria");
		Paciente paciente = new Paciente("Pedrinho Oliveira", new GregorianCalendar(1994, Calendar.JANUARY, 14));

		Consulta consulta = new Consulta(medico, paciente, Calendar.getInstance(), "2A", true);

		ConsultaDAO dao = new ConsultaDAOImpl(em);

		try {

			dao.inserir(consulta);
			dao.commit();

		} catch (CommitException e) {
			e.printStackTrace();
		}

	}
}
