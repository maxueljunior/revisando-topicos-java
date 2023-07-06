package br.com.leuxam.loja.orcamento;

import java.util.Map;

import br.com.leuxam.loja.DomainException;
import br.com.leuxam.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
	
	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}

	public void registrar(Orcamento orcamento) {
		
		if(!orcamento.isFinalizado()) {
			throw new DomainException("Orçamento não finalizado!");
		}
		
		String url = "http://api.externa/orcamento";
		Map<String, Object> dados = Map.of(
		                              "valor", orcamento.getValor(),
		                              "quantidadeItens", orcamento.getQuantidadeItens());
		http.post(url, dados);
	}
}
