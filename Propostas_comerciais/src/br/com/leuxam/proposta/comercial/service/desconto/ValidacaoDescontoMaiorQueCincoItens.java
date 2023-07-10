package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class ValidacaoDescontoMaiorQueCincoItens extends Desconto{
	
	public ValidacaoDescontoMaiorQueCincoItens(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal desconto(PropostaComercial propostaComercial) {
	
		if(propostaComercial.getItens().size() > 5) {
			return propostaComercial.getValor().subtract(propostaComercial.getValor().multiply(new BigDecimal("0.15")));
		}
		
		return proximo.desconto(propostaComercial);
	}
}
