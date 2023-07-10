package br.com.leuxam.proposta.comercial.service.status;

import br.com.leuxam.proposta.comercial.exceptions.StatusPropostaException;
import br.com.leuxam.proposta.comercial.models.PropostaComercial;

public abstract class StatusPropostas {
	
	public void cancelar(PropostaComercial propostaComercial) {
		throw new StatusPropostaException("Não é possivel cancelar a proposta");
	}
	
	public void elaboracao(PropostaComercial propostaComercial) {
		throw new StatusPropostaException("Não é possivel colocar a proposta em elaboração");
	}

	public void liberada(PropostaComercial propostaComercial) {
		throw new StatusPropostaException("Não é possivel liberar a proposta para a execução");
	}

	public void naoInicializada(PropostaComercial propostaComercial) {
		throw new StatusPropostaException("Não é possivel inicializar a proposta");
	}

	public void consolidada(PropostaComercial propostaComercial) {
		throw new StatusPropostaException("Não é possivel consolidar a proposta");
	}
	
}
