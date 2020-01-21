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
	public List<Motorista> findAll() {
		return motoristaRepository.findAll();
	}

	@Override
	public Motorista findById(Long id) {
		Motorista motorista = motoristaRepository.findById(id).get();
		return motorista;
	}

	@Override
	public Motorista findByNome(String nome) {
		return motoristaRepository.findByNome(nome);
	}

	@Override
	public Motorista findByCpf(String cpf) {
		return motoristaRepository.findByCpf(cpf);
	}

	@Override
	public Motorista save(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	@Override
	public Motorista update(Motorista motorista) {
		return motoristaRepository.save(motorista);
	}

	@Override
	public void delete(Long id) {
		motoristaRepository.deleteById(id);
	}

}
