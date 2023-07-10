package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.leuxam.proposta.comercial.exceptions.ValorReajustadoException;
import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ReajusteSalarioSemPadraoStrategy {
	
	public void reajustarSalario(Informacoes funcionario, BigDecimal valorDoReajuste) {
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal valorReajustado = valorDoReajuste.divide(salarioAtual, 2, RoundingMode.HALF_UP);
		
		if(valorReajustado.compareTo(new BigDecimal("0.10")) > 0) {
			throw new ValorReajustadoException("Valor do reajuste não pode ser maior que 10%!");
		}
		
		LocalDate dataAtual = LocalDate.now();
		ChronoUnit chrono = ChronoUnit.YEARS;

		LocalDate dataDeAdmissao = funcionario.getDataDeAdmissao();
		if(chrono.between(dataDeAdmissao, dataAtual) < 1) {
			throw new ValorReajustadoException("Funcionario não concluiu um ano de empresa!");
		}
		
		LocalDate ultimaDataDeReajuste = funcionario.getUltimaDataDeReajuste();
		chrono = ChronoUnit.MONTHS;
		if(chrono.between(ultimaDataDeReajuste, dataAtual) < 6) {
			throw new ValorReajustadoException("Para receber o reajuste salarial, não pode ser menor que o intervalo de seis meses!");
		}
		
		BigDecimal porcentagemSalario = funcionario.getPorcentagemDoSalarioAteOTeto();
		
		if(porcentagemSalario.compareTo(new BigDecimal("80.0")) > 0 && valorReajustado.compareTo(new BigDecimal("0.05")) > 0) {
			throw new ValorReajustadoException("Funcionario so pode receber de ajuste 5%, pois a sua porcentagem está com " + porcentagemSalario + "%. O mesmo so pode receber 5%");
		}
		
		if(porcentagemSalario.compareTo(new BigDecimal("100.0")) >= 0 ) {
			throw new ValorReajustadoException("Funcionario não pode mais receber reajuste pois já chegou no limite do teto da função");
		}
		
		BigDecimal salarioNovo = salarioAtual.add(valorDoReajuste);
		
		funcionario.atualizarSalario(salarioNovo);
	}
	
}
