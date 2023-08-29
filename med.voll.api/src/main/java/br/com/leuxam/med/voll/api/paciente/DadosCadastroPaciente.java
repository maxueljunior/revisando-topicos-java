package br.com.leuxam.med.voll.api.paciente;

import br.com.leuxam.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
