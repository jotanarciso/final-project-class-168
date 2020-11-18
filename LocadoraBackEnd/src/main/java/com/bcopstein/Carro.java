package com.bcopstein;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private boolean arcondicionado;
    private boolean direcao;
    private boolean cambioautomatico;

    public Carro(String placa, String marca, String modelo, boolean arcondicionado, boolean direcao,
            boolean cambioautomatico) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambioautomatico = cambioautomatico;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public boolean isCambioautomatico() {
        return cambioautomatico;
    }

    @Override
    public String toString() {
        return "Carro [arcondicionado=" + arcondicionado + ", cambioautomatico=" + cambioautomatico + ", direcao="
                + direcao + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
    } 
}
