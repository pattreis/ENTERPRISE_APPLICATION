package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO {

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listarPorUf(String uf) {

		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf like :ufCidade",
				Cliente.class);
		query.setParameter("ufCidade", "%"+uf+"%");

		return query.getResultList();
	}

}
