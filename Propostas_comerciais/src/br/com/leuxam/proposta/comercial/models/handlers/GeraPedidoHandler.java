package br.com.leuxam.proposta.comercial.models.handlers;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.leuxam.proposta.comercial.models.GeraPedido;
import br.com.leuxam.proposta.comercial.models.Informacoes;
import br.com.leuxam.proposta.comercial.models.Orcamentista;
import br.com.leuxam.proposta.comercial.models.Pedido;
import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class GeraPedidoHandler {
	public void executa(GeraPedido dados) {
		Orcamentista o1 = new Orcamentista(
				new Informacoes("Maxuel", "468.569.498-80", new BigDecimal("2500.00"),
						LocalDate.now(), LocalDate.now(), new BigDecimal("3500.00")),
				null);
		
		PropostaComercial proposta = new PropostaComercial(o1, null, dados.getValorOrcamento());
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDate.now(), proposta);
		
		System.out.println("Salvar no BD...");
		System.out.println("Enviar e-mail...");
	}
}
