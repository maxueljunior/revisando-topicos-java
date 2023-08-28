package br.com.leuxam.med.voll.api.paciente;

import br.com.leuxam.med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
	
}
