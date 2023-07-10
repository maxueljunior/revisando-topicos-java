package br.com.leuxam.proposta.comercial.models.acao;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;

public class NotificarCliente implements AcaoDeSolicitacaoDeProposta{

	@Override
	public void executarAcao(GeraEmailDeSolicitaoDeProposta dados) {
		System.out.println("Notificar cliente....");
	}

}
