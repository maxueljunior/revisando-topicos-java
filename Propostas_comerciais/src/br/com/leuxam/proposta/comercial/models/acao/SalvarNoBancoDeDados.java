package br.com.leuxam.proposta.comercial.models.acao;

import br.com.leuxam.proposta.comercial.models.GeraEmailDeSolicitaoDeProposta;

public class SalvarNoBancoDeDados implements AcaoDeSolicitacaoDeProposta{

	@Override
	public void executarAcao(GeraEmailDeSolicitaoDeProposta dados) {
		System.out.println("Salvar no banco de dados");
	}

}
