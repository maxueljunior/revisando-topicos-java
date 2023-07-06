package br.com.leuxam.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.leuxam.loja.orcamento.Orcamento;
import br.com.leuxam.loja.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {
	
	private List<AcaoAposGerarPedido> acoes;
	
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	// construtor com injeção de depêndencias: repository, service, e etc...
	
	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento();
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		acoes.forEach(acao -> {
			acao.executar(pedido);
		});
	}
}
