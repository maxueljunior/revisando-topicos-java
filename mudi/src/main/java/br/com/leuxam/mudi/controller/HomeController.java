package br.com.leuxam.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.leuxam.mudi.model.Pedido;
import br.com.leuxam.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;

	@GetMapping("/home")
	public ModelAndView home() {
		List<Pedido> resultList = repository.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", resultList);
		return mv;
	}
	
//	@GetMapping("/home")
//	public String home(Model model) {
//		
//		List<Pedido> resultList = repository.findAll();
//		
//		model.addAttribute("pedidos", resultList);
//		
//		return "home";
//	}
}
