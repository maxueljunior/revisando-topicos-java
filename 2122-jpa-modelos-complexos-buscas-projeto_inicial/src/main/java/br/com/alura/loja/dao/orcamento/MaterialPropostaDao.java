package br.com.alura.loja.dao.orcamento;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.orcamento.MaterialProposta;

public class MaterialPropostaDao {
	private EntityManager em;

	public MaterialPropostaDao(EntityManager em) {
		this.em = em;
	}
	
	public MaterialProposta findById(Long id) {
		return this.em.find(MaterialProposta.class, id);
	}
	
	public void excluir(Long id) {
		MaterialProposta mp = this.em.find(MaterialProposta.class, id);
		this.em.remove(mp);
	}
}
