package br.com.azship.clgazsfleet.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.repository.MotoristaRepository;
import br.com.azship.clgazsfleet.service.MotoristaService;

@Service
public class MotoristaServiceImpl implements MotoristaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MotoristaServiceImpl.class);
	
	private final MotoristaRepository motoristaRepository;

	public MotoristaServiceImpl(MotoristaRepository motoristaRepository) {
		this.motoristaRepository = motoristaRepository;
	}

	@Override
	public List<Motorista> findAll() {
		LOGGER.info("findAll()");
		List<Motorista> motoristas = motoristaRepository.findAll();
		LOGGER.debug("{}", motoristas);
		return motoristas;
	}

	@Override
	public Motorista findById(Long id) {
		LOGGER.info("findById({})", id);
		Optional<Motorista> optional = motoristaRepository.findById(id);
		Motorista motorista = optional.orElse(null);
		LOGGER.debug("{}", motorista);
		return motorista;
	}

	@Override
	public Motorista findByNome(String nome) {
		LOGGER.info("findByNome({})", nome);
		Motorista motorista = motoristaRepository.findByNome(nome);
		LOGGER.debug("{}", motorista);
		return motorista;
	}

	@Override
	public Motorista findByCpf(String cpf) {
		LOGGER.info("findByCpf({})", cpf);
		Motorista motorista = motoristaRepository.findByCpf(cpf); 
		LOGGER.debug("{}", motorista);
		return motorista;
	}

	@Override
	public Motorista save(Motorista motorista) {
		LOGGER.info("save({})", motorista);
		Motorista savedMotorista = motoristaRepository.save(motorista);
		LOGGER.debug("{}", savedMotorista);
		return savedMotorista;
	}

	@Override
	public Motorista update(Motorista motorista) {
		LOGGER.info("update({})", motorista);
		Motorista updatedMotorista = motoristaRepository.save(motorista); 
		LOGGER.debug("{}", updatedMotorista);
		return updatedMotorista;
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("delete({})", id);
		motoristaRepository.deleteById(id);
	}

}
