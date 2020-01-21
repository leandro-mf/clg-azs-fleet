package br.com.azship.clgazsfleet.bootstrap;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.azship.clgazsfleet.model.CategoriaCnh;
import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.Sexo;
import br.com.azship.clgazsfleet.model.StatusViagem;
import br.com.azship.clgazsfleet.model.TipoVeiculo;
import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.model.Viagem;
import br.com.azship.clgazsfleet.repository.MotoristaRepository;
import br.com.azship.clgazsfleet.repository.VeiculoRepository;
import br.com.azship.clgazsfleet.repository.ViagemRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private MotoristaRepository motoristaRepository;
	private VeiculoRepository veiculoRepository;
	private ViagemRepository viagemRepository;

	public BootStrapData(MotoristaRepository motoristaRepository, VeiculoRepository veiculoRepository,
			ViagemRepository viagemRepository) {
		this.motoristaRepository = motoristaRepository;
		this.veiculoRepository = veiculoRepository;
		this.viagemRepository = viagemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Carregando dados...");

		List<Motorista> motoristas = new ArrayList<Motorista>();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		List<Viagem> viagens = new ArrayList<Viagem>();

		for (int i = 0; i < 10; i++) {
			Motorista motorista = new Motorista();
			Veiculo veiculo = new Veiculo();
			Viagem viagem = new Viagem();

			String iString = String.valueOf(i);

			motorista.setNome("Motorista " + (i + 1));
			motorista.setCpf(String.join("", Collections.nCopies(11, iString)));
			motorista.setDataNascimento(LocalDate.of(1995, 1, i + 1));
			motorista.setSexo(Sexo.getInstance(new Random().nextInt(2)));
			motorista.setCategoriaCnh(CategoriaCnh.getInstance(new Random().nextInt(3)));
			motorista.setNumeroCnh(String.join("", Collections.nCopies(11, iString)));
			motorista.setExpedicaoCnh(LocalDate.of(2016, 5, i + 1));
			motorista.setValidadeCnh(LocalDate.of(2020, 5, i + 1));

			motoristas.add(motorista);

			veiculo.setPlaca("AAA" + String.join("", Collections.nCopies(4, iString)));
			veiculo.setCidade("Uberlandia");
			veiculo.setEstado("MG");
			veiculo.setRenavam("Renavam " + (i + 1));
			veiculo.setChassi("Chassi " + (i + 1));
			veiculo.setFabricante("Fabricante " + (i + 1));
			veiculo.setModelo("Modelo " + (i + 1));
			veiculo.setAnoFabricacao(LocalDate.of(2000, 1, i + 1));
			veiculo.setTipoVeiculo(TipoVeiculo.getInstance(new Random().nextInt(7)));

			veiculos.add(veiculo);

			viagem.setVeiculo(veiculo);
			viagem.setMotorista(motorista);
			viagem.setDataInicio(LocalDate.of(2020, i + 1, i + 1));
			viagem.setDataFim(LocalDate.of(2020, i + 1, i + 1));
			viagem.setProdutoTransportado("Produto " + (i + 1));
			viagem.setValorFrete(BigDecimal.valueOf(new Random().nextDouble() + new Random().nextInt(1000))
					.setScale(2, RoundingMode.HALF_UP).doubleValue());
			viagem.setStatusViagem(StatusViagem.CRIADA);

			viagens.add(viagem);
		}

		motoristaRepository.saveAll(motoristas);
		veiculoRepository.saveAll(veiculos);
		viagemRepository.saveAll(viagens);

		System.out.println("Motoristas carregados: " + motoristaRepository.count());
		System.out.println("Veiculos carregados: " + veiculoRepository.count());
		System.out.println("Viagens carregadas: " + viagemRepository.count());
	}

}
