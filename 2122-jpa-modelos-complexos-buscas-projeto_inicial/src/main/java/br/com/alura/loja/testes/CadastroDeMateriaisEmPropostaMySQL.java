package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.orcamento.MaterialDao;
import br.com.alura.loja.dao.orcamento.MaterialPropostaDao;
import br.com.alura.loja.dao.orcamento.PropostaDao;
import br.com.alura.loja.modelo.orcamento.Material;
import br.com.alura.loja.modelo.orcamento.MaterialProposta;
import br.com.alura.loja.modelo.orcamento.Proposta;
import br.com.alura.loja.modelo.orcamento.vo.RelatorioMateriaisPorClienteVo;
import br.com.alura.loja.util.JPAUtilMySQL;

public class CadastroDeMateriaisEmPropostaMySQL {
	public static void main(String[] args) {
		popularBd();
		
		EntityManager em = JPAUtilMySQL.getEntityManager();
		PropostaDao propostaDao = new PropostaDao(em);
		
		List<RelatorioMateriaisPorClienteVo> retornarMateriaisPorCliente = propostaDao.retornarMateriaisPorCliente();
		retornarMateriaisPorCliente.forEach(System.out::println);
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
		proposta.adicionar(new MaterialProposta(10, haste, proposta));
		proposta.adicionar(new MaterialProposta(2, servo, proposta));
		
		em.getTransaction().commit();
	}
}
