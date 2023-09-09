package br.com.leuxam.med.voll.api.domain.consulta.validacoes;

import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.leuxam.med.voll.api.domain.ValidacaoException;
import br.com.leuxam.med.voll.api.domain.consulta.Consulta;
import br.com.leuxam.med.voll.api.domain.consulta.ConsultaRepository;
import br.com.leuxam.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

@Component
public class ValidadorAntedecendiaMinimaCancelamento implements ValidadorCancelamentoDeConsulta{
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public void validar(DadosCancelamentoConsulta dados) {
		var consulta = consultaRepository.getReferenceById(dados.idConsulta());
		
		
		if(!isAtendeAntecedenciaDeUmDia(consulta, dados)) {
			throw new ValidacaoException("A consulta não pode ser cancelada, pois passou de 24 horas de antecedência!");
		}
	}
	
	private boolean isAtendeAntecedenciaDeUmDia(Consulta consulta, DadosCancelamentoConsulta dados) {
		var horas = (consulta.getData().toEpochSecond(ZoneOffset.UTC) - dados.data().toEpochSecond(ZoneOffset.UTC)) / 3600;
		if(horas >= 24) return true;
		return false;
	}
}
