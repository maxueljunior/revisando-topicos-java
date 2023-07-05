package br.com.leuxam.loja;

import java.math.BigDecimal;

import br.com.leuxam.loja.desconto.CalculadoraDeDesconto;
import br.com.leuxam.loja.orcamento.Orcamento;

public class TestesDescontos {
	public static void main(String[] args) {
		
		Orcamento o1 = new Orcamento(new BigDecimal("200"), 6);
		Orcamento o2 = new Orcamento(new BigDecimal("1000"), 1);
		CalculadoraDeDesconto calculadora = new CalculadoraDeDesconto();
		
		System.out.println(calculadora.calcular(o1));
		System.out.println(calculadora.calcular(o2));
		
	}
}
