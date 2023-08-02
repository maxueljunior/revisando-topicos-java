package br.com.alura.loja.dao.orcamento;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.orcamento.Proposta;

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
	
}
