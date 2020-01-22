package br.com.azship.clgazsfleet.resource;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.service.MotoristaService;

@RestController
@RequestMapping(MotoristaResource.BASE_URL)
@CrossOrigin(origins = "*")
public class MotoristaResource {

	public static final String BASE_URL = "/api/v1/motoristas";

	private static final Logger LOGGER = LoggerFactory.getLogger(MotoristaResource.class);
	
	private final MotoristaService motoristaService;

	public MotoristaResource(MotoristaService motoristaService) {
		this.motoristaService = motoristaService;
	}

	@GetMapping
	public ResponseEntity<List<Motorista>> get() {
		LOGGER.info(">>> GET recebido em {} <<<", BASE_URL);
		return ResponseEntity.ok().body(motoristaService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Motorista> get(@PathVariable("id") Long id) {
		LOGGER.info(">>> GET recebido em {}/{} <<<", BASE_URL, id);
		try {
			return ResponseEntity.ok().body(motoristaService.findById(id));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Motorista> post(@RequestBody Motorista motorista) {
		LOGGER.info(">>> POST recebido em {} <<<", BASE_URL);
		Motorista savedMotorista = motoristaService.save(motorista);
		StringBuilder sb = new StringBuilder();
		sb.append(BASE_URL).append("/").append(savedMotorista.getId());
		return ResponseEntity.created(URI.create(sb.toString())).body(savedMotorista);
	}

	@PutMapping("{id}")
	public ResponseEntity<Motorista> put(@PathVariable("id") Long id, @RequestBody Motorista motorista) {
		LOGGER.info(">>> PUT recebido em {}/{} <<<", BASE_URL, id);
		motorista.setId(id);
		return ResponseEntity.ok().body(motoristaService.update(motorista));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		LOGGER.info(">>> DELETE recebido em {}/{} <<<", BASE_URL, id);
		try {
			motoristaService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
