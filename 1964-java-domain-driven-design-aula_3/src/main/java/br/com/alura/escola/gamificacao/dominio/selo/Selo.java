package br.com.alura.escola.gamificacao.dominio.selo;

import br.com.alura.escola.shared.dominio.CPF;

public class Selo {
	
	private CPF cpf;
	private String nome;
	
	public Selo(CPF cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
}
