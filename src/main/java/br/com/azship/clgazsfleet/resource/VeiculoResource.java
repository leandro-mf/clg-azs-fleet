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
public class VeiculoResource<T extends Veiculo> {

	public static final String BASE_URL = "/api/v1/veiculos";

	private final VeiculoService<T> veiculoService;

	public VeiculoResource(VeiculoService<T> veiculoService) {
		this.veiculoService = veiculoService;
	}

	@GetMapping
	public ResponseEntity<List<T>> get() {
		return ResponseEntity.ok().body(veiculoService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<T> get(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok().body(veiculoService.findById(id));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<T> post(@RequestBody T veiculo) {
		T savedVeiculo = veiculoService.save(veiculo);
		StringBuilder sb = new StringBuilder();
		sb.append(BASE_URL).append("/").append(savedVeiculo.getId());
		return ResponseEntity.created(URI.create(sb.toString())).body(savedVeiculo);
	}

	@PutMapping("{id}")
	public ResponseEntity<T> put(@PathVariable("id") Long id, @RequestBody T veiculo) {
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