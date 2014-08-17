package br.com.fake.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProdutoTest {

	@Test
	public void deveVender1ProdutoSeHa2EmEstoque() throws Exception {
		Produto produto = new Produto();
        produto.setQuantidadeEstoque(2);

        assertTrue(produto.podeComprar(1));
 	}

	@Test
	public void deveVender5ProdutosSeHa10EmEstoque() throws Exception {
		Produto produto = new Produto();
		produto.setQuantidadeEstoque(10);

		assertTrue(produto.podeComprar(5));
	}

	@Test
	public void naoDeveVender3ProdutosSeHa2EmEstoque() throws Exception {
		Produto produto = new Produto();
		produto.setQuantidadeEstoque(2);

		assertFalse(produto.podeComprar(3));
	}

	@Test
	public void reservarProdutosDeveDiminuirONumeroDeProdutosDisponiveis() throws Exception {
		Produto produto = new Produto();
		produto.setQuantidadeEstoque(5);

		produto.setQuantidadeVendida(3);
		assertEquals(2, produto.getProdutosDisponiveis().intValue());
	}
}
