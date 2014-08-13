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
import br.com.fake.model.TipoDeProduto;


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
		Promocao promo = p.getPromocao();
		if (promo == null){
			 promo = new Promocao();
		}
		promo.setProduto(p);
		model.addAttribute("promocao", promo);
		model.addAttribute("action","/promocoes/salvar/");
		return "promocoes";
	}	
	
	@RequestMapping(value = "/promocoes/salvar/")
	public String salvar(@ModelAttribute Promocao p, Model model) {
		try{
			System.out.println(p.getProduto().getDescricao());
			promocao.save(p);
						
		}catch(Exception ex){
			ex.printStackTrace();		
		}
		
		return "produtos";
	}	
	
	@RequestMapping(value = "/promocoes/excluir/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		try{
			promocao.deleteById(id);

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Exclusão de Promoção - Concluído");	
			
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Produtos - Erro ao efetuar a exclusão");
			ex.printStackTrace();
		}
		
		return "produtos";
	}	
}
