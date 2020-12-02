package br.com.bcopstein.dto;

import br.com.bcopstein.entity.DataLocalEntity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CarroDto {
    private DataLocalEntity inicioLocacao;
    private DataLocalEntity fimLocacao;
    private String placa;
    private String marca;
    private String modelo;
    private boolean arCondicionado;
    private boolean direcao;
    private boolean cambio;    
    private double custoLocacao;
    private double seguro;
    private double desconto;
    private double totalPagar;

}
