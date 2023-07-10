package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.leuxam.proposta.comercial.exceptions.ValorReajustadoException;
import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ValidacaoReajusteAnoDeAdmissaoMenorQueUm implements ValidacaoReajuste{
	
	public void validar(Informacoes funcionario, BigDecimal valorDoReajuste) {
		
		LocalDate dataAtual = LocalDate.now();
		ChronoUnit chrono = ChronoUnit.YEARS;

		LocalDate dataDeAdmissao = funcionario.getDataDeAdmissao();
		if(chrono.between(dataDeAdmissao, dataAtual) < 1) {
			throw new ValorReajustadoException("Funcionario não concluiu um ano de empresa!");
		}
	}
}
