package br.com.leuxam.proposta.comercial.models.handlers;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;

public class GeraEmailDeSolicitacaoDePropostaHandler {
	public void executa(GeraEmailDeSolicitaoDeProposta dados) {
		GeraEmailDeSolicitaoDeProposta email = new GeraEmailDeSolicitaoDeProposta(dados.getCliente(), dados.getPrazo(), dados.getMaquina());
		
		System.out.println("Enviar email...");
		System.out.println("Notificar cliente...");
		System.out.println("Notificar orçamentista responsavel...");
	}
}
