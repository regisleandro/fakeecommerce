package br.com.fake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fake.domain.ProdutoInterface;
import br.com.fake.model.Produto;
import br.com.fake.model.TipoDeProduto;

@Controller
public class CadastroDeProdutosController {
	@Autowired
	private ProdutoInterface<Produto> produto;
	
	@RequestMapping(value = "/produtos/")
	public String cadastroProdutos(Model model) {
		model.addAttribute("panel","default");
		model.addAttribute("titulo", "Cadastro de Produtos");		
		model.addAttribute("produto", new Produto());
		model.addAttribute("tipos", TipoDeProduto.values());
		model.addAttribute("produtos", produto.todos());
		model.addAttribute("action","/produtos/cadastrar/");
		return "produtos";
	}
	
	@RequestMapping(value = "/produtos/cadastrar")
	public String cadastrar(@ModelAttribute Produto p, Model model) {
		try{
			produto.persist(p);

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Cadastro de Produtos - Concluído");
			model.addAttribute("produto", new Produto());
			model.addAttribute("tipos", TipoDeProduto.values());
			model.addAttribute("produtos", produto.todos());
			model.addAttribute("action","/produtos/cadastrar/");			
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Produtos - Erro ao efetuar o cadastro");
			
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/produtos/alterar/")
	public String alterar(@ModelAttribute Produto p, Model model) {
		try{
			produto.update(p);

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Cadastro de Produtos - Concluído");	
			model.addAttribute("produto", new Produto());
			model.addAttribute("tipos", TipoDeProduto.values());
			model.addAttribute("produtos", produto.todos());
			model.addAttribute("action","/produtos/cadastrar/");
						
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Produtos - Erro ao efetuar a alteração");
			ex.printStackTrace();
			
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/produtos/excluir/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		try{
			produto.remove(produto.getProduto(id));

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Cadastro de Produtos - Concluído");	
			model.addAttribute("produto", new Produto());
			model.addAttribute("tipos", TipoDeProduto.values());
			model.addAttribute("produtos", produto.todos());
			model.addAttribute("action","/produtos/cadastrar/");
			
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Produtos - Erro ao efetuar a exclusão");
			ex.printStackTrace();
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/produtos/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model){
		model.addAttribute("panel","default");
		model.addAttribute("titulo", "Cadastro de Produtos");	
		model.addAttribute("produto", produto.getProduto(id));
		model.addAttribute("tipos", TipoDeProduto.values());
		model.addAttribute("produtos", produto.todos());
		model.addAttribute("action","/produtos/alterar/");
		return "produtos";
	}	
}
