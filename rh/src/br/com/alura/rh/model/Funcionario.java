package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.rh.service.reajuste.ReajusteService;
import br.com.alura.rh.service.reajuste.ValidacaoPercentualReajuste;
import br.com.alura.rh.service.reajuste.ValidacaoPeriodicidadeEntreAjustas;
import br.com.alura.rh.service.reajuste.ValidacaoReajuste;

public class Funcionario {

	private DadosPessoais dadosPessoais;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void reajustarSalario(BigDecimal aumento) {
		List<ValidacaoReajuste> listaDeValidacoes = new ArrayList<>();
		listaDeValidacoes.add(new ValidacaoPercentualReajuste());
		listaDeValidacoes.add(new ValidacaoPeriodicidadeEntreAjustas());
		
		ReajusteService reajuste = new ReajusteService(listaDeValidacoes);
		reajuste.reajustarSalarioDoFuncionario(this, aumento);
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void atualizarSalario(BigDecimal salarioReajustado) {
		this.dadosPessoais.setSalario(salarioReajustado);
		this.dataUltimoReajuste = LocalDate.now();
	}

	public void promover(Cargo novoCargo) {
		this.dadosPessoais.setCargo(novoCargo);
	}

}
