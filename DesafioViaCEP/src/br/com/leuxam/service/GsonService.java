package br.com.leuxam.service;

import br.com.leuxam.models.Informacoes;
import br.com.leuxam.models.InformacoesViaCEP;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class GsonService {

    public static InformacoesViaCEP converterToObject(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        InformacoesViaCEP cep;
        cep = gson.fromJson(json, InformacoesViaCEP.class);
        return cep;
    }

    public static String converterToJson(InformacoesViaCEP info){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(info);
    }

    public static String converterToJson(List<Informacoes> listDeInformacoes){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(listDeInformacoes);
    }
}
