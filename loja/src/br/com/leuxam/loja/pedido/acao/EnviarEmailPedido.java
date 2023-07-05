package br.com.leuxam.loja.pedido.acao;

import br.com.leuxam.loja.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido{
	
	public void executar(Pedido pedido) {
		System.out.println("Enviando email com dados do pedido...");
	}
	
}
