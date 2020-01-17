package br.com.azship.clgazsfleet.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.azship.clgazsfleet.model.CategoriaCnh;
import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.model.Sexo;
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

		Motorista motorista1 = new Motorista();
		Motorista motorista2 = new Motorista();

		motorista1.setNome("Joao");
		motorista1.setCpf("752.583.470-95");
		motorista1.setDataNascimento(LocalDate.of(1995, 1, 1));
		motorista1.setSexo(Sexo.MASCULINO);
		motorista1.setCategoriaCnh(CategoriaCnh.C);
		motorista1.setNumeroCnh("111111111");
		motorista1.setExpedicaoCnh(LocalDate.of(2016, 5, 1));
		motorista1.setValidadeCnh(LocalDate.of(2020, 5, 1));

		motorista2.setNome("Maria");
		motorista2.setCpf("628.497.030-79");
		motorista2.setDataNascimento(LocalDate.of(1990, 1, 1));
		motorista2.setSexo(Sexo.FEMININO);
		motorista2.setCategoriaCnh(CategoriaCnh.D);
		motorista2.setNumeroCnh("222222222");
		motorista2.setExpedicaoCnh(LocalDate.of(2017, 10, 1));
		motorista2.setValidadeCnh(LocalDate.of(2021, 10, 1));

		motoristaRepository.save(motorista1);
		motoristaRepository.save(motorista2);

		System.out.println("Motoristas carregados: " + motoristaRepository.count());

		Veiculo veiculo1 = new Veiculo();
		Veiculo veiculo2 = new Veiculo();

		veiculo1.setPlaca("AAA1111");
		veiculo1.setCidade("Uberlandia");
		veiculo1.setEstado("MG");
		veiculo1.setRenavam("Renavam 1");
		veiculo1.setChassi("Chassi 1");
		veiculo1.setFabricante("Fabricante 1");
		veiculo1.setModelo("Modelo 1");
		veiculo1.setAnoFabricacao(LocalDate.of(2000, 1, 1));
		veiculo1.setTipoVeiculo(TipoVeiculo.BAU);

		veiculo2.setPlaca("BBB2222");
		veiculo2.setCidade("Sao Paulo");
		veiculo2.setEstado("SP");
		veiculo2.setRenavam("Renavam 2");
		veiculo2.setChassi("Chassi 2");
		veiculo2.setFabricante("Fabricante 2");
		veiculo2.setModelo("Modelo 2");
		veiculo2.setAnoFabricacao(LocalDate.of(2005, 1, 1));
		veiculo2.setTipoVeiculo(TipoVeiculo.BAU_FRIGORIFICO);

		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);

		System.out.println("Veiculos carregados: " + veiculoRepository.count());

		Viagem viagem1 = new Viagem();
		Viagem viagem2 = new Viagem();

		viagem1.setVeiculo(veiculo1);
		viagem1.setMotorista(motorista1);
		viagem1.setDataInicio(LocalDate.of(2020, 1, 1));
		viagem1.setDataFim(LocalDate.of(2020, 2, 1));
		viagem1.setProdutoTransportado("Soja");
		viagem1.setValorFrete(new Double("105.9"));

		viagem2.setVeiculo(veiculo2);
		viagem2.setMotorista(motorista2);
		viagem2.setDataInicio(LocalDate.of(2020, 7, 5));
		viagem2.setDataFim(LocalDate.of(2020, 8, 10));
		viagem2.setProdutoTransportado("Boi");
		viagem2.setValorFrete(new Double("55.9"));

		viagemRepository.save(viagem1);
		viagemRepository.save(viagem2);

		System.out.println("Viagens carregadas: " + viagemRepository.count());
	}

}
