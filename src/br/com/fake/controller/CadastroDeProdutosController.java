package br.com.fake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fake.model.TipoDeProduto;

@Controller
public class CadastroDeProdutosController {
	@RequestMapping(value = "/produtos/")
	public ModelAndView cadastroProdutos() {
		ModelAndView model = new ModelAndView("produtos");
		model.addObject("tipos", TipoDeProduto.values());
		
		return model;
	}
}
