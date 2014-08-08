package br.com.fake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fake.domain.ProdutoInterface;
import br.com.fake.domain.Vitrine;

@Controller
public class VitrineController {

	@Autowired
	private ProdutoInterface vitrine;

	@RequestMapping(value = "/vitrine/")
	public ModelAndView vitrine() {
		ModelAndView model = new ModelAndView("vitrine");
		model.addObject("produtos", vitrine.todos());
		return model;
	}
	
	@RequestMapping(value = "/vitrine/{id}")
	public ModelAndView compra(@PathVariable("id") int id){		
		ModelAndView model = new ModelAndView("carrinho");
		model.addObject("produto",vitrine.getProduto(id));
		return model;
	}	
}
