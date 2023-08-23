package br.com.leuxam.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.leuxam.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		
		Pedido pedido = new Pedido();
		pedido.setNome("Kindle Unlimited");
		pedido.setUrlDaImagem("https://url.da.imagem.com.br");
		pedido.setUrlDoProduto("https://url.do.produto.com.br");
		pedido.setDescricao("Uma descrição pra um produto qualquer");
		pedido.setValor(new BigDecimal("100.00"));
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
}
