package br.com.fake.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

public abstract class AbstractJpaDao<T extends Serializable>{
	   private Class<T> clazz;
	   
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
	   public void setClazz(Class<T> clazzToSet){
	      this.clazz = clazzToSet;
	   }
	
	   public T findOne(int id){
	      return entityManager.find(clazz, id);
	   }
	
	   @SuppressWarnings("unchecked")
	   public List<T> findAll(){
		   List<T> lista = Collections.EMPTY_LIST;
	      try{
	    	  if (entityManager != null)
	    		  lista = entityManager.createQuery("from " + clazz.getName()).getResultList();
	      }catch(Exception ex){
	    	  ex.printStackTrace();
	      }
	      return lista;
	   }
	 
	   public void save(T entity){
	      entityManager.persist( entity );
	   }
	 
	   public void update(T entity){
	      entityManager.merge(entity);
	   }
	 
	   public void delete(T entity){
	      entityManager.remove( entity );
	   }

	   public void deleteById(int entityId){
	      T entity = findOne(entityId);
	      delete( entity );
	   }

}

