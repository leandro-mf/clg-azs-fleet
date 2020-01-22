package br.com.azship.clgazsfleet.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Reboque;
import br.com.azship.clgazsfleet.repository.ReboqueRepository;
import br.com.azship.clgazsfleet.service.VeiculoService;

@Service("reboqueService")
public class ReboqueServiceImpl implements VeiculoService<Reboque>{

	private static final Logger LOGGER = LoggerFactory.getLogger(ReboqueServiceImpl.class);
	
	private final ReboqueRepository reboqueRepository;
	
	public ReboqueServiceImpl(ReboqueRepository reboqueRepository) {
		this.reboqueRepository = reboqueRepository;
	}

	@Override
	public List<Reboque> findAll() {
		LOGGER.info("findAll()");
		List<Reboque> reboques = reboqueRepository.findAll(); 
		LOGGER.debug("{}", reboques);
		return reboques;
	}

	@Override
	public Reboque findById(Long id) {
		LOGGER.info("findById({})", id);
		Optional<Reboque> optional = reboqueRepository.findById(id);
		Reboque reboque = optional.orElse(null);
		LOGGER.debug("{}", reboque);
		return reboque;
	}

	@Override
	public Reboque findByPlaca(String placa) {
		LOGGER.info("findByPlaca({})", placa);
		Reboque reboque = reboqueRepository.findByPlaca(placa);
		LOGGER.debug("{}", reboque);
		return reboque;
	}

	@Override
	public Reboque save(Reboque veiculo) {
		LOGGER.info("save({})", veiculo);
		Reboque savedReboque = reboqueRepository.save(veiculo); 
		LOGGER.debug("{}", savedReboque);
		return savedReboque;
	}

	@Override
	public Reboque update(Reboque veiculo) {
		LOGGER.info("update({})", veiculo);
		Reboque updatedReboque = reboqueRepository.save(veiculo); 
		LOGGER.debug("{}", updatedReboque);
		return updatedReboque;
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("delete({})", id);
		reboqueRepository.deleteById(id);
	}

}
