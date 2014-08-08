package br.com.fake.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public EntityManager geEntityManager(){
		return this.entityManager;
	}
}
