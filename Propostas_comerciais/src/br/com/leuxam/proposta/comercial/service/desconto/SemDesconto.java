package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class SemDesconto extends Desconto{
	
	public SemDesconto() {
		super(null);
	}

	public BigDecimal desconto(PropostaComercial propostaComercial) {
	
		return BigDecimal.ZERO;
		
	}
}
