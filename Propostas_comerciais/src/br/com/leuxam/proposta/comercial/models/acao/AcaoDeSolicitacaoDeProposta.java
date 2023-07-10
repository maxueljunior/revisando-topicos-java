package br.com.leuxam.proposta.comercial.models.acao;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;

public interface AcaoDeSolicitacaoDeProposta {
	public void executarAcao(GeraEmailDeSolicitaoDeProposta dados);
}
