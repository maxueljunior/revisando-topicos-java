package br.com.alura.screenmatch.modelos;

public class Compras implements Comparable<Compras>{
    private String nomeDoProduto;
    private Double preco;

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Compras o) {
        return Double.valueOf(this.preco).compareTo(Double.valueOf(o.preco));
    }

    @Override
    public String toString() {
        return "Compras{" +
                "nomeDoProduto='" + nomeDoProduto + '\'' +
                ", preco=" + preco +
                '}';
    }
}
