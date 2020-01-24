package br.com.azship.clgazsfleet.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azship.clgazsfleet.model.Reboque;
import br.com.azship.clgazsfleet.service.VeiculoService;

@RestController
@RequestMapping(ReboqueResource.BASE_URL)
public class ReboqueResource extends VeiculoResource<Reboque>{

	public static final String BASE_URL = "/api/v1/reboques";
	
	public ReboqueResource(VeiculoService<Reboque> veiculoService) {
		super(veiculoService);
	}
	
}
