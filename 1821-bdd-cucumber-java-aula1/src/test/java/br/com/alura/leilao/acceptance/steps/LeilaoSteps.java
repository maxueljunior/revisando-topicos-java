package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;

import br.com.alura.leilao.e2e.pages.AlterarLeilaoPage;
import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {
	
	private LoginPage loginPage;
	private Browser browser;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novoLeilaoPage;
	private AlterarLeilaoPage alterarLeilaoPage;

	@Dado("um usuario logado")
	public void um_usuario_logado() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
		leiloesPage = loginPage.realizaLoginComoFulano();
	}

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
		novoLeilaoPage = leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}
	
	@Quando("prenche o formulario com dados validos")
	public void prenche_o_formulario_com_dados_validos() {
		this.leiloesPage = this.novoLeilaoPage.preencheForm("Notebook Gamer","1500.00", "01/11/2022");
	}
	
	@Entao("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
		assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	
	@Entao("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
		this.leiloesPage.existe("Notebook Gamer", "1500.00", "01/11/2022");
		this.browser.clean();
	}
	
//	*******************************************************
	
	@Quando("acessa a pagina de um leilao existente")
	public void acessa_a_pagina_de_um_leilao_existente() {
		this.alterarLeilaoPage = leiloesPage.visitaPaginaParaAltearLeilao();
	}

	@Quando("edita o formulario com dados validos")
	public void edita_o_formulario_com_dados_validos() {
		this.leiloesPage = this.alterarLeilaoPage.preencheForm("Nome editado", "99999.99", "01/01/3033");
	}
	
	@Entao("entao volta para a pagina de leiloes")
	public void entao_volta_para_a_pagina_de_leiloes() {
		assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	
	@Entao("o leilao editado aparece na tabela")
	public void o_leilao_editado_aparece_na_tabela() {
		assertTrue(this.leiloesPage.existe("Nome editado", "99999.99", "01/01/3033"));
		this.browser.clean();
	}
}
