package br.com.leuxam.med.voll.api.domain.consulta.validacoes;

import br.com.leuxam.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
	
	void validar(DadosCancelamentoConsulta dados);
}
