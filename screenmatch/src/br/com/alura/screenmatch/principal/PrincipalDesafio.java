package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Cartao;
import br.com.alura.screenmatch.modelos.Compras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrincipalDesafio {
    public static void main(String[] args) {

        Cartao cartao = new Cartao();

        cartao.setLimite(1000.0);

        Compras c1 = new Compras();
        c1.setNomeDoProduto("Meia");
        c1.setPreco(100.0);
        cartao.setCompras(c1);

        Compras c2 = new Compras();
        c2.setNomeDoProduto("Roupas");
        c2.setPreco(850.0);
        cartao.setCompras(c2);

        Compras c3 = new Compras();
        c3.setNomeDoProduto("Blusa");
        c3.setPreco(50.0);
        cartao.setCompras(c3);

        System.out.println(cartao.getCompras());
        Collections.sort(cartao.getCompras());
        System.out.println(cartao.getCompras());

    }
}
