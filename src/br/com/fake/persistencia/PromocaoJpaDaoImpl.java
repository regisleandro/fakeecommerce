package br.com.fake.persistencia;

import org.springframework.stereotype.Repository;

import br.com.fake.domain.PromocaoJpaDao;
import br.com.fake.model.Promocao;

@Repository
public class PromocaoJpaDaoImpl extends AbstractJpaDao<Promocao> implements PromocaoJpaDao {
	public PromocaoJpaDaoImpl(){
		setClazz(Promocao.class);
	}

}
