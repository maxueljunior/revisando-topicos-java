package br.com.leuxam.loja.pedido.acao;

import br.com.leuxam.loja.pedido.Pedido;

public class LogDePedidos implements AcaoAposGerarPedido{

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Pedido foi gerado... " + pedido);
	}
	
}
