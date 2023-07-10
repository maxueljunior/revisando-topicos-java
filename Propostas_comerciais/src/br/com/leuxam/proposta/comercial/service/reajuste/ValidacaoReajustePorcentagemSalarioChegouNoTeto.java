package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.leuxam.proposta.comercial.exceptions.ValorReajustadoException;
import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ValidacaoReajustePorcentagemSalarioChegouNoTeto implements ValidacaoReajuste{
	
	public void validar(Informacoes funcionario, BigDecimal valorDoReajuste) {
		
		BigDecimal porcentagemSalario = funcionario.getPorcentagemDoSalarioAteOTeto();
		
		if(porcentagemSalario.compareTo(new BigDecimal("100.0")) >= 0 ) {
			throw new ValorReajustadoException("Funcionario não pode mais receber reajuste pois já chegou no limite do teto da função");
		}
	}
}
