package br.com.fake.domain;

import org.springframework.stereotype.Repository;

import br.com.fake.model.Produto;

public interface Carrinho {
	public Produto getProduto(int id);
}
