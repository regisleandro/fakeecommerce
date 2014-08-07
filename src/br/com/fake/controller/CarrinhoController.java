package br.com.fake.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fake.domain.Carrinho;
import br.com.fake.domain.precos.CalculadoraDePrecos;
import br.com.fake.model.Produto;
import br.com.fake.persistencia.CarrinhoDao;

@Controller
public class CarrinhoController {
	@Autowired
	private Carrinho carrinho;
	
	@RequestMapping(value = "/carrinho/concluirCompra/{id}", method = RequestMethod.POST)
	public ModelAndView concluirCompra(@PathVariable("id") int id, @RequestParam("quantidade") int quantidade){
		ModelAndView model = new ModelAndView("conclusao");
		model.addObject("panel", "panel-success");
		Produto produto = carrinho.getProduto(id);
		model.addObject("mensagem", "Finalizado com Sucesso!");
		if(!produto.podeComprar(quantidade)){
			model.addObject("panel", "panel-danger");
			model.addObject("mensagem", "Sem estoque");
		}
		produto.setQuantidadeVendida(quantidade);
		BigDecimal preco = CalculadoraDePrecos.calcula(produto, quantidade);
		model.addObject("precoFinal", preco);
		model.addObject(produto);
		
		return model;
	}
	
}
