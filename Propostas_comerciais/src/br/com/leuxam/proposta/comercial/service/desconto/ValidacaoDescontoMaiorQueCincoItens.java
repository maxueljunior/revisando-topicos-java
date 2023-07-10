package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class ValidacaoDescontoMaiorQueCincoItens extends Desconto{
	
	public ValidacaoDescontoMaiorQueCincoItens(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal efetuarDesconto(PropostaComercial propostaComercial) {
		return propostaComercial.getValor().subtract(propostaComercial.getValor().multiply(new BigDecimal("0.15")));
	}

	@Override
	public Boolean deveAplicar(PropostaComercial propostaComercial) {
		return propostaComercial.getItens().size() > 5;
	}
}
