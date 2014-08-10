package br.com.fake.persistencia;

import org.springframework.stereotype.Repository;

import br.com.fake.domain.ProdutoJpaDao;
import br.com.fake.model.Produto;

@Repository
public class ProdutoJpaDaoImpl extends AbstractJpaDao<Produto> implements ProdutoJpaDao {
	public ProdutoJpaDaoImpl(){
		setClazz(Produto.class);
	}

}
