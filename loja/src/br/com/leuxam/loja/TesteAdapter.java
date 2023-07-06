package br.com.leuxam.loja;

import java.math.BigDecimal;

import br.com.leuxam.loja.http.JavaHttpClient;
import br.com.leuxam.loja.orcamento.Orcamento;
import br.com.leuxam.loja.orcamento.RegistroDeOrcamento;

public class TesteAdapter {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		orcamento.finalizar();
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
		registro.registrar(orcamento);
	}

}
