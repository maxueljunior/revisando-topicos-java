package br.com.leuxam.med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void agendar(DadosAgendamentoConsulta dados) {
		
		if(!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidacaoException("O id do paciente " + dados.idPaciente() + " não existe");
		}
		
		var medico = medicoRepository.findById(dados.idMedico()).get();
		var paciente = pacienteRepository.findById(dados.idPaciente()).get();
		var consulta = new Consulta(null, medico, paciente, dados.data());
		
		consultaRepository.save(consulta);
	}

}
