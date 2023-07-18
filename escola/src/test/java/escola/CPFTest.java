package escola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CPFTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void naoDeveriaCriarUmCPFInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
		assertThrows(IllegalArgumentException.class, () -> new CPF("123412"));
	}
	
	@Test
	void deveriaCriarUmCPF() {
		CPF cpf = new CPF("402.502.402-02");
		assertEquals("402.502.402-02", cpf.getCpf());
	}

}
