package br.com.leuxam.med.voll.api.paciente;

import br.com.leuxam.med.voll.api.endereco.Endereco;

public record DadosDetalhamentoPaciente(
		Long id,
		String nome,
		String email,
		String telefone,
		String cpf,
		Endereco endereco) {
	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
	}
}
