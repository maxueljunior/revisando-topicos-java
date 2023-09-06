package br.com.leuxam.med.voll.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.leuxam.med.voll.api.domain.ValidacaoException;
import br.com.leuxam.med.voll.api.domain.consulta.ConsultaRepository;
import br.com.leuxam.med.voll.api.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {
	
	@Autowired
	private ConsultaRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var medicoPossuirOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
		if(medicoPossuirOutraConsultaNoMesmoHorario) {
			throw new ValidacaoException("Medico já possui outra consulta agendada nesse mesmo horario");
		}
	}
}
