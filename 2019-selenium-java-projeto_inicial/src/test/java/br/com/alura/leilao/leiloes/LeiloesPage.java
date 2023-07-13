package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeiloesPage {
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private WebDriver browser; 
	
	public LeiloesPage(WebDriver browser) {
		this.browser = browser;
	}

	public void fechar() {
		this.browser.quit();
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
	}
	
	public EditarLeiloesPage encontrarAlgumaCoisaComEditar() {
		this.browser.findElement(By.id("botao-editar")).click();
		return new EditarLeiloesPage(browser);
	}
}
