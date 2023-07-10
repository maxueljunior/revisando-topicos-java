package br.com.leuxam.proposta.comercial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.leuxam.proposta.comercial.models.Informacoes;
import br.com.leuxam.proposta.comercial.models.Itens;
import br.com.leuxam.proposta.comercial.models.Orcamentista;
import br.com.leuxam.proposta.comercial.models.PropostaComercial;
import br.com.leuxam.proposta.comercial.models.enums.Funcoes;
import br.com.leuxam.proposta.comercial.service.desconto.DescontoProposta;

public class TesteDescontoPropostaPadraoChainOfResponsibillity {

	public static void main(String[] args) {
		
		Set<Funcoes> funcoesOrcamentista = new HashSet<>();
		
		Orcamentista o1 = new Orcamentista(
				new Informacoes("Maxuel", "468.569.498-80", new BigDecimal("2500.00"), LocalDate.now(), LocalDate.now(), new BigDecimal("3500.00")),
				funcoesOrcamentista );
		
		List<Itens> itens = new ArrayList<>();
		itens.add(new Itens(new BigDecimal("100.00"), null));
		itens.add(new Itens(new BigDecimal("200.00"), null));
		itens.add(new Itens(new BigDecimal("100.00"), null));
		itens.add(new Itens(new BigDecimal("100.00"), null));
		itens.add(new Itens(new BigDecimal("100.00"), null));
		itens.add(new Itens(new BigDecimal("100.00"), null));
		itens.add(new Itens(new BigDecimal("200.00"), null));
		
		PropostaComercial p1 = new PropostaComercial(o1, null, new BigDecimal("100.00"));
		p1.getItens().addAll(itens);
		DescontoProposta desconto = new DescontoProposta();
		System.out.println(p1.getValor());
		p1.aplicarDesconto();
		System.out.println(p1.getValor());
		//System.out.println(desconto.desconto(p1));
	}

}
