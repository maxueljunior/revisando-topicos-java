package br.com.leuxam.proposta.comercial.models;

public class Cliente {
	
	private String razaoSocial;
	private String cnpj;
	
	public Cliente(String razaoSocial, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}
	
}
