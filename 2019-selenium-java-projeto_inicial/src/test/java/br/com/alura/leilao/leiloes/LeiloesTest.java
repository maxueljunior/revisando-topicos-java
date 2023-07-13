package br.com.alura.leilao.leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	
	
	@AfterEach
	public void afterEach() {
		//this.paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.submeteFormularioDeLogin();
		paginaDeLeiloes.carregarFormulario();
		CadastroLeilaoPage paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
	
	@Test
	public void deveriaEditarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.submeteFormularioDeLogin();
		EditarLeiloesPage editarLeiloesPage = paginaDeLeiloes.encontrarAlgumaCoisaComEditar();
	}
}
