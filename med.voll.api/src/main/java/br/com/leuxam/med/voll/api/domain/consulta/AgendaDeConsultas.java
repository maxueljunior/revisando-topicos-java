package br.com.leuxam.med.voll.api.domain.consulta;

import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leuxam.med.voll.api.domain.ValidacaoException;
import br.com.leuxam.med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import br.com.leuxam.med.voll.api.domain.consulta.validacoes.ValidadorCancelamentoDeConsulta;
import br.com.leuxam.med.voll.api.domain.medico.Medico;
import br.com.leuxam.med.voll.api.domain.medico.MedicoRepository;
import br.com.leuxam.med.voll.api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private List<ValidadorAgendamentoDeConsulta> validadores;
	
	@Autowired
	private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento;

	public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
		
		if(!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidacaoException("O id do paciente " + dados.idPaciente() + " não existe");
		}
		
		if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidacaoException("O id do medico " + dados.idMedico() + " não existe");
		}
		
		validadores.forEach(x -> x.validar(dados));
		
		var medico = escolherMedico(dados);
		if(medico == null) {
			throw new ValidacaoException("Não existe medico disponivel nessa data");
		}
		var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
		var consulta = new Consulta(null, medico, paciente, dados.data(), null);
		
		consultaRepository.save(consulta);
		return new DadosDetalhamentoConsulta(consulta);
	}

	private Medico escolherMedico(DadosAgendamentoConsulta dados) {
		if(dados.idMedico() != null) {
			return medicoRepository.getReferenceById(dados.idMedico());
		}
		
		if(dados.especialidade() == null) {
			throw new ValidacaoException("Especialidade é obrigatoria quando médico não for escolhido");
		}
		
		return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
	}

	public void cancelar(DadosCancelamentoConsulta dados) {
		
		var consulta = consultaRepository.findById(dados.idConsulta()).get();
		
		validadoresCancelamento.forEach(v -> v.validar(dados));
		
		consulta.cancelar(dados.motivoCancelamento());
	}

}








