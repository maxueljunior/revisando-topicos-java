package br.com.leuxam.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private BigDecimal valor;
	private LocalDate dataDaEntrega;
	private String urlDoProduto;
	private String urlDaImagem;
	private String descricao;
	
	public Pedido() {}

	public Pedido(String nome, BigDecimal valor, LocalDate dataDaEntrega, String urlDoProduto, String urlDaImagem,
			String descricao) {
		this.nome = nome;
		this.valor = valor;
		this.dataDaEntrega = dataDaEntrega;
		this.urlDoProduto = urlDoProduto;
		this.urlDaImagem = urlDaImagem;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getUrlDoProduto() {
		return urlDoProduto;
	}

	public void setUrlDoProduto(String urlDoProduto) {
		this.urlDoProduto = urlDoProduto;
	}

	public String getUrlDaImagem() {
		return urlDaImagem;
	}

	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
