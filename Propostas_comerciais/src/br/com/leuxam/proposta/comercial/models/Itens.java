package br.com.leuxam.proposta.comercial.models;

import java.math.BigDecimal;

public class Itens {
	private BigDecimal valor;
	private String descricao;
	
	public Itens(BigDecimal valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}
}
