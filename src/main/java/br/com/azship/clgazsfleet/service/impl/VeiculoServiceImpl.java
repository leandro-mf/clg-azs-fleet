package br.com.azship.clgazsfleet.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.repository.VeiculoRepository;
import br.com.azship.clgazsfleet.service.VeiculoService;

@Service("veiculoService")
public class VeiculoServiceImpl implements VeiculoService<Veiculo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(VeiculoServiceImpl.class);
	
	private final VeiculoRepository<Veiculo> veiculoRepository;

	public VeiculoServiceImpl(VeiculoRepository<Veiculo> veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	@Override
	public List<Veiculo> findAll() {
		LOGGER.info("findAll()");
		List<Veiculo> veiculos = veiculoRepository.findAll(); 
		LOGGER.debug("{}", veiculos);
		return veiculos;
	}

	@Override
	public Veiculo findById(Long id) {
		LOGGER.info("findById({})", id);
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		Veiculo veiculo = optional.orElse(null);
		LOGGER.debug("{}", veiculo);
		return veiculo;
	}

	@Override
	public Veiculo findByPlaca(String placa) {
		LOGGER.info("findByPlaca({})", placa);
		Veiculo veiculo = veiculoRepository.findByPlaca(placa); 
		LOGGER.debug("{}", veiculo);
		return veiculo;
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		LOGGER.info("save({})", veiculo);
		Veiculo savedVeiculo = veiculoRepository.save(veiculo); 
		LOGGER.debug("{}", savedVeiculo);
		return savedVeiculo;
	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		LOGGER.info("update({})", veiculo);
		Veiculo updatedVeiculo = veiculoRepository.save(veiculo); 
		LOGGER.debug("{}", updatedVeiculo);
		return updatedVeiculo;
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("delete({})", id);
		veiculoRepository.deleteById(id);
	}

}
