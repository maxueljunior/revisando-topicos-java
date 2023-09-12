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
import br.com.leuxam.med.voll.api.domain.medico.DadosCadastroMedico;
import br.com.leuxam.med.voll.api.domain.medico.DadosDetalhamentoMedico;
import br.com.leuxam.med.voll.api.domain.medico.Especialidade;
import br.com.leuxam.med.voll.api.domain.medico.Medico;
import br.com.leuxam.med.voll.api.domain.medico.MedicoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MedicoRepository repository;
	
	@Autowired
	private JacksonTester<DadosCadastroMedico> dadosCadastroJson;
	
	@Autowired
	private JacksonTester<DadosDetalhamentoMedico> dadosDetalhamentoJson;
	
	@Test
	@DisplayName("Deveria devolver codigo http 400 quando informações estão invalidas")
	@WithMockUser
	void cadastrarMedicos_cenario01() throws Exception {
		var response = mvc.perform(post("/medicos"))
				.andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	@DisplayName("Deveria devolver codigo http 200 quando informações estão validas")
	@WithMockUser
	void cadastrarMedicos_cenario02() throws Exception {
		
		var especialidade = Especialidade.CARDIOLOGIA;
		var dadosEndereco = new DadosEndereco("123", "456", "14165000", "22", "na", "STZ", "SP");
		var dadosCadastro = new DadosCadastroMedico("maxuel",
				"email@hotmail.com", "123456", "161234", especialidade, dadosEndereco);
		
		when(repository.save(any())).thenReturn(new Medico(dadosCadastro));
		
		var response = mvc.perform(post("/medicos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dadosCadastroJson.write(
						dadosCadastro).getJson())
				)
				.andReturn().getResponse();
		
		var dadosDetalhamento = new DadosDetalhamentoMedico(null, dadosCadastro.nome(),
				dadosCadastro.email(), dadosCadastro.crm(), dadosCadastro.telefone(),
				dadosCadastro.especialidade(), new Endereco(dadosCadastro.endereco()));
		
		var jsonEsperado = dadosDetalhamentoJson.write(dadosDetalhamento).getJson();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}

}














