package br.com.azship.clgazsfleet.service;

import java.util.List;

import br.com.azship.clgazsfleet.model.Veiculo;

public interface VeiculoService<T extends Veiculo> {
	
	List<T> findAll();
	
	T findById(Long id);
	
	T findByPlaca(String placa);
	
	T save(T veiculo);
		
	T update(T veiculo);
	
	void delete(Long id);

}
