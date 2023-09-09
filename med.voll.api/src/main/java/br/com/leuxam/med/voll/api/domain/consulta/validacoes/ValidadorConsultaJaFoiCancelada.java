package br.com.leuxam.med.voll.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.leuxam.med.voll.api.domain.ValidacaoException;
import br.com.leuxam.med.voll.api.domain.consulta.ConsultaRepository;
import br.com.leuxam.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

@Component
public class ValidadorConsultaJaFoiCancelada implements ValidadorCancelamentoDeConsulta{
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public void validar(DadosCancelamentoConsulta dados) {
		
		var consulta = consultaRepository.getReferenceById(dados.idConsulta());
		
		if(consulta.getMotivoCancelamento() != null) {
			throw new ValidacaoException("A consulta já foi cancelada!");
		}
	}
	
}
