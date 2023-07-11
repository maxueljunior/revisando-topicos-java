package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario(null, null, new BigDecimal("100000")));
		
		assertEquals(BigDecimal.ZERO, bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorcentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario(null, null, new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.0"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeExatosDezMilReais() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario(null, null, new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.0"), bonus);
	}
}
