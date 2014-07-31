package br.com.fake.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fake.domain.Produto;

@Controller
@RequestMapping(value="/welcome")
public class WelcomeController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcome() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Produto> produtos = entityManager.createQuery("from Produto").getResultList();
		
		ModelAndView model = new ModelAndView("welcome");
		
		model.addObject("produtos", produtos);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		return model;
	}

}
