package br.com.azship.clgazsfleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.azship.clgazsfleet.model.Motorista;

//@RepositoryRestResource(path = "teste")
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
