package br.com.leuxam.med.voll.api.medico;

import br.com.leuxam.med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
	
}
