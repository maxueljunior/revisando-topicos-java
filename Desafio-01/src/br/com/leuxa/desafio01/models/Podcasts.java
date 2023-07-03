package br.com.leuxa.desafio01.models;

public class Podcasts extends Audio{
    private Boolean aoVivo;
    private String entrevistador;
    private String entrevistado;

    public String getEntrevistador() {
        return entrevistador;
    }

    public void setEntrevistador(String entrevistador) {
        this.entrevistador = entrevistador;
    }

    public String getEntrevistado() {
        return entrevistado;
    }

    public void setEntrevistado(String entrevistado) {
        this.entrevistado = entrevistado;
    }

    public Boolean getAoVivo() {
        return aoVivo;
    }

    public void setAoVivo(Boolean aoVivo) {
        this.aoVivo = aoVivo;
    }
}
