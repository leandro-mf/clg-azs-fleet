package br.com.azship.clgazsfleet.service;

import java.util.List;

import br.com.azship.clgazsfleet.model.Veiculo;

public interface VeiculoService {
	
	List<Veiculo> findAll();
	
	Veiculo findById(Long id);
	
	Veiculo findByPlaca(String placa);
	
	Veiculo save(Veiculo veiculo);
		
	Veiculo update(Veiculo veiculo);
	
	void delete(Long id);

}
