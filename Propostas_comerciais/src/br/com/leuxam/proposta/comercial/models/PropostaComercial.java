package br.com.leuxam.proposta.comercial.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.leuxam.proposta.comercial.service.desconto.DescontoProposta;

public class PropostaComercial {
	
	private Orcamentista orcamentista;
	private CoordenadorRegionalDeVendas crv;
	private List<Itens> itens = new ArrayList<>();
	private BigDecimal valor;
	
	public PropostaComercial(Orcamentista orcamentista, CoordenadorRegionalDeVendas crv,
			BigDecimal valor) {
		this.orcamentista = orcamentista;
		this.crv = crv;
		this.valor = valor;
	}

	public Orcamentista getOrcamentista() {
		return orcamentista;
	}

	public CoordenadorRegionalDeVendas getCrv() {
		return crv;
	}

	public List<Itens> getItens() {
		return itens;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public void aplicarDesconto() {
		DescontoProposta descontoProposta = new DescontoProposta();
		this.valor = descontoProposta.desconto(this);
	}
}
