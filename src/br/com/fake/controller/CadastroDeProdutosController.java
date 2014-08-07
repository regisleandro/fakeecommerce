package br.com.fake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fake.model.Produto;
import br.com.fake.model.TipoDeProduto;

@Controller
public class CadastroDeProdutosController {
	@RequestMapping(value = "/produtos/")
	public String cadastroProdutos(Model model) {
		model.addAttribute("tipos", TipoDeProduto.values());
		model.addAttribute("produto", new Produto());
		return "produtos";
	}
	
	@RequestMapping(value = "/produtos/cadastrar")
	public String cadastrar(@ModelAttribute Produto produto, Model model) {
		System.out.println(produto.getDescricao());
		
		return "produtos";
	}	
}
