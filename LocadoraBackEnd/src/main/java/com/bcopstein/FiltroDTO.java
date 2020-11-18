package com.bcopstein;

public class FiltroDTO {
    private DataLocal inicioLocacao = new DataLocal();
    private DataLocal fimLocacao = new DataLocal();
    private boolean arcondicionado = false;
    private boolean direcao = false;
    private boolean cambio = false;

    public FiltroDTO(DataLocal inicioLocacao, DataLocal fimLocacao, boolean arcondicionado, boolean direcao,
            boolean cambio) {
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambio = cambio;
    }

    public DataLocal getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(DataLocal inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public DataLocal getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(DataLocal fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public boolean isDirecao(){
        return direcao;
    }

    public boolean isCambio() {
        return cambio;
    }

    @Override
    public String toString() {
        return "FiltroDTO [arcondicionado=" + arcondicionado + ", cambio=" + cambio + ", direcao=" + direcao
                + ", fimLocacao=" + fimLocacao + ", inicioLocacao=" + inicioLocacao + "]";
    }
}
