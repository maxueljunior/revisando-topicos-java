package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class ValidacaoDescontoMaiorQueMil extends Desconto{

	public ValidacaoDescontoMaiorQueMil(Desconto proximo) {
		super(proximo);
	}

	public BigDecimal desconto(PropostaComercial propostaComercial) {
		
		if(propostaComercial.getValor().compareTo(new BigDecimal("1000.00")) > 0 ) {
			return propostaComercial.getValor().subtract(propostaComercial.getValor().multiply(new BigDecimal("0.10")));
		}
		
		return proximo.desconto(propostaComercial);
	}
}
