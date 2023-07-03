package br.com.leuxa.desafio01.models;

public class Audio implements ActionsInterface{
    private String titulo;
    private Integer duracao;
    private Integer totalDeReproducoes;
    private Integer curtidas;
    private Double classificacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public void setTotalDeReproducoes(Integer totalDeReproducoes) {
        this.totalDeReproducoes = totalDeReproducoes;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public Double getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Double classificacao) {
        this.classificacao = classificacao;
    }

    public void curtir(){
        curtidas += 1;
    }

    public void reproduzir(){
        System.out.println("O audio: " + this.titulo + " está sendo reproduzido");
    }
}
