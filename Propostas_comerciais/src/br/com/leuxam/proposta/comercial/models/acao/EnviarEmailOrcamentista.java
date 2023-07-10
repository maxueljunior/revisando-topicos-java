package br.com.leuxam.proposta.comercial.models.acao;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;

public class EnviarEmailOrcamentista implements AcaoDeSolicitacaoDeProposta{

	@Override
	public void executarAcao(GeraEmailDeSolicitaoDeProposta dados) {
		System.out.println("Enviar email orçamentista...");
	}

}
