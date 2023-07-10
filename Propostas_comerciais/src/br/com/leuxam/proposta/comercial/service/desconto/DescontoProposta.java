package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class DescontoProposta {
	
	public BigDecimal desconto(PropostaComercial propostaComercial) {
		
		Desconto desconto = new ValidacaoDescontoMaiorQueMil(
				new ValidacaoDescontoMaiorQueCincoItens(
						new SemDesconto()));
		
		return desconto.desconto(propostaComercial);
	}
}
