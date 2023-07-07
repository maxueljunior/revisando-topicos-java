package br.com.leuxam.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.leuxam.loja.pedido.GeraPedido;
import br.com.leuxam.loja.pedido.GeraPedidoHandler;
import br.com.leuxam.loja.pedido.acao.EnviarEmailPedido;
import br.com.leuxam.loja.pedido.acao.LogDePedidos;
import br.com.leuxam.loja.pedido.acao.SalvarPedidoNoBD;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Max";
		BigDecimal valorOrcamento = new BigDecimal("100");
		int quantidadeItens = 4;
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		
		GeraPedidoHandler handler = new GeraPedidoHandler(
				Arrays.asList(new SalvarPedidoNoBD(),
						new EnviarEmailPedido(),
						new LogDePedidos()));
		
		handler.execute(gerador);
	}

}
