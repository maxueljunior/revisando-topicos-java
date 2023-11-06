package br.com.leuxam.med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.leuxam.med.voll.api.domain.paciente.DadosAtualizadosPaciente;
import br.com.leuxam.med.voll.api.domain.paciente.DadosCadastroPaciente;
import br.com.leuxam.med.voll.api.domain.paciente.DadosDetalhamentoPaciente;
import br.com.leuxam.med.voll.api.domain.paciente.DadosListagemPaciente;
import br.com.leuxam.med.voll.api.domain.paciente.Paciente;
import br.com.leuxam.med.voll.api.domain.paciente.PacienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
		var paciente = new Paciente(dados);
		repository.save(paciente);
		
		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10) Pageable pageable){
		var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity listarPorId(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizadosPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletar(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		paciente.desativar();
		return ResponseEntity.noContent().build();
	}
}





