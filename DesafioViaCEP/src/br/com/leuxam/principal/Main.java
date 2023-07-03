package br.com.leuxam.principal;

import br.com.leuxam.models.Informacoes;
import br.com.leuxam.models.InformacoesViaCEP;
import br.com.leuxam.service.FileService;
import br.com.leuxam.service.GsonService;
import br.com.leuxam.service.HttpService;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String cepDigitadoPeloUsuario;
        HttpService service = new HttpService();
        List<Informacoes> todos = new ArrayList<>();
        String json;

        try {
            for (int i = 0; i < 2; i++) {

                System.out.println("Digite o numero do CEP");
                cepDigitadoPeloUsuario = sc.nextLine();

                String informacoesJson = service.requestHttp("http://viacep.com.br/ws/" + cepDigitadoPeloUsuario.replace("-", "") + "/json/");

                InformacoesViaCEP cep = GsonService.converterToObject(informacoesJson);
                Informacoes cepNovo = new Informacoes(cep);
                todos.add(cepNovo);
            }
        }catch (JsonSyntaxException e){
            System.out.println("Algo deu errado! Verifique novamente o CEP informado.");
        }

        json = GsonService.converterToJson(todos);
        FileService.writeArchiveWithJson("escrevendo-em-json", json);

    }
}