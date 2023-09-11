package br.com.leuxam.med.voll.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import br.com.leuxam.med.voll.api.domain.consulta.AgendaDeConsultas;
import br.com.leuxam.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.leuxam.med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import br.com.leuxam.med.voll.api.domain.medico.Especialidade;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosAgendamentoConsulta> dadosJson;
	
	@Autowired
	private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoJson;
	
	@MockBean
	private AgendaDeConsultas agendaDeConsultas;
	
	@Test
	@DisplayName("Deveria devolver codigo http 400 quando informações estão invalidas")
	@WithMockUser
	void agendar_cenario1() throws Exception {
		var response = mvc.perform(post("/consultas"))
			.andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	@DisplayName("Deveria devolver codigo http 200 quando informações estão validas")
	@WithMockUser
	void agendar_cenario2() throws Exception {
		
		var data = LocalDateTime.now().plusHours(1);
		var especialidade = Especialidade.CARDIOLOGIA;
		
		var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 2l, 5l, data);
		when(agendaDeConsultas.agendar(any())).thenReturn(dadosDetalhamento);
		
		var response = mvc.perform(
				post("/consultas")
					.contentType(MediaType.APPLICATION_JSON)
					.content(dadosJson.write(
							new DadosAgendamentoConsulta(2L, 5L, data, especialidade)
							).getJson())
				)
			.andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
		var jsonEsperado = dadosDetalhamentoJson.write(
				dadosDetalhamento
				).getJson();
		
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}
}





















