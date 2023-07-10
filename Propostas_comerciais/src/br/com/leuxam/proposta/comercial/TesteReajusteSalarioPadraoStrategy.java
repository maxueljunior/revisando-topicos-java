package br.com.leuxam.proposta.comercial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.leuxam.proposta.comercial.models.Informacoes;
import br.com.leuxam.proposta.comercial.models.Orcamentista;
import br.com.leuxam.proposta.comercial.models.enums.Funcoes;

public class TesteReajusteSalarioPadraoStrategy {

	public static void main(String[] args) {
	
		LocalDate dataDeUltimoReajuste = LocalDate.of(2023, 1, 5);
		LocalDate dataDeAdmissao = LocalDate.of(2022, 7, 5);
		
		Set<Funcoes> funcoesOrcamentista = new HashSet<>();
		
		Orcamentista o1 = new Orcamentista(
				new Informacoes("Maxuel", "468.569.498-80", new BigDecimal("2500.00"), dataDeAdmissao, dataDeUltimoReajuste, new BigDecimal("3500.00")),
				funcoesOrcamentista );
		
		System.out.println(" * * * ANTES DO REAJUSTE * * *");
		System.out.println("Salario: " + o1.getInformacoes().getSalario());
		System.out.println("Ultima data de reajuste: " + o1.getInformacoes().getUltimaDataDeReajuste());
		
		o1.getInformacoes().reajustarSalario(new BigDecimal("300.00"));
		
		System.out.println(" * * * DEPOIS DO REAJUSTE * * *");
		System.out.println("Salario: " + o1.getInformacoes().getSalario());
		System.out.println("Ultima data de reajuste: " + o1.getInformacoes().getUltimaDataDeReajuste());
	}

}
