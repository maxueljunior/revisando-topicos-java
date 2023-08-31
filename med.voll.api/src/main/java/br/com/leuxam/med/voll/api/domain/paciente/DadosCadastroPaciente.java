package br.com.leuxam.med.voll.api.domain.paciente;

import br.com.leuxam.med.voll.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		@NotBlank
		String cpf,
		@NotNull
		@Valid
		DadosEndereco endereco) {
	
}