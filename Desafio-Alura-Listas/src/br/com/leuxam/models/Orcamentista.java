package br.com.leuxam.models;

import java.util.ArrayList;
import java.util.List;

public class Orcamentista extends Empresa{
    private Integer id;
    private String nome;
    private List<Proposta> propostas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(Proposta propostas) {
        this.propostas.add(propostas);
    }
}
