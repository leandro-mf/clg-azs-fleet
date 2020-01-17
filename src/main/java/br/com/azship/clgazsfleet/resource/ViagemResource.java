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
	@ResponseStatus(code = HttpStatus.OK)
	public List<Viagem> getAllViagens() {
		return viagemService.findAllViagens();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Viagem getViagem(@PathVariable("id") Long id) {
		return viagemService.findViagemById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Viagem saveViagem(@RequestBody Viagem viagem) {
		return viagemService.saveViagem(viagem);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteViagem(@PathVariable("id") Long id) {
		viagemService.deleteViagem(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Viagem updateViagem(@PathVariable("id") Long id, @RequestBody Viagem viagem) {
		viagem.setId(id);
		return viagemService.updateViagem(viagem);
	}
	
}
