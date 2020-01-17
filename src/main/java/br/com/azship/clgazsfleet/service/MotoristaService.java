package br.com.azship.clgazsfleet.service;

import java.util.List;

import br.com.azship.clgazsfleet.model.Motorista;

public interface MotoristaService {

	List<Motorista> findAllMotoristas();
	
	Motorista findMotoristaById(Long id);
		
	Motorista saveMotorista(Motorista motorista);
	
	void deleteMotorista(Long id);
	
	Motorista updateMotorista(Motorista motorista);
	
}
