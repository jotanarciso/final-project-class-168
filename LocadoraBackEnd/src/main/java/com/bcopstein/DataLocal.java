package com.bcopstein;

import java.util.Calendar;

public class DataLocal {
    private int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    private int mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
    private int ano = Calendar.getInstance().get(Calendar.YEAR);

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "DataLocal [ano=" + ano + ", dia=" + dia + ", mes=" + mes + "]";
    }
}
