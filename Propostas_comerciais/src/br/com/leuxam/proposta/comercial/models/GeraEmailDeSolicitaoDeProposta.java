package br.com.leuxam.proposta.comercial.models;

import java.time.LocalDate;

public class GeraEmailDeSolicitaoDeProposta {
	private String cliente;
	private LocalDate prazo;
	private String maquina;
	
	public GeraEmailDeSolicitaoDeProposta(String cliente, LocalDate prazo, String maquina) {
		this.cliente = cliente;
		this.prazo = prazo;
		this.maquina = maquina;
	}

	public String getCliente() {
		return cliente;
	}

	public LocalDate getPrazo() {
		return prazo;
	}

	public String getMaquina() {
		return maquina;
	}
}
