package br.com.leuxam.med.voll.api.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import br.com.leuxam.med.voll.api.domain.ValidacaoException;
import br.com.leuxam.med.voll.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {
	
	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta = dados.data();
		var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		
		var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
		var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
		if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
			throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica!");
		}
	}
}
