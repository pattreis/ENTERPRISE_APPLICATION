package br.com.fiap.ads.dao;

import br.com.fiap.ads.entity.Motorista;
import br.com.fiap.ads.exception.CommitException;
import br.com.fiap.ads.exception.KeyNotFoundException;

public interface MotoristaDAO {

	void create(Motorista motorista);
	void update(Motorista motorista);
	void delete(int codigo) throws KeyNotFoundException;
	Motorista find(int nr_carteira);
	
	void commit() throws CommitException;
	
}
