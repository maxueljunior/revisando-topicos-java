package br.com.leuxam.models;

import java.util.ArrayList;
import java.util.List;

public class Proposta{
    private Integer numero;
    private Orcamentista orcamentista;
    private CRV crv;
    private List<Produtos> produtosList = new ArrayList<>();

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Orcamentista getOrcamentista() {
        return orcamentista;
    }

    public void setOrcamentista(Orcamentista orcamentista) {
        this.orcamentista = orcamentista;
    }

    public CRV getCrv() {
        return crv;
    }

    public void setCrv(CRV crv) {
        this.crv = crv;
    }

    public List<Produtos> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(Produtos produtosList) {
        this.produtosList.add(produtosList);
    }
}
