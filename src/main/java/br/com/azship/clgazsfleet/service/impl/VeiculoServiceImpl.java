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
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo findById(Long id) {
		return veiculoRepository.findById(id).get();
	}

	@Override
	public Veiculo findByPlaca(String placa) {
		return veiculoRepository.findByPlaca(placa);
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	@Override
	public void delete(Long id) {
		veiculoRepository.deleteById(id);
	}

}
