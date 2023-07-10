package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.leuxam.proposta.comercial.exceptions.ValorReajustadoException;
import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ValidacaoReajustePorcentagemSalarioMaiorQueOitenta implements ValidacaoReajuste{
	
	public void validar(Informacoes funcionario, BigDecimal valorDoReajuste) {
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal valorReajustado = valorDoReajuste.divide(salarioAtual, 2, RoundingMode.HALF_UP);
		
		BigDecimal porcentagemSalario = funcionario.getPorcentagemDoSalarioAteOTeto();
		
		if(porcentagemSalario.compareTo(new BigDecimal("80.0")) > 0 && valorReajustado.compareTo(new BigDecimal("0.05")) > 0) {
			throw new ValorReajustadoException("Funcionario so pode receber de ajuste 5%, pois a sua porcentagem está com " + porcentagemSalario + "%. O mesmo so pode receber 5%");
		}
	}
}
