package br.com.leuxam.med.voll.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import br.com.leuxam.med.voll.api.domain.endereco.DadosEndereco;
import br.com.leuxam.med.voll.api.domain.endereco.Endereco;
import br.com.leuxam.med.voll.api.domain.paciente.DadosCadastroPaciente;
import br.com.leuxam.med.voll.api.domain.paciente.DadosDetalhamentoPaciente;
import br.com.leuxam.med.voll.api.domain.paciente.Paciente;
import br.com.leuxam.med.voll.api.domain.paciente.PacienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PacienteControllerTest {
	
	@MockBean
	private PacienteRepository repository;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosCadastroPaciente> dadosCadastroJson;
	
	@Autowired
	private JacksonTester<DadosDetalhamentoPaciente> dadosDetalhamentoJson;

	@Test
	@DisplayName("Deve retornar codigo http 400 com dados invalidos!")
	@WithMockUser
	void cadastrarPaciente_cenario01() throws Exception {
		var response = mvc.perform(post("/pacientes"))
				.andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	@DisplayName("Deve retornar codigo http 200 com dados validos!")
	@WithMockUser
	void cadastrarPaciente_cenario02() throws Exception {
		
		var dadosEndereco = new DadosEndereco("123", "456", "14165000", "22", "na", "STZ", "SP");
		
		var dadosCadastro = new DadosCadastroPaciente("maxuel", "email@email.com",
				"17882326060", "12345678900", dadosEndereco);
		
		when(repository.save(any())).thenReturn(new Paciente(dadosCadastro));
		
		var response = mvc.perform(post("/pacientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dadosCadastroJson.write(dadosCadastro)
						.getJson())
				)
				.andReturn().getResponse();
		
		var jsonEsperado = dadosDetalhamentoJson.write(new DadosDetalhamentoPaciente(null,
				dadosCadastro.nome(), dadosCadastro.email(), dadosCadastro.telefone(),
				dadosCadastro.cpf(), new Endereco(dadosCadastro.endereco()))).getJson();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}

}







