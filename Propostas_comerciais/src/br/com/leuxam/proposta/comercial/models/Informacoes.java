package br.com.leuxam.proposta.comercial.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.leuxam.proposta.comercial.service.reajuste.ReajusteSalario;
import br.com.leuxam.proposta.comercial.service.reajuste.ValidacaoReajuste;
import br.com.leuxam.proposta.comercial.service.reajuste.ValidacaoReajusteAnoDeAdmissaoMenorQueUm;
import br.com.leuxam.proposta.comercial.service.reajuste.ValidacaoReajusteMaiorQueDezPorcento;
import br.com.leuxam.proposta.comercial.service.reajuste.ValidacaoReajusteMesDeReajusteMenorQueSeis;
import br.com.leuxam.proposta.comercial.service.reajuste.ValidacaoReajustePorcentagemSalarioChegouNoTeto;
import br.com.leuxam.proposta.comercial.service.reajuste.ValidacaoReajustePorcentagemSalarioMaiorQueOitenta;

public class Informacoes {
	
	private String nome;
	private String cpf;
	private BigDecimal salario;
	private BigDecimal salarioTeto;
	private LocalDate dataDeAdmissao;
	private LocalDate ultimaDataDeReajuste;
	private BigDecimal porcentagemDoSalarioAteOTeto;
	
	
	public Informacoes(String nome, String cpf, BigDecimal salario, LocalDate dataDeAdmissao, LocalDate ultimaDataDeReajuste, BigDecimal salarioTeto) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataDeAdmissao = dataDeAdmissao;
		this.ultimaDataDeReajuste = ultimaDataDeReajuste;
		this.salarioTeto = salarioTeto;
		this.porcentagemDoSalarioAteOTeto = salario.divide(salarioTeto, 2, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
	}

	public Informacoes() {}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	public LocalDate getDataDeAdmissao() {
		return dataDeAdmissao;
	}
	
	public LocalDate getUltimaDataDeReajuste() {
		return ultimaDataDeReajuste;
	}
	
	public BigDecimal getSalarioTeto() {
		return salarioTeto;
	}
	
	public BigDecimal getPorcentagemDoSalarioAteOTeto() {
		return porcentagemDoSalarioAteOTeto;
	}
	
	public void reajustarSalario(BigDecimal aumento) {
		Set<ValidacaoReajuste> validacoes = new HashSet<>();
		validacoes.add(new ValidacaoReajusteAnoDeAdmissaoMenorQueUm());
		validacoes.add(new ValidacaoReajusteMaiorQueDezPorcento());
		validacoes.add(new ValidacaoReajusteMesDeReajusteMenorQueSeis());
		validacoes.add(new ValidacaoReajustePorcentagemSalarioChegouNoTeto());
		validacoes.add(new ValidacaoReajustePorcentagemSalarioMaiorQueOitenta());
		
		ReajusteSalario reajusteSalarial = new ReajusteSalario(validacoes);
		reajusteSalarial.reajustarSalario(this, aumento);
	}
	
	public void atualizarSalario(BigDecimal valorReajustado) {
		this.salario = valorReajustado;
		this.ultimaDataDeReajuste = LocalDate.now();
	}
}
