package br.com.azship.clgazsfleet.resource;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<List<Veiculo>> get() {
		return ResponseEntity.ok().body(veiculoService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Veiculo> get(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok().body(veiculoService.findById(id));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Veiculo> post(@RequestBody Veiculo veiculo) {
		Veiculo savedVeiculo = veiculoService.save(veiculo);
		StringBuilder sb = new StringBuilder();
		sb.append(BASE_URL).append("/").append(savedVeiculo.getId());
		return ResponseEntity.created(URI.create(sb.toString())).body(savedVeiculo);
	}

	@PutMapping("{id}")
	public ResponseEntity<Veiculo> put(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		veiculo.setId(id);
		return ResponseEntity.ok().body(veiculoService.update(veiculo));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			veiculoService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}