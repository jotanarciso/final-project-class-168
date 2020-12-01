package br.com.bcopstein;

public class CarroDTO {
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

    public CarroDTO(DataLocalEntity inicioLocacao, DataLocalEntity fimLocacao, String placa, String marca, String modelo,
            boolean arCondicionado, boolean direcao, boolean cambio, double custoLocacao, double seguro,
            double desconto, double totalPagar) {
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arCondicionado = arCondicionado;
        this.direcao = direcao;
        this.cambio = cambio;
        this.custoLocacao = custoLocacao;
        this.seguro = seguro;
        this.desconto = desconto;
        this.totalPagar = totalPagar;
    }

    public DataLocalEntity getInicioLocacao() {
        return inicioLocacao;
    }

    public DataLocalEntity getFimLocacao() {
        return fimLocacao;
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

    public boolean isCambio() {
        return cambio;
    }

    public double getCustoLocacao() {
        return custoLocacao;
    }

    public double getSeguro() {
        return seguro;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    @Override
    public String toString() {
        return "CarroDTO [arcondicionado=" + arCondicionado + ", cambio=" + cambio + ", custoLocacao="
                + custoLocacao + ", desconto=" + desconto + ", direcao=" + direcao + ", fimLocacao=" + fimLocacao
                + ", inicioLocacao=" + inicioLocacao + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa
                + ", seguro=" + seguro + ", totalPagar=" + totalPagar + "]";
    }
}
