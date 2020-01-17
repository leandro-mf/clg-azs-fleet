package br.com.azship.clgazsfleet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.repository.VeiculoRepository;
import br.com.azship.clgazsfleet.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	private final VeiculoRepository veiculoRepository;

	public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	@Override
	public Veiculo findVeiculoById(Long id) {
		return veiculoRepository.findById(id).get();
	}

	@Override
	public List<Veiculo> findAllVeiculos() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo saveVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public void deleteVeiculo(Long id) {
		veiculoRepository.deleteById(id);
	}

	@Override
	public Veiculo updateVeiculo(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

}
