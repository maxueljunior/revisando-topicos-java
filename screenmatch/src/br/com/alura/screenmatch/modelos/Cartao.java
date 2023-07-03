package br.com.alura.screenmatch.modelos;

import java.util.ArrayList;
import java.util.List;

public class Cartao{
    private Double limite;
    private List<Compras> compras = new ArrayList<>();

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public List<Compras> getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras.add(compras);
    }

}
