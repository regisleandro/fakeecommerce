package br.com.fake.persistencia;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.fake.domain.Vitrine;
import br.com.fake.model.Produto;

@Repository
public class VitrineDao extends Dao implements Vitrine {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> todos() {
		List<Produto> produtos = geEntityManager().createQuery("from Produto").getResultList();
		
		return produtos;
	}

}
