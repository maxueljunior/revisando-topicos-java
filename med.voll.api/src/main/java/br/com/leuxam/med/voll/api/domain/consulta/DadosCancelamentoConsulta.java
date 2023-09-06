package br.com.leuxam.med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
		@NotNull
		Long idConsulta,
		@NotNull
		MotivoCancelamento motivoCancelamento,
		@NotNull
		LocalDateTime data) {

}
