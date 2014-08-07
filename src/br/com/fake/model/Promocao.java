package br.com.fake.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class Promocao {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="produto"))
	private int id;  
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name="produto_id")
	private Produto produto;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataInicio;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataFim;
	private BigDecimal percentualDesconto;
	
	public int getId() {
		return id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public DateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(DateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public DateTime getDataFim() {
		return dataFim;
	}
	public void setDataFim(DateTime dataFim) {
		this.dataFim = dataFim;
	}
	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
}
