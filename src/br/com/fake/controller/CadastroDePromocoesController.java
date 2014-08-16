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
	
	@RequestMapping(value = "/promocoes/adicionar/{id}/promocao/{idPromo}")
	public String editar(@PathVariable("id") int id, @PathVariable("idPromo") int idPromo, Model model){
		Produto p = produto.findOne(id);
		Promocao promo = promocao.findOne(idPromo);
		model.addAttribute("panel","default");
		model.addAttribute("titulo", "Cadastro de Promoções para o Produto: "+ p.getDescricao());	
		if (promo == null){
			 promo = new Promocao();
		}
		promo.setProduto(p);
		p.setPromocao(promo);
		model.addAttribute("promocao", promo);
		model.addAttribute("action","/promocoes/salvar/");
		return "promocoes";
	}	
	
	@RequestMapping(value = "/promocoes/salvar/")
	public String salvar(@ModelAttribute Promocao p, @ModelAttribute Produto prod, Model model) {
		try{
			prod = produto.findOne(p.getProduto().getId());
			prod.setPromocao(p);
			p.setProduto(prod);
			System.out.println(p.getDataInicio());
			promocao.update(p);
						
		}catch(Exception ex){
			ex.printStackTrace();		
		}
		
		return "redirect:/produtos/";
	}	
	
	@RequestMapping(value = "/promocoes/excluir/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		try{
			promocao.deleteById(id);

			model.addAttribute("panel","success");
			model.addAttribute("titulo", "Exclusão de Promção - Conclusão");	
			
		}catch(Exception ex){
			model.addAttribute("panel","danger");
			model.addAttribute("titulo", "Cadastro de Produtos - Erro ao efetuar a exclusão");
			ex.printStackTrace();
		}
		
		return "redirect:/produtos/";
	}	
}
