package br.com.leuxam.loja.imposto;

import java.math.BigDecimal;

import br.com.leuxam.loja.orcamento.Orcamento;

public class ICMS extends Imposto{
	
	public ICMS(Imposto outro) {
		super(outro);
	}

	public BigDecimal realizarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}
}
