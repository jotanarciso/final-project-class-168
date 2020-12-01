package br.com.bcopstein;

public class CarroEntity {
    private String placa;
    private String marca;
    private String modelo;
    private boolean arCondicionado;
    private boolean direcao;
    private boolean cambioAutomatico;

    public CarroEntity(String placa, String marca, String modelo, boolean arCondicionado, boolean direcao,
            boolean cambioAutomatico) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arCondicionado = arCondicionado;
        this.direcao = direcao;
        this.cambioAutomatico = cambioAutomatico;
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

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public boolean isCambioAutomatico() {
        return cambioAutomatico;
    }

    @Override
    public String toString() {
        return "Carro [arcondicionado=" + arCondicionado + ", cambioautomatico=" + cambioAutomatico + ", direcao="
                + direcao + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
    }
}
