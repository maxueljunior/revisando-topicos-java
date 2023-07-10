package br.com.leuxam.proposta.comercial.models.handlers;

import java.util.List;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;
import br.com.leuxam.proposta.comercial.models.acao.AcaoDeSolicitacaoDeProposta;

public class GeraEmailDeSolicitacaoDePropostaHandler {
	
	private List<AcaoDeSolicitacaoDeProposta> acoes;
	
	public GeraEmailDeSolicitacaoDePropostaHandler(List<AcaoDeSolicitacaoDeProposta> acoes) {
		this.acoes = acoes;
	}

	public void executa(GeraEmailDeSolicitaoDeProposta dados) {
		GeraEmailDeSolicitaoDeProposta email = new GeraEmailDeSolicitaoDeProposta(dados.getCliente(), dados.getPrazo(), dados.getMaquina());
		
		acoes.forEach(acao -> acao.executarAcao(dados));
	}
}
