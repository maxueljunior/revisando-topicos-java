package br.com.leuxam.med.voll.api.paciente;

import br.com.leuxam.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosPaciente(
		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco
		) {
	
}
