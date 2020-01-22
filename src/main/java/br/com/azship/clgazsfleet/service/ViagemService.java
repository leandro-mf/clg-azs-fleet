package br.com.azship.clgazsfleet.service;

import java.time.LocalDate;
import java.util.List;

import br.com.azship.clgazsfleet.model.Viagem;

public interface ViagemService {

	List<Viagem> findAll();
	
	Viagem findById(Long id);
	
	Viagem findByMotorista_id(Long id);
	
	Viagem findByVeiculo_id(Long id);
	
	Viagem findByDataInicio(LocalDate dataInicio);
	
	Viagem findByDataFim(LocalDate dataFim);
	
	Viagem save(Viagem viagem);
	
	Viagem update(Viagem viagem);
	
	void delete(Long id);

}
