package br.com.fake.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.fake.domain.Carrinho;
import br.com.fake.model.Produto;

@Repository
public class CarrinhoDao extends Dao implements Carrinho {

	@Override
	public Produto getProduto(int id) {
		Produto produto = geEntityManager().find(Produto.class, id);
		return produto;
	}

}
