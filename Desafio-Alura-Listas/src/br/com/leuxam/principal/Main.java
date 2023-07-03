package br.com.leuxam.principal;

import br.com.leuxam.models.CRV;
import br.com.leuxam.models.Orcamentista;
import br.com.leuxam.models.Produtos;
import br.com.leuxam.models.Proposta;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        CRV crv1 = new CRV();
        Orcamentista orcamentista1 = new Orcamentista();

        crv1.setId(1);
        crv1.setNome("André Mendes");
        crv1.setCnpj("11.111.1111.111/111");
        crv1.setIdEmpresa(1704);
        crv1.setRazaoSocial("TGM Turbinas");

        // ---------------------------------------------

        orcamentista1.setId(1782);
        orcamentista1.setNome("Maxuel Vieira Tobá Junior");
        orcamentista1.setCnpj("11.111.1111.111/111");
        orcamentista1.setRazaoSocial("TGM Turbinas");

        // ---------------------------------------------

        Proposta proposta1 = new Proposta();

        proposta1.setCrv(crv1);
        proposta1.setNumero(1288);
        proposta1.setOrcamentista(orcamentista1);

        // ---------------------------------------------

        Produtos haste = new Produtos();
        haste.setId(10);
        haste.setDescricao("HASTE V.F.R");
        haste.setValor(15000.00);

        Produtos embolo = new Produtos();
        embolo.setId(25);
        embolo.setDescricao("EMBOLO V.F.R");
        embolo.setValor(1000.00);

        Produtos mola = new Produtos();
        mola.setId(1);
        mola.setDescricao("MOLA DO CILINDRO V.F.R");
        mola.setValor(43.00);

        // ---------------------------------------------

        proposta1.setProdutosList(haste);
        proposta1.setProdutosList(embolo);
        proposta1.setProdutosList(mola);
        crv1.setPropostas(proposta1);
        orcamentista1.setPropostas(proposta1);

        // ---------------------------------------------

        System.out.println("**** PROPOSTA Nº " + proposta1.getNumero() + " ****");
        System.out.println("**** CRV: " + proposta1.getCrv().getNome() + " ****");
        System.out.println("**** Orçamentista: " + proposta1.getOrcamentista().getNome() + " ****");

        proposta1.getProdutosList().forEach(x -> {
            System.out.println(x.getDescricao() + " - " + x.getValor());
        });

        System.out.println("\n**** ORDENADO POR PREÇO CONFORME SOLICITADO CLIENTE ****\n");

        Collections.sort(proposta1.getProdutosList());

        proposta1.getProdutosList().forEach(x -> {
            System.out.println(x.getDescricao() + " - " + x.getValor());
        });

        System.out.println("\n**** ORDENADO POR DESCRIÇÃO CONFORME SOLICITADO CLIENTE ****\n");

        proposta1.getProdutosList().sort(Comparator.comparing(Produtos::getDescricao));

        proposta1.getProdutosList().forEach(x -> {
            System.out.println(x.getDescricao() + " - " + x.getValor());
        });

    }
}