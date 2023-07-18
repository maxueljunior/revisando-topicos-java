package escola;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void naoDeveriaCriarNumeroComDadosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "992226333"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("16", null));
	}

	@Test
	void deveriaCriarNumero() {
		Telefone telefone = new Telefone("16", "992226333");
		assertNotNull(telefone.getDdd());
		assertNotNull(telefone.getNumero());
	}

}
