package br.com.leuxam.proposta.comercial.service.status;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class NaoInicializada extends StatusPropostas {
	
	@Override
	public void elaboracao(PropostaComercial propostaComercial) {
		propostaComercial.setStatus(new EmElaboracao());
	}
	
	@Override
	public void cancelar(PropostaComercial propostaComercial) {
		propostaComercial.setStatus(new Cancelada());
	}

	@Override
	public String toString() {
		return "Não Inicializada";
	}
}
