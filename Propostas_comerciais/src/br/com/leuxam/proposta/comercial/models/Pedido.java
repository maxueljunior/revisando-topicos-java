package br.com.leuxam.proposta.comercial.models;

import java.time.LocalDate;

public class Pedido {
	private String cliente;
	private LocalDate data;
	private PropostaComercial propostaComercial;
	
	public Pedido(String cliente, LocalDate data, PropostaComercial propostaComercial) {
		this.cliente = cliente;
		this.data = data;
		this.propostaComercial = propostaComercial;
	}
	
	public String getCliente() {
		return cliente;
	}
	public LocalDate getData() {
		return data;
	}
	public PropostaComercial getPropostaComercial() {
		return propostaComercial;
	}
	
	
}
