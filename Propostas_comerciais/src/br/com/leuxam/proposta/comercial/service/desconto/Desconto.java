package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public abstract class Desconto {
	
	protected Desconto proximo;

	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}
	
	public BigDecimal desconto(PropostaComercial propostaComercial) {
		if(deveAplicar(propostaComercial)) {
			return efetuarDesconto(propostaComercial);
		}
		return proximo.desconto(propostaComercial);
	}
	
	public abstract BigDecimal efetuarDesconto(PropostaComercial propostaComercial);
	
	public abstract Boolean deveAplicar(PropostaComercial propostaComercial);
}
