package br.com.leuxa.desafio01.models;

public class Musicas extends Audio{
    private String nomeDaBanda;
    private Boolean temDvd;

    public String getNomeDaBanda() {
        return nomeDaBanda;
    }

    public void setNomeDaBanda(String nomeDaBanda) {
        this.nomeDaBanda = nomeDaBanda;
    }

    public Boolean getTemDvd() {
        return temDvd;
    }

    public void setTemDvd(Boolean temDvd) {
        this.temDvd = temDvd;
    }

}
