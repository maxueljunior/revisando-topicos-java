package br.com.leuxam.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.leuxam.mudi.model.Pedido;
import br.com.leuxam.mudi.model.StatusPedido;
import br.com.leuxam.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;

	@GetMapping
	public ModelAndView home() {
		List<Pedido> resultList = repository.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", resultList);
		return mv;
	}
	
	@GetMapping("/{status}")
	public ModelAndView porStatus(@PathVariable("status") String status) {
		List<Pedido> resultList = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", resultList);
		mv.addObject("status", status);
		return mv;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
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
