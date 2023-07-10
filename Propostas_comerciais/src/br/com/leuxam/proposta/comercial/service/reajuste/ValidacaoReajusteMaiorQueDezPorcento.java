package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.leuxam.proposta.comercial.exceptions.ValorReajustadoException;
import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ValidacaoReajusteMaiorQueDezPorcento implements ValidacaoReajuste{
	
	public void validar(Informacoes funcionario, BigDecimal valorDoReajuste) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal valorReajustado = valorDoReajuste.divide(salarioAtual, 2, RoundingMode.HALF_UP);
		
		if(valorReajustado.compareTo(new BigDecimal("0.10")) > 0) {
			throw new ValorReajustadoException("Valor do reajuste não pode ser maior que 10%!");
		}
	}
}
