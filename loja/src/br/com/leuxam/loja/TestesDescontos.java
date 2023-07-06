package br.com.leuxam.loja;

import java.math.BigDecimal;

import br.com.leuxam.loja.desconto.CalculadoraDeDesconto;
import br.com.leuxam.loja.orcamento.ItemOrcamento;
import br.com.leuxam.loja.orcamento.Orcamento;

public class TestesDescontos {
	public static void main(String[] args) {
		
		Orcamento primeiro = new Orcamento();
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		
		Orcamento segundo = new Orcamento();
		segundo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		
		Orcamento terceiro = new Orcamento();
		terceiro.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		
		CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
		
		System.out.println(calculadora.calcular(primeiro));
		System.out.println(calculadora.calcular(segundo));
		System.out.println(calculadora.calcular(terceiro));
		
	}
}
