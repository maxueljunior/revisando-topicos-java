package br.com.leuxam.proposta.comercial.models;

import java.util.HashSet;
import java.util.Set;

import br.com.leuxam.proposta.comercial.models.enums.Funcoes;

public class Orcamentista{
	
	private Informacoes informacoes;
	private Set<Funcoes> funcoes = new HashSet<>();
	
	public Orcamentista(Informacoes informacoes, Set<Funcoes> funcoes) {
		this.informacoes = informacoes;
		this.funcoes = funcoes;
	}

	public Set<Funcoes> getFuncoes() {
		return funcoes;
	}

	public Informacoes getInformacoes() {
		return informacoes;
	}
}
