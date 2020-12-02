package br.com.bcopstein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bcopstein.dto.CarroDto;
import br.com.bcopstein.dto.FiltroDto;
import br.com.bcopstein.service.CarroService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/locadora")
@Api(tags = "Endpoint de Locação de Veículos")

public class LocadoraController {

	CarroService carroService;

	@Autowired
	public LocadoraController(CarroService carroService) {
		this.carroService = carroService;
	}

	@GetMapping("/carrosDisponiveis")
	@CrossOrigin(origins = "*")
	public List<CarroDto> carrosDisponiveis(FiltroDto filtro) {
		List<CarroDto> carros = carroService.todos().stream()
				.filter(carro -> carro.isArCondicionado() == filtro.isArCondicionado() || filtro.isArCondicionado() == false)
				.filter(carro -> carro.isDirecao() == filtro.isDirecao() || filtro.isDirecao() == false)
				.filter(carro -> carro.isCambio() == filtro.isCambio() || filtro.isCambio() == false)
				.filter(carro -> carro.getInicioLocacao() == null)
				.collect(Collectors.toList());
		return carros;
	}
	
	@PostMapping("/confirmaLocacao")
	@CrossOrigin(origins = "*")
	public boolean confirmaLocacao(@RequestBody final CarroDto carro) {
		return carroService.alugar(carro);
	}
	
	@PostMapping("/devolverVeiculo")
	@CrossOrigin(origins = "*")
	public Boolean devolver(@RequestBody Map<String, Object> placa) {
		System.out.println(placa);
		String teste = (String) placa.get("placa");
		return carroService.devolver(teste);
	}

}
