package br.com.leuxam.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse response;
    public HttpService(){

    }

    public String requestHttp(String url) throws IOException, InterruptedException {
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        this.client.sendAsync(this.request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        this.response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
        return (String) this.response.body();
    }
}
