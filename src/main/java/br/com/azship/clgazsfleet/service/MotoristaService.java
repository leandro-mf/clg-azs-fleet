package br.com.azship.clgazsfleet.service;

import java.util.List;

import br.com.azship.clgazsfleet.model.Motorista;

public interface MotoristaService {

	List<Motorista> findAll();
	
	Motorista findById(Long id);
	
	Motorista findByNome(String nome);
	
	Motorista findByCpf(String cpf);
		
	Motorista save(Motorista motorista);
		
	Motorista update(Motorista motorista);
	
	void delete(Long id);
	
}
