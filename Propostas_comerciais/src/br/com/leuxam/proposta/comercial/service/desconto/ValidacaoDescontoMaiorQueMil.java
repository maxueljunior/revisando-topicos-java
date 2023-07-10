package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class ValidacaoDescontoMaiorQueMil extends Desconto{

	public ValidacaoDescontoMaiorQueMil(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal efetuarDesconto(PropostaComercial propostaComercial) {
		return propostaComercial.getValor().subtract(propostaComercial.getValor().multiply(new BigDecimal("0.10")));
	}

	@Override
	public Boolean deveAplicar(PropostaComercial propostaComercial) {
		// TODO Auto-generated method stub
		return propostaComercial.getValor().compareTo(new BigDecimal("1000.00")) > 0;
	}
}
