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
	public boolean podeComprar(int quantidade){
		int restantes = getQuantidadeEstoque() - quantidade;
		return restantes > 0;
	}
}
