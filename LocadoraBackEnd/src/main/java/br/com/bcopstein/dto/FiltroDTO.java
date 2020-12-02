package br.com.bcopstein.dto;

import br.com.bcopstein.entity.DataLocalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class FiltroDto {
	private DataLocalEntity inicioLocacao = new DataLocalEntity();
	private DataLocalEntity fimLocacao = new DataLocalEntity();
	private boolean arCondicionado = false;
	private boolean direcao = false;
	private boolean cambio = false;

//    public FiltroDto(DataLocalEntity inicioLocacao, DataLocalEntity fimLocacao, boolean arCondicionado, boolean direcao,
//            boolean cambio) {
//        this.inicioLocacao = inicioLocacao;
//        this.fimLocacao = fimLocacao;
//        this.arCondicionado = arCondicionado;
//        this.direcao = direcao;
//        this.cambio = cambio;
//    }
}
