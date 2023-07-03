package br.com.leuxam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String aula1 = "Conhecendo mais de listas";
        String aula2 = "Modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos e Sets";

        List<String> aulas = new ArrayList<>();

        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);

        aulas.remove(0);

        System.out.println(aulas);

        for (String a:aulas) {
            System.out.println(a);
        }

        String primeiraAula = aulas.get(0);

        System.out.println(primeiraAula);

        for(int i = 0; i<aulas.size(); i++){
            System.out.println(aulas.get(i));
        }

        aulas.forEach(aula -> {
            System.out.println(aula);
        });

        aulas.add("Aumentando");
        Collections.sort(aulas);

        System.out.println(aulas);

    }
}