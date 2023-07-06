package br.com.leuxam.loja;

import java.math.BigDecimal;

import br.com.leuxam.loja.imposto.CalculadoraDeImpostos;
import br.com.leuxam.loja.imposto.ICMS;
import br.com.leuxam.loja.imposto.ISS;
import br.com.leuxam.loja.orcamento.Orcamento;

public class TestesImpostos {
	public static void main(String[] args) {
		
//		Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
//		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
//		
//		System.out.println(calculadora.calcular(orcamento, new ICMS()));
		
		Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
		
	}
}
