package br.com.azship.clgazsfleet.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.StatusViagem;
import br.com.azship.clgazsfleet.model.Viagem;
import br.com.azship.clgazsfleet.repository.ViagemRepository;
import br.com.azship.clgazsfleet.service.ViagemService;

@Service
public class ViagemServiceImpl implements ViagemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ViagemServiceImpl.class);
	
	private final ViagemRepository viagemRepository;

	public ViagemServiceImpl(ViagemRepository viagemRepository) {
		this.viagemRepository = viagemRepository;
	}

	@Override
	public List<Viagem> findAll() {
		LOGGER.info("findAll()");
		List<Viagem> viagens = viagemRepository.findAll(); 
		LOGGER.debug("{}", viagens);
		return viagens;
	}

	@Override
	public Viagem findById(Long id) {
		LOGGER.info("findById({})", id);
		Optional<Viagem> optional = viagemRepository.findById(id);
		Viagem viagem = optional.orElse(null);
		LOGGER.debug("{}", viagem);
		return viagem;
	}

	@Override
	public Viagem findByMotorista_id(Long id) {
		LOGGER.info("findByMotorista_id({})", id);
		Viagem viagem = viagemRepository.findByMotorista_id(id); 
		LOGGER.debug("{}", viagem);
		return viagem;
	}

	@Override
	public Viagem findByVeiculo_id(Long id) {
		LOGGER.info("findByVeiculo_id({})", id);
		Viagem viagem = viagemRepository.findByVeiculo_id(id); 
		LOGGER.debug("{}", viagem);
		return viagem;
	}

	@Override
	public Viagem findByDataInicio(LocalDate dataInicio) {
		LOGGER.info("findByDataInicio({})", dataInicio);
		Viagem viagem = viagemRepository.findByDataInicio(dataInicio);
		LOGGER.debug("{}", viagem);
		return viagem;
	}

	@Override
	public Viagem findByDataFim(LocalDate dataFim) {
		LOGGER.info("findByDataFim({})", dataFim);
		Viagem viagem = viagemRepository.findByDataFim(dataFim);
		LOGGER.debug("{}", viagem);
		return viagem;
	}

	@Override
	public Viagem save(Viagem viagem) {
		LOGGER.info("save({})", viagem);
		viagem.setStatusViagem(StatusViagem.CRIADA);
		Viagem savedViagem = viagemRepository.save(viagem); 
		LOGGER.debug("{}", savedViagem);
		return savedViagem;
	}

	@Override
	public Viagem update(Viagem viagem) {
		LOGGER.info("update({})", viagem);
		Viagem updatedViagem = viagemRepository.save(viagem); 
		LOGGER.debug("{}", updatedViagem);
		return updatedViagem;
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("delete({})", id);
		viagemRepository.deleteById(id);
	}

}
