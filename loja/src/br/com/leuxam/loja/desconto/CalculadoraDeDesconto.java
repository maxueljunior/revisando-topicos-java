package br.com.leuxam.loja.desconto;

import java.math.BigDecimal;

import br.com.leuxam.loja.orcamento.Orcamento;

public class CalculadoraDeDesconto {
	
	public BigDecimal calcular(Orcamento orcamento) {
		
		Desconto desconto = new DescontoParaOrcamentoComMaisDeCincoItens(
				new DescontoParaOrcamentoComValorMaiorQueQuinhentos(
						new SemDesconto()));
		
		return desconto.calcular(orcamento);
	}
}
