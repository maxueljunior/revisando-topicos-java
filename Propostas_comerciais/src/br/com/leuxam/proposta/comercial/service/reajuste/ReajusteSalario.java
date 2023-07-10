package br.com.leuxam.proposta.comercial.service.reajuste;

import java.math.BigDecimal;
import java.util.Set;

import br.com.leuxam.proposta.comercial.models.Informacoes;

public class ReajusteSalario {
	
	Set<ValidacaoReajuste> listaDeValidacoes;
	
	public ReajusteSalario(Set<ValidacaoReajuste> listaDeValidacoes) {
		this.listaDeValidacoes = listaDeValidacoes;
	}

	public void reajustarSalario(Informacoes funcionario, BigDecimal valorDoReajuste) {
		
		this.listaDeValidacoes.forEach(valida -> {
			valida.validar(funcionario, valorDoReajuste);
			});
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal salarioNovo = salarioAtual.add(valorDoReajuste);
		
		funcionario.atualizarSalario(salarioNovo);
	}
}
