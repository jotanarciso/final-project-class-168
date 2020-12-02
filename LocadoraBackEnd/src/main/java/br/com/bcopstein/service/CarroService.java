package br.com.bcopstein.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bcopstein.dto.CarroDto;
import br.com.bcopstein.entity.DataLocalEntity;
import br.com.bcopstein.repository.CarroRepositoryImpl;

@Service
public class CarroService {

	CarroRepositoryImpl carroRepository;

	@Autowired
	public CarroService(CarroRepositoryImpl carroRepository) {
		this.carroRepository = carroRepository;
	}

	public List<CarroDto> todos() {
		return (List<CarroDto>) carroRepository.todos();
	}

	public Boolean alugar(CarroDto carro) {
		carro.setInicioLocacao(DataLocalEntity.builder().build());
		carroRepository.remove(carro.getPlaca());
		carroRepository.cadastra(carro);
		return Boolean.TRUE;
	}
	
	public Boolean devolver(String placa) {
		CarroDto carroToInsert = carroRepository.recupera(placa);
		carroRepository.remove(placa);
		carroToInsert.setInicioLocacao(null);
		carroToInsert.setFimLocacao(DataLocalEntity.builder().build());
		carroRepository.cadastra(carroToInsert);
		return Boolean.TRUE;
	}

}