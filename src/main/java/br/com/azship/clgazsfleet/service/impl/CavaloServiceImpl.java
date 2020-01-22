package br.com.azship.clgazsfleet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Cavalo;
import br.com.azship.clgazsfleet.repository.CavaloRepository;
import br.com.azship.clgazsfleet.service.VeiculoService;

@Service
public class CavaloServiceImpl implements VeiculoService<Cavalo> {

	private final CavaloRepository cavaloRepository;

	public CavaloServiceImpl(CavaloRepository cavaloRepository) {
		this.cavaloRepository = cavaloRepository;
	}

	@Override
	public List<Cavalo> findAll() {
		return cavaloRepository.findAll();
	}

	@Override
	public Cavalo findById(Long id) {
		return cavaloRepository.findById(id).get();
	}

	@Override
	public Cavalo findByPlaca(String placa) {
		return cavaloRepository.findByPlaca(placa);
	}

	@Override
	public Cavalo save(Cavalo veiculo) {
		return cavaloRepository.save(veiculo);
	}

	@Override
	public Cavalo update(Cavalo veiculo) {
		return cavaloRepository.save(veiculo);
	}

	@Override
	public void delete(Long id) {
		cavaloRepository.deleteById(id);
	}

}
