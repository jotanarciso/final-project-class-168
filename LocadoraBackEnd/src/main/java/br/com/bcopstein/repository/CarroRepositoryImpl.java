package br.com.bcopstein.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.bcopstein.dto.CarroDto;

@Repository
public class CarroRepositoryImpl implements Repositorio<CarroDto, String> {

	List<CarroDto> dataMock;

	@Autowired
	public CarroRepositoryImpl() {
		initMock();
	}

	public void initMock() {
		dataMock = new ArrayList<CarroDto>();
		dataMock.add(CarroDto.builder().placa("ABC111").marca("AC11").modelo("M111").arCondicionado(true).cambio(true)
				.direcao(true).build());
		dataMock.add(CarroDto.builder().placa("ABC222").marca("AC22").modelo("M222").arCondicionado(false).cambio(true)
				.direcao(false).build());
		dataMock.add(CarroDto.builder().placa("ABC333").marca("AC33").modelo("M333").arCondicionado(true).cambio(false)
				.direcao(false).build());
	}

	@Override
	public Collection<CarroDto> todos() {
		return dataMock;
	}

	@Override
	public void cadastra(CarroDto elemento) {
		todos().add(elemento);
	}

	@Override
	public boolean existente(String chave) {
		return todos().stream().filter(c -> c.getPlaca().equalsIgnoreCase(chave)).collect(Collectors.toList())
				.size() >= 1 ? true : false;
	}

	@Override
	public void atualiza(CarroDto elemento) {
		remove(elemento.getPlaca());
		cadastra(elemento);
	}

	@Override
	public void remove(String chave) {
		List<CarroDto> carro = todos().stream().filter(c -> c.getPlaca().contentEquals(chave))
				.collect(Collectors.toList());
		if (!carro.isEmpty()) {
			todos().remove(carro.get(0));
		}
	}

	@Override
	public CarroDto recupera(String chave) {
		for(CarroDto carro : todos()) {
			if(carro.getPlaca().equalsIgnoreCase(chave)) {
				return carro;
			}
		}
		return null;
	}

	@Override
	public Collection<CarroDto> pesquisa(Predicate<CarroDto> pred) {
		return null;
	}

	@Override
	public void carrega() {

	}

	@Override
	public void persiste() {

	}

}
