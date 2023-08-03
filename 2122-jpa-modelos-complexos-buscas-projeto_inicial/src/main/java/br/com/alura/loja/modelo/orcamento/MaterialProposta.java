package br.com.alura.loja.modelo.orcamento;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materiais_proposta")
public class MaterialProposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantidade;
	private BigDecimal valor;
	
	@ManyToOne
	private Material materiais;
	
	@ManyToOne
	private Proposta propostas;

	public MaterialProposta(Integer quantidade, Material materiais, Proposta propostas) {
		this.quantidade = quantidade;
		this.materiais = materiais;
		this.propostas = propostas;
		this.valor = materiais.getPreco();
	}
	
	public MaterialProposta() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Material getMateriais() {
		return materiais;
	}

	public void setMateriais(Material materiais) {
		this.materiais = materiais;
	}

	public Proposta getPropostas() {
		return propostas;
	}

	public void setPropostas(Proposta propostas) {
		this.propostas = propostas;
	}

	public BigDecimal getValorTotal() {
		return this.valor.multiply(new BigDecimal(quantidade));
	}
}
