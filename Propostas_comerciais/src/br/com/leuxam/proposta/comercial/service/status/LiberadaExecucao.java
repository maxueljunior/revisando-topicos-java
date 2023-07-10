package br.com.leuxam.proposta.comercial.service.status;

import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public class LiberadaExecucao extends StatusPropostas {
	
	@Override
	public void consolidada(PropostaComercial propostaComercial) {
		propostaComercial.setStatus(new Consolidada());
	}
	
	@Override
	public void cancelar(PropostaComercial propostaComercial) {
		propostaComercial.setStatus(new Cancelada());
	}
	
	@Override
	public String toString() {
		return "Liberada Execução";
	}
}
