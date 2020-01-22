package br.com.azship.clgazsfleet.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.azship.clgazsfleet.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	Viagem findByMotorista_id(Long id);
	
	Viagem findByVeiculo_id(Long id);
	
	Viagem findByDataInicio(LocalDate dataInicio);
	
	Viagem findByDataFim(LocalDate dataFim);
	
}
