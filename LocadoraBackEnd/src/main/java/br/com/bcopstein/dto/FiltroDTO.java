package br.com.bcopstein;
public class FiltroDTO {
    private DataLocalEntity inicioLocacao = new DataLocalEntity();
    private DataLocalEntity fimLocacao = new DataLocalEntity();
    private boolean arCondicionado = false;
    private boolean direcao = false;
    private boolean cambio = false;

    public FiltroDTO(DataLocalEntity inicioLocacao, DataLocalEntity fimLocacao, boolean arCondicionado, boolean direcao,
            boolean cambio) {
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.arCondicionado = arCondicionado;
        this.direcao = direcao;
        this.cambio = cambio;
    }

    public DataLocalEntity getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(DataLocalEntity inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public DataLocalEntity getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(DataLocalEntity fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public boolean isDirecao(){
        return direcao;
    }

    public boolean isCambio() {
        return cambio;
    }

    @Override
    public String toString() {
        return "FiltroDTO [arCondicionado=" + arCondicionado + ", cambio=" + cambio + ", direcao=" + direcao
                + ", fimLocacao=" + fimLocacao + ", inicioLocacao=" + inicioLocacao + "]";
    }
}
