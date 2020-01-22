package br.com.azship.clgazsfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.azship.clgazsfleet.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

	Motorista findByNome(String nome);
	
	Motorista findByCpf(String cpf);
	
}
