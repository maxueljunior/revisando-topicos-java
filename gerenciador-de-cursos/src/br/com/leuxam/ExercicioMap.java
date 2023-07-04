package br.com.leuxam;

import java.util.HashMap;
import java.util.Map;

public class ExercicioMap {
    public static <Entry> void main(String[] args) {
        Map<String, Integer> nomesParaIdade = new HashMap<>();
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);
        // ...

        nomesParaIdade.keySet().forEach(nomes -> {
            System.out.println(nomes);
        });

        nomesParaIdade.values().forEach(idades ->{
            System.out.println(idades);
        });

        Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();
        for (Entry<String, Integer> associacao : associacoes) {
            System.out.println(associacao.getKey() + " - " + associacao.getValue());
        }
    }
}
