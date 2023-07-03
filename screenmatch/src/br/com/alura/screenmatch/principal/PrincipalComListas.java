package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(1971);

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(1972);

        Filme filmeDoPaulo = new Filme();
        filmeDoPaulo.setNome("Dogville");
        filmeDoPaulo.setAnoDeLancamento(1973);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item:lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme){
                System.out.println(filme.getClassificacao());
            }

        }
        Titulo f1 = filmeDoPaulo;
        lista.forEach(nome -> System.out.println(nome.getNome()));

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        lista.forEach(x -> {
            System.out.println(x.getNome());
        });

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        lista.forEach(x -> {
            System.out.println(x.getNome());
        });


    }
}
