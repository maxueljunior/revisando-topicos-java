package br.com.alura.leilao.login;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach() {
		paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencheFormularioDeLogin("fulano","pass");
		paginaDeLogin.submeteFormularioDeLogin();
		
		assertFalse(paginaDeLogin.isPaginaDeLogin());
		assertEquals("fulano", paginaDeLogin.getNomeDeUsuarioLogado());
	}
	
	@Test
	public void deveriaDarErroAoLoginComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("invalido","123");
		paginaDeLogin.submeteFormularioDeLogin();
		
		assertTrue(paginaDeLogin.isPaginaDeLoginComErro());
		assertNull(paginaDeLogin.getNomeDeUsuarioLogado());
		assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();
		
		assertTrue(paginaDeLogin.isPaginaDeLogin());
		assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
	
}
