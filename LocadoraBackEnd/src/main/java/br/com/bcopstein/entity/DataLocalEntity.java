package br.com.bcopstein.entity;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class DataLocalEntity {
    private int dia;
    private int mes;
    private int ano;
    
    public DataLocalEntity() {
    	this.dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    	this.mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
    	this.ano = Calendar.getInstance().get(Calendar.YEAR);
    }
}
