package br.com.azship.clgazsfleet.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	Viagem findByMotorista(Motorista motorista);
	
	Viagem findByVeiculo(Veiculo veiculo);
	
	Viagem findByDataInicio(LocalDate dataInicio);
	
	Viagem findByDataFim(LocalDate dataFim);
	
}
