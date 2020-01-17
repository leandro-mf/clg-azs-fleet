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

import br.com.azship.clgazsfleet.model.Motorista;
import br.com.azship.clgazsfleet.service.MotoristaService;

@RestController
@RequestMapping(MotoristaResource.BASE_URL)
@CrossOrigin(origins = "*")
public class MotoristaResource {
	
	public static final String BASE_URL = "/api/v1/motoristas";
	
	private final MotoristaService motoristaService;

	public MotoristaResource(MotoristaService motoristaService) {
		this.motoristaService = motoristaService;
	}	
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Motorista> getAllMotoristas() {
		return motoristaService.findAllMotoristas();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Motorista getMotoristaById(@PathVariable("id") Long id) {
		return motoristaService.findMotoristaById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Motorista saveMotorista(@RequestBody Motorista motorista) {
		return motoristaService.saveMotorista(motorista);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMotorista(@PathVariable("id") Long id) {
		motoristaService.deleteMotorista(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Motorista updateMotorista(@PathVariable("id") Long id, @RequestBody Motorista motorista) {
		motorista.setId(id);
		return motoristaService.updateMotorista(motorista);
	}
	
}
