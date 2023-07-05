package br.com.leuxam.loja.imposto;

import java.math.BigDecimal;

import br.com.leuxam.loja.orcamento.Orcamento;

public interface Imposto {
	BigDecimal calcular(Orcamento orcamento);
}
