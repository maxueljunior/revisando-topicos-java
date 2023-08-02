package br.com.alura.loja.dao.orcamento;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.orcamento.Material;

public class MaterialDao {
	
	private EntityManager em;

	public MaterialDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Material material) {
		this.em.persist(material);
	}
	
	public Material findById(Long id) {
		return this.em.find(Material.class, id);
	}
	
}
