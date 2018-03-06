package br.com.fiap.ads.dao;

import br.com.fiap.ads.entity.Veiculo;
import br.com.fiap.ads.exception.CarNotFoundException;
import br.com.fiap.ads.exception.CommitException;

public interface VeiculoDAO {

	void create(Veiculo carro);
	void update(Veiculo carro);
	void delete(int codigo) throws CarNotFoundException;
	Veiculo find(int codigo);
	
	void commit() throws CommitException;
	
}
