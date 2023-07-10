package br.com.leuxam.proposta.comercial.models;

import java.util.HashSet;
import java.util.Set;

import br.com.leuxam.proposta.comercial.models.enums.Funcoes;

public class CoordenadorRegionalDeVendas{
	
	private Informacoes informacoes;
	private Set<Funcoes> funcoes = new HashSet<>();
	
	public CoordenadorRegionalDeVendas(Informacoes informacoes, Set<Funcoes> funcoes) {
		this.informacoes = informacoes;
		this.funcoes = funcoes;
	}

	public Informacoes getInformacoes() {
		return informacoes;
	}

	public Set<Funcoes> getFuncoes() {
		return funcoes;
	}
	
}
