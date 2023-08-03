package br.com.alura.loja.dao.orcamento;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.orcamento.Proposta;
import br.com.alura.loja.modelo.orcamento.vo.RelatorioMateriaisPorClienteVo;

public class PropostaDao {
	
	private EntityManager em;

	public PropostaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Proposta proposta) {
		this.em.persist(proposta);
	}
	
	public Proposta findById(Long id) {
		return this.em.find(Proposta.class, id);
	}
	
	public List<RelatorioMateriaisPorClienteVo> retornarMateriaisPorCliente(){
		String jpql = "SELECT new br.com.alura.loja.modelo.orcamento.vo.RelatorioMateriaisPorClienteVo(material.descricao, "
				+ "SUM(mp.quantidade * mp.valor) as valorTotal, "
				+ "proposta.nomeCliente) "
				+ "FROM Proposta proposta "
				+ "JOIN proposta.itens mp "
				+ "JOIN mp.materiais material "
				+ "WHERE material.descricao =:nome "
				+ "GROUP BY material.descricao, proposta.nomeCliente";
		return this.em.createQuery(jpql, RelatorioMateriaisPorClienteVo.class)
				.setParameter("nome", "HASTE VALVULA F.R")
				.getResultList();
	}
}
