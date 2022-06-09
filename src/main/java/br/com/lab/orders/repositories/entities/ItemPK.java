package br.com.lab.orders.repositories.entities;

import java.io.Serializable;
import java.util.Objects;

public class ItemPK implements Serializable{

	private static final long serialVersionUID = -5636946000018730266L;
	
	private Integer id;
	private Product product;
	private Order order;
	
	
	
	public ItemPK() {
		
	}

	public ItemPK(Product product, Order order) {
		super();
		this.product = product;
		this.order = order;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
    public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof ItemPK) {
        	 ItemPK itemPK = (ItemPK) o;
             return order.getId().equals(itemPK.order.getId()) && product.getId().equals(itemPK.product.getId()); 
        }

        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(order.getId(), product.getId());
    }
	
}
