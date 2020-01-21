package br.com.azship.clgazsfleet.resource;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
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

import br.com.azship.clgazsfleet.model.Viagem;
import br.com.azship.clgazsfleet.service.ViagemService;

@RestController
@RequestMapping(ViagemResource.BASE_URL)
@CrossOrigin(origins = "*")
public class ViagemResource {

	public static final String BASE_URL = "/api/v1/viagens";

	private final ViagemService viagemService;

	public ViagemResource(ViagemService viagemService) {
		this.viagemService = viagemService;
	}

	@GetMapping
	public ResponseEntity<List<Viagem>> get() {
		return ResponseEntity.ok().body(viagemService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Viagem> get(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok().body(viagemService.findById(id));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Viagem> post(@RequestBody Viagem viagem) {
		Viagem savedViagem = viagemService.save(viagem);
		StringBuilder sb = new StringBuilder();
		sb.append(BASE_URL).append("/").append(savedViagem.getId());
		return ResponseEntity.created(URI.create(sb.toString())).body(savedViagem);
	}

	@PutMapping("{id}")
	public ResponseEntity<Viagem> put(@PathVariable("id") Long id, @RequestBody Viagem viagem) {
		viagem.setId(id);
		return ResponseEntity.ok().body(viagemService.update(viagem));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			viagemService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		} 
	}

}
