package br.com.fake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fake.domain.ProdutoJpaDao;
import br.com.fake.domain.PromocaoJpaDao;
import br.com.fake.model.Produto;
import br.com.fake.model.Promocao;


@Controller
public class CadastroDePromocoesController {
	@Autowired
	private PromocaoJpaDao promocao;
	@Autowired
	private ProdutoJpaDao produto;
	
	@RequestMapping(value = "/promocoes/adicionar/{id}")
	public String editar(@PathVariable("id") int id, Model model){
		Produto p = produto.findOne(id);
		model.addAttribute("panel","default");
		model.addAttribute("titulo", "Cadastro de Promoções para o Produto: "+ p.getDescricao());	
		model.addAttribute("produto", p);
		model.addAttribute("promocao", new Promocao());
		model.addAttribute("action","/promocoes/salvar/");
		return "promocoes";
	}	
	
}
