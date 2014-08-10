package br.com.fake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fake.domain.PromocaoJpaDao;
import br.com.fake.model.Promocao;


@Controller
public class CadastroDePromocoesController {
	@Autowired
	private PromocaoJpaDao promocao;
	
	@RequestMapping(value = "/promocoes/")
	public String cadastroPromocaos(Model model) {
		model.addAttribute("panel","default");
		model.addAttribute("titulo", "Cadastro de Promocaos");		
		model.addAttribute("produto", new Promocao());
		model.addAttribute("produtos", promocao.findAll());
		model.addAttribute("action","/promocoes/cadastrar/");
		return "produtos";
	}
	
	@RequestMapping(value = "/promocoes/cadastrar")
	public String cadastrar(@ModelAttribute Promocao p, Model model) {
		try{
			promocao.save(p);

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Cadastro de Promocaos - Concluído");
			model.addAttribute("produto", new Promocao());
			model.addAttribute("produtos", promocao.findAll());
			model.addAttribute("action","/promocoes/cadastrar/");			
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Promoções - Erro ao efetuar o cadastro");
			
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/promocoes/alterar/")
	public String alterar(@ModelAttribute Promocao p, Model model) {
		try{
			promocao.update(p);
			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Cadastro de Promocaos - Concluído");	
			model.addAttribute("produto", new Promocao());
			model.addAttribute("produtos", promocao.findAll());
			model.addAttribute("action","/promocoes/cadastrar/");
						
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Promoções - Erro ao efetuar a alteração");
			ex.printStackTrace();
			
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/promocoes/excluir/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		try{
			promocao.deleteById(id);

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Cadastro de Promoções - Concluído");	
			model.addAttribute("produto", new Promocao());
			model.addAttribute("produtos", promocao.findAll());
			model.addAttribute("action","/promocoes/cadastrar/");
			
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Promocaos - Erro ao efetuar a exclusão");
			ex.printStackTrace();
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/promocoes/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model){
		model.addAttribute("panel","default");
		model.addAttribute("titulo", "Cadastro de Promoções");	
		model.addAttribute("produto", promocao.findOne(id));
		model.addAttribute("produtos", promocao.findAll());
		model.addAttribute("action","/promocoes/alterar/");
		return "produtos";
	}	
	
}
