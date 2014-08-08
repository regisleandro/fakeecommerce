package br.com.fake.domain;

import java.util.List;

import br.com.fake.model.Produto;

public interface ProdutoInterface<E> {
	public Produto getProduto(int id);
	public List<Produto> todos();
	public void persist(E entity);
	public void update(E entity);
	public void remove(E entity);
}
