package br.com.alura.leilao.leiloes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.submeteFormularioDeLogin();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		paginaDeLeiloes.carregarFormulario();
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		paginaDeLeiloes.carregarFormulario();
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
		this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		assertFalse(this.paginaDeCadastro.isPaginaAtual());
		assertTrue(this.paginaDeCadastro.isMensagensDeValidacaoVisiveis());
	}
	
	@Test
	public void deveriaEditarLeilao() {
		EditarLeiloesPage editarLeiloesPage = paginaDeLeiloes.encontrarAlgumaCoisaComEditar();
		
		assertTrue(editarLeiloesPage.isPaginaAtual());
		
		String hoje = "03/11/2022";
		String nome = "Leilao do dia " + hoje;
		String valor = "15000.00";
		
		this.paginaDeLeiloes = editarLeiloesPage.limparCamposLeilao().editarLeilao(nome, valor, hoje);
		assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
}
