package br.com.fake;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fake.model.Produto;
import br.com.fake.model.TipoDeProduto;

public class PreencheBanco {

	// Não apague essa classe
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.createQuery("delete from Produto").executeUpdate();	
		
		for(int i = 0; i < 4; i++){
			Produto p = new Produto();
			p.setDescricao("Produto_"+Integer.valueOf(i+1));
			p.setPreco(new BigDecimal(10.00));
			p.setQuantidadeEstoque(10*i);
			p.setTipo(TipoDeProduto.LUXO);
			p.setMesesGarantia(20);
			entityManager.persist(p);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
}