package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.leuxam.proposta.comercial.exceptions.ValorReajustadoException;
import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ValidacaoReajusteMesDeReajusteMenorQueSeis implements ValidacaoReajuste{
	
	public void validar(Informacoes funcionario, BigDecimal valorDoReajuste) {
		
		LocalDate ultimaDataDeReajuste = funcionario.getUltimaDataDeReajuste();
		LocalDate dataAtual = LocalDate.now();
		ChronoUnit chrono = ChronoUnit.MONTHS;
		if(chrono.between(ultimaDataDeReajuste, dataAtual) < 6) {
			throw new ValorReajustadoException("Para receber o reajuste salarial, não pode ser menor que o intervalo de seis meses!");
		}
	}
}
