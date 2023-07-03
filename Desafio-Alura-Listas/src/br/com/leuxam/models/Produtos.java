package br.com.leuxam.models;

public class Produtos implements Comparable<Produtos>{
    private Integer id;
    private String descricao;
    private Double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Produtos o) {
        return Double.valueOf(this.valor).compareTo(o.getValor());
        //return this.valor.compareTo(o.getValor());
        //return o.getValor().compareTo(this.valor);
    }
}
