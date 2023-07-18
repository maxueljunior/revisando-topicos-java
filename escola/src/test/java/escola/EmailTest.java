package escola;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void naoDeveCriarOEmailComEnderecoInvalido() {
		assertThrows(IllegalArgumentException.class,
				() -> new Email(null));
		assertThrows(IllegalArgumentException.class,
				() -> new Email(""));
		assertThrows(IllegalArgumentException.class,
				() -> new Email("invalido"));
	}
	
	@Test
	void deveCriarOEmailComEndereco() {
		Email email = new Email("henrique.vieira@hotmail.com");
		assertNotNull(email.getEndereco());
	}

}
