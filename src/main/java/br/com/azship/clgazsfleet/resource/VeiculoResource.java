package br.com.azship.clgazsfleet.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.azship.clgazsfleet.model.Veiculo;
import br.com.azship.clgazsfleet.service.VeiculoService;

@RestController
@RequestMapping(VeiculoResource.BASE_URL)
@CrossOrigin(origins = "*")
public class VeiculoResource {

	public static final String BASE_URL = "/api/v1/veiculos";

	private final VeiculoService veiculoService;

	public VeiculoResource(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Veiculo> getAllVeiculos() {
		return veiculoService.findAllVeiculos();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Veiculo getVeiculoById(@PathVariable("id") Long id) {
		return veiculoService.findVeiculoById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Veiculo saveVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoService.saveVeiculo(veiculo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteVeiculo(@PathVariable("id") Long id) {
		veiculoService.deleteVeiculo(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Veiculo updateVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		veiculo.setId(id);
		return veiculoService.updateVeiculo(veiculo);
	}

}
