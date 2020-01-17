package br.com.azship.clgazsfleet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.repository.MotoristaRepository;
import br.com.azship.clgazsfleet.service.MotoristaService;

@Service
public class MotoristaServiceImpl implements MotoristaService {

	private final MotoristaRepository motoristaRepository;
	
	public MotoristaServiceImpl(MotoristaRepository motoristaRepository) {
		this.motoristaRepository = motoristaRepository;
	}
	
	@Override
	public Motorista findMotoristaById(Long id) {
		return motoristaRepository.findById(id).get();
	}

	@Override
	public List<Motorista> findAllMotoristas() {
		return motoristaRepository.findAll();
	}

	@Override
	public Motorista saveMotorista(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	@Override
	public void deleteMotorista(Long id) {
		motoristaRepository.deleteById(id);
	}

	@Override
	public Motorista updateMotorista(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

}
