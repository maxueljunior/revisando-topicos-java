package br.com.leuxam.loja.pedido.acao;

import br.com.leuxam.loja.pedido.Pedido;

public class SalvarPedidoNoBD implements AcaoAposGerarPedido{
	
	public void executar(Pedido pedido) {
		System.out.println("Salvando o pedido no banco de dados...");
	}
	
}
