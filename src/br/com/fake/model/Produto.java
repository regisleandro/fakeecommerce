package br.com.fake.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	private int id;
	
	private String descricao;
	private BigDecimal preco;
	private int quantidadeEstoque;
	private int quantidadeVendida;
	@Enumerated(EnumType.STRING)
	private TipoDeProduto tipo;
	private int mesesGarantia;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public int getId(){
		return this.id;
	}
	
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public TipoDeProduto getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeProduto tipo) {
		this.tipo = tipo;
	}
	public int getMesesGarantia() {
		return mesesGarantia;
	}
	public void setMesesGarantia(int mesesGarantia) {
		this.mesesGarantia = mesesGarantia;
	}
	public void reservarProduto(int quantidade){
		this.quantidadeVendida += quantidade;
	}
	public Integer getProdutosDisponiveis() {
		return quantidadeEstoque - quantidadeVendida;
	}

	public boolean podeComprar(int quantidade){
		int restantes = getProdutosDisponiveis() - quantidade;
		return restantes > 0;
	}
}
