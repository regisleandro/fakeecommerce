package br.com.fake.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.fake.domain.ProdutoInterface;
import br.com.fake.model.Produto;

@Repository
public class ProdutoDao<E> extends Dao implements ProdutoInterface<E> {

	@Override
	public Produto getProduto(int id) {
		Produto produto = geEntityManager().find(Produto.class, id);
		return produto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> todos() {
		List<Produto> produtos = geEntityManager().createQuery("from Produto").getResultList();
		return produtos;
	}
	
	@Override
	public void persist(E entity) { 
		geEntityManager().getTransaction().begin();
		geEntityManager().persist(entity);
		geEntityManager().getTransaction().commit();
	}

	@Override
	public void update(E entity) { 
		geEntityManager().getTransaction().begin();
		geEntityManager().merge(entity);
		geEntityManager().getTransaction().commit();
	}

	@Override
	public void remove(E entity) { 
		geEntityManager().getTransaction().begin();
		geEntityManager().remove(entity); 
		geEntityManager().getTransaction().commit();
	}
}
