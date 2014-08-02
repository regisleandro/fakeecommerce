package br.com.fake.domain.precos;


import java.math.BigDecimal;

import br.com.fake.model.Produto;
import br.com.fake.model.TipoDeProduto;

public class ProdutoTestDataBuilder {

	private BigDecimal preco;
	private int quantidadeEstoque;
	private int quantidadeVendida;
	private TipoDeProduto tipo;
	private int mesesGarantia;

	public static ProdutoTestDataBuilder umProduto() {
		return new ProdutoTestDataBuilder();
	}
	
	public ProdutoTestDataBuilder deUmTipo(TipoDeProduto tipo){
		this.tipo = tipo;
		return this;
	}

	public ProdutoTestDataBuilder comOPreco(double preco) {
		this.preco = BigDecimal.valueOf(preco);
		return this;
	}

	public ProdutoTestDataBuilder comOEstoqueDe(int quantidade) {
		this.quantidadeEstoque = quantidade;
		return this;
	}
	
	public ProdutoTestDataBuilder comReservaDe(int quantidade){
		this.quantidadeVendida = quantidade;
		return this;
	}

	public ProdutoTestDataBuilder comGarantiaEmMesesDe(int garantiaEmMeses) {
		this.mesesGarantia = garantiaEmMeses;
		return this;
	}

	public Produto build() {
		Produto produto = new Produto();
		produto.setPreco(preco);
		produto.setQuantidadeEstoque(quantidadeEstoque);
		produto.setQuantidadeVendida(quantidadeVendida);
		produto.setTipo(tipo);
		produto.setMesesGarantia(mesesGarantia);
		
		return produto;
	}

}
