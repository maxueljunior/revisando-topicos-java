package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido produto) {
		this.em.persist(produto);
	}
	
	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas(){
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo(produto.nome, "
				+ "SUM(item.quantidade) as quantidadeTotal, "
				+ "MAX(pedido.data))"
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY quantidadeTotal DESC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
	
//	public List<Object[]> relatorioDeVendas(){
//		String jpql = "SELECT produto.nome, "
//				+ "SUM(item.quantidade), "
//				+ "MAX(pedido.data)"
//				+ "FROM Pedido pedido "
//				+ "JOIN pedido.itens item "
//				+ "JOIN item.produto produto "
//				+ "GROUP BY produto.nome "
//				+ "ORDER BY item.quantidade DESC";
//		return em.createQuery(jpql, Object[].class).getResultList();
//	} Forma não muito bonita para criar
}
