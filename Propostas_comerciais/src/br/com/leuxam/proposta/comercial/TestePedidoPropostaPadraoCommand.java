package br.com.leuxam.proposta.comercial;

import java.math.BigDecimal;

import br.com.leuxam.proposta.comercial.models.GeraPedido;
import br.com.leuxam.proposta.comercial.models.handlers.GeraPedidoHandler;

public class TestePedidoPropostaPadraoCommand {
	public static void main(String[] args) {
		String cliente = "RAIZEN - Biosev";
		BigDecimal valorOrcamento = new BigDecimal("2500");
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento);
		GeraPedidoHandler handler = new GeraPedidoHandler();
		handler.executa(gerador);
	}
}
