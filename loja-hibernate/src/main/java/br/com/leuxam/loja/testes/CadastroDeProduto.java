package br.com.leuxam.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.leuxam.loja.dao.ProdutoDAO;
import br.com.leuxam.loja.modelo.Produto;
import br.com.leuxam.loja.utils.JPAUtils;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto p = new Produto();
		p.setNome("Xiaomi Redmi");
		p.setDescricao("Muito bom");
		p.setPreco(new BigDecimal("1500.00"));
		
		EntityManager em = JPAUtils.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(p);
		em.getTransaction().commit();
		em.close();
	}

}
