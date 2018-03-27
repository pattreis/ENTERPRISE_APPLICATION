package br.com.fiap.ads.dao;

import br.com.fiap.ads.entity.Veiculo;
import br.com.fiap.ads.exception.CommitException;
import br.com.fiap.ads.exception.KeyNotFoundException;

public interface VeiculoDAO {

	void create(Veiculo carro);
	void update(Veiculo carro);
	void delete(int codigo) throws KeyNotFoundException;
	Veiculo find(int codigo);
	
	void commit() throws CommitException;
	
}
