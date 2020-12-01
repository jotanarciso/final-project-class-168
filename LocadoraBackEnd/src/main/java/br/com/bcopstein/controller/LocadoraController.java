package br.com.bcopstein;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/locadora")
@Api(tags = "Endpoint de Locação de Veículos")

public class LocadoraController {
  private final List<CarroEntity> carros;

  public LocadoraController() {
    // Cria o banco de carros
    carros = new ArrayList<>(); 
    carros.add(new CarroEntity("ABC123", "ACME", "M1", false, false, false));  // botar em service
    carros.add(new CarroEntity("ABC129", "ACME", "M4", false, false, false)); 
    carros.add(new CarroEntity("ABC124", "ACME", "M2", true, false, false));
    carros.add(new CarroEntity("ABC125", "ACME", "M1", true, true, false));
    carros.add(new CarroEntity("ABC126", "ACME", "M2", true, true, true));
    carros.add(new CarroEntity("ABC128", "ACME", "M4", true, true, true));
    carros.add(new CarroEntity("ABC127", "ACME", "M3", false, true, true));
  }

  @GetMapping("/carrosDisponiveis")
  @CrossOrigin(origins = "*")
  public List<CarroDTO> carrosDisponiveis(FiltroDTO filtro) { 
    // Está selecionando apenas pelos equipamentos
    // Não está verificando se o carro está livre naquelas datas
    List<CarroEntity> disponiveis = carros.stream()
      .filter(c->c.isArCondicionado() == filtro.isArCondicionado())
      .filter(c->c.isDirecao() == filtro.isDirecao())
      .filter(c->c.isCambioAutomatico() == filtro.isCambio())
      .collect(Collectors.toList());
    List<CarroDTO> informacoes = new ArrayList<>(disponiveis.size());
    // Não está calculando o valor das diárias, seguro, desconto ou total
    disponiveis.forEach(c->{
      informacoes.add(new CarroDTO(filtro.getInicioLocacao(),
                                        filtro.getFimLocacao(),
                                        c.getPlaca(),
                                        c.getMarca(),
                                        c.getModelo(),
                                        c.isArCondicionado(),
                                        c.isDirecao(),
                                        c.isCambioAutomatico(),
                                        1000.0, // Total das diárias
                                        100.0,  // Custo do seguro
                                        200.0,   // Total do desconto
                                        900.0)); // Valor a pagar
    });
    return informacoes;
  }

  @PostMapping("/confirmaLocacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaLocacao(@RequestBody final CarroDTO carro) {
    // Está confirmando qualquer coisa
    return true;
  }

}
