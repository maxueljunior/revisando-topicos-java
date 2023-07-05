package br.com.leuxam.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.leuxam.loja.orcamento.Orcamento;

public class EmAnalise extends SituacaoOrcamento{
	
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
	}
	
	public void aprovar(Orcamento orcamento) {
		orcamento.setSituacao(new Aprovado());
	}
	
	public void reprovar(Orcamento orcamento) {
		orcamento.setSituacao(new Reprovado());
	}
}
