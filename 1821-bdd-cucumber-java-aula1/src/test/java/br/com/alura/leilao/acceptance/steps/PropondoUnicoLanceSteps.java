package br.com.alura.leilao.acceptance.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoUnicoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	private List<Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}
	
	@After
	public void tearDown() {
	}
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propoe ao leilao")
	public void quando_propoe_o_lance() {
		leilao.propoe(lance);
	}
	
	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	/*
	 * @Dado("varios lances validos") public void varios_lances_validos() { Usuario
	 * usuario = new Usuario("fulano"); lance10 = new Lance(usuario,
	 * BigDecimal.TEN); Usuario usuario2 = new Usuario("beltrano"); lance15 = new
	 * Lance(usuario2, new BigDecimal("15.0")); leilao = new Leilao("Tablet XPTO");
	 * }
	 */
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeDoUsuario) {
		Lance lance = new Lance(new Usuario(nomeDoUsuario), new BigDecimal(valor));
		lista.add(lance);
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		lista.forEach(lance -> leilao.propoe(lance));
	}
	
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		assertEquals(this.lista.size(), leilao.getLances().size());
		assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}

	@Dado("um lance invalido de {double} reais e do usuario {string}")
	public void um_lance_invalido_de_reais(Double valor, String nomeDoUsuario) {
		this.lance = new Lance(new BigDecimal(valor));
	}
	
	@Quando("propoe o lance ao leilao")
	public void propoe_o_lance_ao_leilao() {
		leilao.propoe(lance);
	}
	
	@Entao("o lances nao e aceito")
	public void o_lances_nao_e_aceito() {
		assertEquals(0, leilao.getLances().size());
	}
	
	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
		List<Map<String, String>> valores = dataTable.asMaps();
		for (Map<String, String> string : valores) {
			
			String valor = string.get("valor");
			String usuario = string.get("nomeUsuario");
			Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
			lista.add(lance);
			System.out.println(string.values());
		}
	}
	
	@Entao("o segundo lance nao e aceito")
	public void o_segundo_lance_nao_e_aceito() {
		assertEquals(1, leilao.getLances().size());
		assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	}
}
