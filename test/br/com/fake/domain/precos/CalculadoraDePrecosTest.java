package br.com.fake.domain.precos;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.fake.model.Produto;
import br.com.fake.model.TipoDeProduto;

public class CalculadoraDePrecosTest {

	@Test
	public void deveConsiderarQuantidadeAoCalcularPrecoTotal(){
		Produto produto = ProdutoTestDataBuilder
			.umProduto()
			.deUmTipo(TipoDeProduto.ALTO_LUXO)
			.comOPreco(10.0)
			.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 9);

		assertEquals(0, BigDecimal.valueOf(90.0).compareTo(precoTotal));
	}

	@Test
	public void deveAplicar10PorCentoAMaisNosUltimosProdutosQuandoForLuxo(){
		Produto produto =	ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.LUXO)
				.comOPreco(20.0)
				.comOEstoqueDe(100)
				.comReservaDe(95)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(22.0).compareTo(precoTotal));
	}

	@Test
	public void naoDeveAplicarAcrescimoNosPrimeirosProdutosQuandoForLuxo(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.LUXO)
				.comOPreco(20.0)
				.comOEstoqueDe(100)
				.comReservaDe(10)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(20.0).compareTo(precoTotal));
	}

	@Test
	public void deveAplicar10PorCentoAMaisNosUltimosProdutosQuandoForAltoLuxo(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.ALTO_LUXO)
				.comOPreco(100.0)
				.comOEstoqueDe(100)
				.comReservaDe(95)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(110.0).compareTo(precoTotal));
	}

	@Test
	public void naoDeveAplicarAcrescimoNosPrimeirosProdutosQuandoForAltoLuxo(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.ALTO_LUXO)
				.comOPreco(100.0)
				.comOEstoqueDe(200)
				.comReservaDe(15)
				.build();
		
		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(100.0).compareTo(precoTotal));
	}

	@Test
	public void deveAplicar20PorCentoAMaisNosUltimosProdutosQuandoForMedio(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.MEDIO)
				.comOPreco(500.0)
				.comOEstoqueDe(50)
				.comReservaDe(25)
				.comGarantiaEmMesesDe(10)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(600.0).compareTo(precoTotal));
	}

	@Test
	public void naoDeveAplicarAcrescimoNosPrimeirosProdutosQuandoForMedio(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.MEDIO)
				.comOPreco(500.0)
				.comOEstoqueDe(50)
				.comReservaDe(5)
				.comGarantiaEmMesesDe(10)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(500.0).compareTo(precoTotal));
	}

	@Test
	public void deveAplicar10AMaisSeAGarantiaDurarMaisQue12MesesQuandoForMedio(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.MEDIO)
				.comOPreco(500.0)
				.comOEstoqueDe(50)
				.comReservaDe(5)
				.comGarantiaEmMesesDe(20)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(550.0).compareTo(precoTotal));
	}

	@Test
	public void deveAplicar20PorCentoAMaisNosUltimosProdutosQuandoForNormal(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.NORMAL)
				.comOPreco(1000.0)
				.comOEstoqueDe(70)
				.comReservaDe(40)
				.comGarantiaEmMesesDe(10)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(1200.0).compareTo(precoTotal));
	}

	@Test
	public void naoDeveAplicarAcrescimoNosPrimeirosProdutosQuandoForNormal(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.NORMAL)
				.comOPreco(1000.0)
				.comOEstoqueDe(70)
				.comReservaDe(10)
				.comGarantiaEmMesesDe(10)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(1000.0).compareTo(precoTotal));
	}

	@Test
	public void deveAplicar10AMaisSeAGarantiaDurarMaisQue12MesesQuandoForNormal(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.NORMAL)
				.comOPreco(1000.0)
				.comOEstoqueDe(70)
				.comReservaDe(65)
				.comGarantiaEmMesesDe(20)
				.build();
		
		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(1300.0).compareTo(precoTotal));
	}

	@Test
	public void naoDeveAplicarAcrescimoQuandoForXingLing(){
		Produto produto = ProdutoTestDataBuilder
				.umProduto()
				.deUmTipo(TipoDeProduto.XING_LING)
				.comOPreco(10.0)
				.build();

		BigDecimal precoTotal = CalculadoraDePrecos.calcula(produto, 1);

		assertEquals(0, BigDecimal.valueOf(10.0).compareTo(precoTotal));
	}	
}
