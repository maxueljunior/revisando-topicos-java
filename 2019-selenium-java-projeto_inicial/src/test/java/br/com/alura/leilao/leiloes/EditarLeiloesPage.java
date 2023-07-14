package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;

public class EditarLeiloesPage extends PageObject{
	
	public static final String URL_LEILAO_INICIO = "http://localhost:8080/leiloes/";
	public static final String URL_LEILAO_FINAL = "/form";
	
	public EditarLeiloesPage(WebDriver browser) {
		super(browser);
	}

	public boolean isPaginaAtual() {
		return this.browser.getCurrentUrl().contains(URL_LEILAO_INICIO) && this.browser.getCurrentUrl().contains(URL_LEILAO_FINAL);
	}

	public LeiloesPage editarLeilao(String nome, String valor, String hoje) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valor);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(hoje);
		this.browser.findElement(By.id("button-submit")).click();
		return new LeiloesPage(browser);
	}

	public EditarLeiloesPage limparCamposLeilao() {
		this.browser.findElement(By.id("nome")).clear();
		this.browser.findElement(By.id("valorInicial")).clear();
		this.browser.findElement(By.id("dataAbertura")).clear();
		return this;
	}
	
	

}
