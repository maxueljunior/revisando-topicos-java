package br.com.leuxam.proposta.comercial.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.leuxam.proposta.comercial.service.desconto.DescontoProposta;
import br.com.leuxam.proposta.comercial.service.status.NaoInicializada;
import br.com.leuxam.proposta.comercial.service.status.StatusPropostas;

public class PropostaComercial {
	
	private Orcamentista orcamentista;
	private CoordenadorRegionalDeVendas crv;
	private List<Itens> itens = new ArrayList<>();
	private BigDecimal valor;
	private StatusPropostas status;
	
	public PropostaComercial(Orcamentista orcamentista, CoordenadorRegionalDeVendas crv, BigDecimal valor) {
		this.orcamentista = orcamentista;
		this.crv = crv;
		this.valor = valor;
		this.status = new NaoInicializada();
	}

	public StatusPropostas getStatus() {
		return status;
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

	public void setStatus(StatusPropostas status) {
		this.status = status;
	}
	
	public void cancelar() {
		this.status.cancelar(this);
	}
	
	public void elaborar() {
		this.status.elaboracao(this);
	}
	
	public void liberar() {
		this.status.liberada(this);
	}
	
	public void consolidar() {
		this.status.consolidada(this);
	}
}
