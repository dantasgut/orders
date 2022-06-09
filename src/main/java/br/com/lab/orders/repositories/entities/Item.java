package br.com.lab.orders.repositories.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tb_items")
@IdClass(ItemPK.class)
@AttributeOverrides({
    @AttributeOverride(name = "order", column=@Column(name="id_order")),
    @AttributeOverride(name = "product", column=@Column(name="id_product"))
})
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "sq_items")	
	@TableGenerator(name = "sq_items", table = "tb_sequences", pkColumnName = "name", valueColumnName = "value", pkColumnValue="sq_items", initialValue=10000, allocationSize=1)	
	@Column(name="id")
	private Integer id;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.DETACH, optional = false)
	@JoinColumn(
			name = "id_product",
			referencedColumnName = "id")
	private Product product;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.DETACH)
	@JoinColumn(
			name = "id_order",
			referencedColumnName = "id")	
	private Order order;

	@Column(name="quantity")
	private Integer quantity;

	public Item() {
		
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
