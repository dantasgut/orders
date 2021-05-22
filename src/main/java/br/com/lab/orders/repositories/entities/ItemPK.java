package br.com.lab.orders.repositories.entities;

import java.io.Serializable;

public class ItemPK implements Serializable{

	private static final long serialVersionUID = -5636946000018730266L;
	
	private Integer id;
	private Integer product;
	private Integer order;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct() {
		return product;
	}
	public void setProduct(Integer product) {
		this.product = product;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
}
