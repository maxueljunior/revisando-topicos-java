package br.com.leuxam.loja.imposto;

import java.math.BigDecimal;

import br.com.leuxam.loja.orcamento.Orcamento;

public class ICMSComIss implements Imposto{
	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal icms = new ICMS().calcular(orcamento);
		BigDecimal iss = new ISS().calcular(orcamento);
		return icms.add(iss);
	}
}
