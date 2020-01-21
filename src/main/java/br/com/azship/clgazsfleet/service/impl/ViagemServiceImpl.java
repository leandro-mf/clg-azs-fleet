package br.com.azship.clgazsfleet.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.StatusViagem;
import br.com.azship.clgazsfleet.model.Veiculo;
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
	public List<Viagem> findAll() {
		return viagemRepository.findAll();
	}

	@Override
	public Viagem findById(Long id) {
		return viagemRepository.findById(id).get();
	}

	@Override
	public Viagem findByMotorista(Motorista motorista) {
		return viagemRepository.findByMotorista(motorista);
	}

	@Override
	public Viagem findByVeiculo(Veiculo veiculo) {
		return viagemRepository.findByVeiculo(veiculo);
	}

	@Override
	public Viagem findByDataInicio(LocalDate dataInicio) {
		return viagemRepository.findByDataInicio(dataInicio);
	}

	@Override
	public Viagem findByDataFim(LocalDate dataFim) {
		return viagemRepository.findByDataFim(dataFim);
	}

	@Override
	public Viagem save(Viagem viagem) {
		viagem.setStatusViagem(StatusViagem.CRIADA);
		return viagemRepository.save(viagem);
	}

	@Override
	public Viagem update(Viagem viagem) {
		return viagemRepository.save(viagem);
	}

	@Override
	public void delete(Long id) {
		viagemRepository.deleteById(id);
	}

}
