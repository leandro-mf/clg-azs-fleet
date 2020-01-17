package br.com.azship.clgazsfleet.service;

import java.util.List;

import br.com.azship.clgazsfleet.model.Viagem;

public interface ViagemService {

	List<Viagem> findAllViagens();
	
	Viagem findViagemById(Long id);
	
	Viagem saveViagem(Viagem viagem);
	
	void deleteViagem(Long id);
	
	Viagem updateViagem(Viagem viagem);

}
