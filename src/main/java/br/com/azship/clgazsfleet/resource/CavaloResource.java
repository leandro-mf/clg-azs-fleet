package br.com.azship.clgazsfleet.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azship.clgazsfleet.model.Cavalo;
import br.com.azship.clgazsfleet.service.VeiculoService;

@RestController
@RequestMapping(CavaloResource.BASE_URL)
public class CavaloResource extends VeiculoResource<Cavalo> {
	
	public static final String BASE_URL = "/api/v1/cavalos";
	
	public CavaloResource(VeiculoService<Cavalo> veiculoService) {
		super(veiculoService);
	}

}
