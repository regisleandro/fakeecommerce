package br.com.fake.domain;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.stereotype.Repository;

import br.com.fake.model.Produto;

public interface ProdutoJpaDao extends IGenericDao<Produto>{
}
