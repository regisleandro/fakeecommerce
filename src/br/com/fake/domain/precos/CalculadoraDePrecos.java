package br.com.fake.domain.precos;

import java.math.BigDecimal;

import br.com.fake.model.Produto;
import br.com.fake.model.TipoDeProduto;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Produto produto, int quantidade) {
		BigDecimal preco;
		
		if(produto.getTipo().equals(TipoDeProduto.ALTO_LUXO) || produto.getTipo().equals(TipoDeProduto.LUXO)) {
			//quando estiver acabando os produtos 
			if((produto.getQuantidadeEstoque() - produto.getQuantidadeVendida()) / new Double(produto.getQuantidadeEstoque()) <= 0.05) {
				preco = produto.getPreco().add(produto.getPreco().multiply(BigDecimal.valueOf(0.10)));
				System.out.println(preco);
			} else {
				preco = produto.getPreco();
			}
		} else if(produto.getTipo().equals(TipoDeProduto.MEDIO)) {
			if((produto.getQuantidadeEstoque() - produto.getQuantidadeVendida()) / new Double(produto.getQuantidadeEstoque()) <= 0.50) { 
				preco = produto.getPreco().add(produto.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = produto.getPreco();
			}

			if(produto.getMesesGarantia() > 12){
				preco = preco.add(produto.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
		} else if(produto.getTipo().equals(TipoDeProduto.NORMAL)) {
			if((produto.getQuantidadeEstoque() - produto.getQuantidadeVendida()) / new Double(produto.getQuantidadeEstoque()) <= 0.50) { 
				preco = produto.getPreco().add(produto.getPreco().multiply(BigDecimal.valueOf(0.20)));
			} else {
				preco = produto.getPreco();
			}

			if(produto.getMesesGarantia() > 12){
				preco = preco.add(produto.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
		}  else {
			//nao aplica aumento para XING_LING (pobre)
			preco = produto.getPreco();
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}
}