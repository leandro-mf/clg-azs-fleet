package br.com.azship.clgazsfleet.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Viagem;
import br.com.azship.clgazsfleet.repository.ViagemRepository;
import br.com.azship.clgazsfleet.service.ViagemService;

@Service
public class ViagemServiceImpl implements ViagemService {

	private final ViagemRepository viagemRepository;
	
	public ViagemServiceImpl(ViagemRepository viagemRepository) {
		this.viagemRepository = viagemRepository;
	}

	@Override
	public List<Viagem> findAllViagens() {
		return viagemRepository.findAll();
	}

	@Override
	public Viagem findViagemById(Long id) {
		return viagemRepository.findById(id).get();
	}

	@Override
	public Viagem saveViagem(Viagem viagem) {
		return viagemRepository.save(viagem);
	}

	@Override
	public void deleteViagem(Long id) {
		viagemRepository.deleteById(id);
	}

	@Override
	public Viagem updateViagem(Viagem viagem) {
		return viagemRepository.save(viagem);
	}

}
