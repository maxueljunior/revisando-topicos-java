package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		//assertThrows(IllegalArgumentException.class,
				//() -> service.calcularBonus(new Funcionario(null, null, new BigDecimal("100000"))));
	
		try {
			service.calcularBonus(new Funcionario(null, null, new BigDecimal("100000")));
			fail("Não deu a exception");
		}catch(Exception e) {
			assertEquals("Funcionario com salario maior do que R$10.000, não pode receber bonus!", e.getMessage());
		}
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
