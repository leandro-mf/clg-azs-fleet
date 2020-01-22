package br.com.azship.clgazsfleet.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Cavalo;
import br.com.azship.clgazsfleet.repository.CavaloRepository;
import br.com.azship.clgazsfleet.service.VeiculoService;

@Service("cavaloService")
public class CavaloServiceImpl implements VeiculoService<Cavalo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CavaloServiceImpl.class);
			
	private final CavaloRepository cavaloRepository;

	public CavaloServiceImpl(CavaloRepository cavaloRepository) {
		this.cavaloRepository = cavaloRepository;
	}

	@Override
	public List<Cavalo> findAll() {
		LOGGER.info("findAll()");
		List<Cavalo> cavalos = cavaloRepository.findAll();
		LOGGER.debug("{}", cavalos);
		return cavalos;
	}

	@Override
	public Cavalo findById(Long id) {
		LOGGER.info("findById({})", id);
		Optional<Cavalo> optional = cavaloRepository.findById(id);
		Cavalo cavalo = optional.orElse(null);
		LOGGER.debug("{}", cavalo);
		return cavalo;
	}

	@Override
	public Cavalo findByPlaca(String placa) {
		LOGGER.info("findByPlaca({})", placa);
		Cavalo cavalo = cavaloRepository.findByPlaca(placa); 
		LOGGER.debug("{}", cavalo);
		return cavalo;
	}

	@Override
	public Cavalo save(Cavalo veiculo) {
		LOGGER.info("save({})", veiculo);
		Cavalo savedCavalo = cavaloRepository.save(veiculo);
		LOGGER.debug("{}", savedCavalo);
		return savedCavalo;
	}

	@Override
	public Cavalo update(Cavalo veiculo) {
		LOGGER.info("update({})", veiculo);
		Cavalo updatedCavalo = cavaloRepository.save(veiculo);
		LOGGER.debug("{}", updatedCavalo);
		return updatedCavalo;
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("delete({})", id);
		cavaloRepository.deleteById(id);
	}

}
