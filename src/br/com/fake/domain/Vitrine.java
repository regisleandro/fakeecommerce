package br.com.fake.domain;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fake.model.Produto;


public interface Vitrine {
	public List<Produto> todos();
}
