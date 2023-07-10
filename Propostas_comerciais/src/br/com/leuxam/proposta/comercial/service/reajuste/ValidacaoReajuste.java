package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.Informacoes;

public interface ValidacaoReajuste {
	void validar(Informacoes funcionario, BigDecimal valorDoReajuste);
}
