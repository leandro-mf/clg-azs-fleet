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
import br.com.azship.clgazsfleet.model.Cavalo;
import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.Reboque;
import br.com.azship.clgazsfleet.model.Sexo;
import br.com.azship.clgazsfleet.model.StatusViagem;
import br.com.azship.clgazsfleet.model.TipoCavalo;
import br.com.azship.clgazsfleet.model.TipoReboque;
import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.model.Viagem;
import br.com.azship.clgazsfleet.repository.CavaloRepository;
import br.com.azship.clgazsfleet.repository.MotoristaRepository;
import br.com.azship.clgazsfleet.repository.ReboqueRepository;
import br.com.azship.clgazsfleet.repository.VeiculoRepository;
import br.com.azship.clgazsfleet.repository.ViagemRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private MotoristaRepository motoristaRepository;
	private VeiculoRepository<Veiculo> veiculoRepository;
	private CavaloRepository cavaloRepository;
	private ReboqueRepository reboqueRepository;
	private ViagemRepository viagemRepository;

	public BootStrapData(MotoristaRepository motoristaRepository, VeiculoRepository<Veiculo> veiculoRepository,
			CavaloRepository cavaloRepository, ReboqueRepository reboqueRepository, ViagemRepository viagemRepository) {
		this.motoristaRepository = motoristaRepository;
		this.veiculoRepository = veiculoRepository;
		this.cavaloRepository = cavaloRepository;
		this.reboqueRepository = reboqueRepository;
		this.viagemRepository = viagemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Carregando dados...");

		List<Motorista> motoristas = new ArrayList<Motorista>();
		List<Viagem> viagens = new ArrayList<Viagem>();

		for (int i = 0; i < 10; i++) {
			Motorista motorista = new Motorista();
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

			if (i < 3) {
				Veiculo veiculo = new Veiculo();
				veiculo.setPlaca("AAA" + String.join("", Collections.nCopies(4, iString)));
				veiculo.setCidade("Uberlandia");
				veiculo.setEstado("MG");
				veiculo.setRenavam("Renavam " + (i + 1));
				veiculo.setChassi("Chassi " + (i + 1));
				veiculo.setFabricante("Fabricante " + (i + 1));
				veiculo.setModelo("Modelo " + (i + 1));
				veiculo.setAnoFabricacao(LocalDate.of(2000, 1, i + 1));
				viagem.setVeiculo(veiculo);
				veiculoRepository.save(veiculo);
			} else if (i < 6) {
				Cavalo cavalo = new Cavalo();
				cavalo.setPlaca("AAA" + String.join("", Collections.nCopies(4, iString)));
				cavalo.setCidade("Uberlandia");
				cavalo.setEstado("MG");
				cavalo.setRenavam("Renavam " + (i + 1));
				cavalo.setChassi("Chassi " + (i + 1));
				cavalo.setFabricante("Fabricante " + (i + 1));
				cavalo.setModelo("Modelo " + (i + 1));
				cavalo.setAnoFabricacao(LocalDate.of(2000, 1, i + 1));
				cavalo.setTipoCavalo(TipoCavalo.getInstance(new Random().nextInt(2)));
				viagem.setVeiculo(cavalo);
				cavaloRepository.save(cavalo);
			} else if (i < 10) {
				Reboque reboque = new Reboque();
				reboque.setPlaca("AAA" + String.join("", Collections.nCopies(4, iString)));
				reboque.setCidade("Uberlandia");
				reboque.setEstado("MG");
				reboque.setRenavam("Renavam " + (i + 1));
				reboque.setChassi("Chassi " + (i + 1));
				reboque.setFabricante("Fabricante " + (i + 1));
				reboque.setModelo("Modelo " + (i + 1));
				reboque.setAnoFabricacao(LocalDate.of(2000, 1, i + 1));
				reboque.setTipoReboque(TipoReboque.getInstance(new Random().nextInt(6)));
				viagem.setVeiculo(reboque);
				reboqueRepository.save(reboque);
			}

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
		viagemRepository.saveAll(viagens);

		System.out.println("Motoristas carregados: " + motoristaRepository.count());
		System.out.println("Veiculos carregados: " + veiculoRepository.count());
		System.out.println("Viagens carregadas: " + viagemRepository.count());
	}

}
