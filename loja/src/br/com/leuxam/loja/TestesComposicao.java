package br.com.leuxam.loja;

import java.math.BigDecimal;

import br.com.leuxam.loja.orcamento.ItemOrcamento;
import br.com.leuxam.loja.orcamento.Orcamento;
import br.com.leuxam.loja.orcamento.OrcamentoProxy;

public class TestesComposicao {
	public static void main(String[] args) {
		
		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("50")));
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("50")));
		antigo.reprovar();
	
		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		novo.adicionarItem(antigo);
		
		OrcamentoProxy proxy = new OrcamentoProxy(novo);
		
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		
	
	}
}
