package br.com.leuxam.proposta.comercial.service.cliente;

import br.com.leuxam.proposta.comercial.models.Cliente;
import br.com.leuxam.proposta.comercial.service.cliente.http.HttpAdapter;

public class BuscarClienteService {
	private HttpAdapter httpAdapter;

	public BuscarClienteService(HttpAdapter httpAdapter) {
		this.httpAdapter = httpAdapter;
	}
	
	public void buscarCliente(Cliente cliente) {
		String url = "http://www.google.com";
		httpAdapter.post(url);
	}
	
}
