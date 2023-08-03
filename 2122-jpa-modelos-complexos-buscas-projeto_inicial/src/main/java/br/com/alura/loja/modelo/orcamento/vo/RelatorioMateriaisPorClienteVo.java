package br.com.alura.loja.modelo.orcamento.vo;

import java.math.BigDecimal;

public class RelatorioMateriaisPorClienteVo {
	private String descricao;
	private BigDecimal valorTotal;
	private String nomeCliente;
	
	public RelatorioMateriaisPorClienteVo() {}
	
	public RelatorioMateriaisPorClienteVo(String descricao, BigDecimal valorTotal, String nomeCliente) {
		this.descricao = descricao;
		this.valorTotal = valorTotal;
		this.nomeCliente = nomeCliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}

	@Override
	public String toString() {
		return "[descricao=" + descricao + ", valorTotal=" + valorTotal
				+ ", nomeCliente=" + nomeCliente + "]";
	}
}
