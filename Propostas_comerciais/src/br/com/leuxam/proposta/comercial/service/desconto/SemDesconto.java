package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class SemDesconto extends Desconto{
	
	public SemDesconto() {
		super(null);
	}

	@Override
	public BigDecimal efetuarDesconto(PropostaComercial propostaComercial) {
		return BigDecimal.ZERO;
	}

	@Override
	public Boolean deveAplicar(PropostaComercial propostaComercial) {
		return true;
	}
}
