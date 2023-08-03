package br.com.alura.loja.modelo.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propostas")
public class Proposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	@OneToMany(mappedBy = "propostas", cascade = CascadeType.ALL)
	private List<MaterialProposta> itens = new ArrayList<>();
	
	public Proposta(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public Proposta() {}
	
	public void adicionar(MaterialProposta materialProposta) {
		materialProposta.setPropostas(this);
		materialProposta.setValor(materialProposta.getMateriais().getPreco());
		this.itens.add(materialProposta);
		this.valorTotal = valorTotal.add(materialProposta.getValorTotal());
	}
	
	public void atualizar(MaterialProposta materialProposta, Integer quantidade) {
		materialProposta.setQuantidade(quantidade);
		this.itens.add(materialProposta);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
