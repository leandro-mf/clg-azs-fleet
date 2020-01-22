package br.com.azship.clgazsfleet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Reboque;
import br.com.azship.clgazsfleet.repository.ReboqueRepository;
import br.com.azship.clgazsfleet.service.VeiculoService;

@Service
public class ReboqueServiceImpl implements VeiculoService<Reboque>{

	private final ReboqueRepository reboqueRepository;
	
	public ReboqueServiceImpl(ReboqueRepository reboqueRepository) {
		this.reboqueRepository = reboqueRepository;
	}

	@Override
	public List<Reboque> findAll() {
		return reboqueRepository.findAll();
	}

	@Override
	public Reboque findById(Long id) {
		return reboqueRepository.findById(id).get();
	}

	@Override
	public Reboque findByPlaca(String placa) {
		return reboqueRepository.findByPlaca(placa);
	}

	@Override
	public Reboque save(Reboque veiculo) {
		return reboqueRepository.save(veiculo);
	}

	@Override
	public Reboque update(Reboque veiculo) {
		return reboqueRepository.save(veiculo);
	}

	@Override
	public void delete(Long id) {
		reboqueRepository.deleteById(id);
	}

}
