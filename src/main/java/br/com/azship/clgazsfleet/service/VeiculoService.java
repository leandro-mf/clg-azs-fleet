package br.com.azship.clgazsfleet.service;

import java.util.List;

import br.com.azship.clgazsfleet.model.Veiculo;

public interface VeiculoService {
	
	List<Veiculo> findAllVeiculos();
	
	Veiculo findVeiculoById(Long id);
	
	Veiculo saveVeiculo(Veiculo veiculo);
	
	void deleteVeiculo(Long id);
	
	Veiculo updateVeiculo(Veiculo veiculo);

}
