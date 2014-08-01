package br.com.fake.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fake.domain.Produto;

@Controller
public class VitrineController {
	@RequestMapping(value = "/vitrine")
	public ModelAndView welcome() {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("default");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		List<Produto> produtos = entityManager.createQuery("from Produto").getResultList();

		ModelAndView model = new ModelAndView("welcome");

		model.addObject("produtos", produtos);

		entityManager.getTransaction().commit();
		entityManager.close();

		return model;
	}

	@RequestMapping(value = "/vitrine/{id}")
	public ModelAndView compra(@PathVariable("id") int id){		
		ModelAndView model = new ModelAndView("vitrine");
		System.err.println(id);
		
		return model;
	}
	

}
