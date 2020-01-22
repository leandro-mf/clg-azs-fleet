package br.com.azship.clgazsfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.azship.clgazsfleet.model.Veiculo;

public interface VeiculoRepository<T extends Veiculo> extends JpaRepository<T, Long> {
	
	T findByPlaca(String placa);

}
