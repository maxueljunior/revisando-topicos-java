package br.com.leuxam.proposta.comercial.service.desconto;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.exceptions.DescontoPropostaException;
import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class DescontoPropostaSemChainOfResponsibillity {
	
	public void desconto(PropostaComercial propostaComercial) {
		
		BigDecimal valorTotal = propostaComercial.getValor();
		
		if(valorTotal.compareTo(new BigDecimal("1000.00")) < 0 ) {
			throw new DescontoPropostaException("Desconto não aplicado, necessário valor maior que R$1000.00");
		}
		
		BigDecimal valorComDesconto = valorTotal.subtract(valorTotal.multiply(new BigDecimal("0.05")));
		
		if(propostaComercial.getItens().size() < 5) {
			throw new DescontoPropostaException("Desconto de itens não aplicado, necessário a quantidade ser maior que 5");
		}
		
		valorComDesconto = valorComDesconto.subtract(valorComDesconto.multiply(new BigDecimal("0.05")));
		
	}
}
