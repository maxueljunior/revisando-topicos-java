package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.orcamento.MaterialDao;
import br.com.alura.loja.dao.orcamento.MaterialPropostaDao;
import br.com.alura.loja.dao.orcamento.PropostaDao;
import br.com.alura.loja.modelo.orcamento.Material;
import br.com.alura.loja.modelo.orcamento.MaterialProposta;
import br.com.alura.loja.modelo.orcamento.Proposta;
import br.com.alura.loja.util.JPAUtilMySQL;

public class RelatorioDeMateriaisEmPropostaMySQL {
	public static void main(String[] args) {
		popularBd();
		
		EntityManager em = JPAUtilMySQL.getEntityManager();
		PropostaDao propostaDao = new PropostaDao(em);
		MaterialDao materialDao = new MaterialDao(em);
		MaterialPropostaDao materialPropostaDao = new MaterialPropostaDao(em);
		
		Proposta proposta = propostaDao.findById(1L);
		Material haste = materialDao.findById(1L);
		Material servo = materialDao.findById(2L);
		//MaterialProposta mp = materialPropostaDao.findById(3l);
		
		em.getTransaction().begin();
		
		proposta.adicionar(new MaterialProposta(10, haste, proposta));
		proposta.adicionar(new MaterialProposta(2, servo, proposta));
		//materialPropostaDao.excluir(2L);
		//proposta.atualizar(mp, 1488);
		
		em.getTransaction().commit();
	}
	
	public static void popularBd() {
		
		Material haste = new Material("HASTE VALVULA F.R", new BigDecimal("15000.00"));
		Material servo = new Material("SERVO MOTOR RD 160G", new BigDecimal("999.00"));
		
		Proposta proposta = new Proposta("RAIZEN - DA BARRA");
		
		EntityManager em = JPAUtilMySQL.getEntityManager();
		
		PropostaDao propostaDao = new PropostaDao(em);
		MaterialDao materialDao = new MaterialDao(em);
		
		em.getTransaction().begin();
		
		propostaDao.cadastrar(proposta);
		materialDao.cadastrar(haste);
		materialDao.cadastrar(servo);
		
		em.getTransaction().commit();
	}
}
