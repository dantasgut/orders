package br.com.lab.orders.repositories.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name="tb_orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "sq_orders")	
	@TableGenerator(name = "sq_orders", table = "tb_sequences", pkColumnName = "name", valueColumnName = "value", pkColumnValue="sq_orders", initialValue=10000, allocationSize=1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="status")
	private String status;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="promotion_code")
	private String promotionCode;

	@OneToMany(mappedBy="order", cascade = {CascadeType.ALL})	
	private Set<Item> items = new HashSet<Item>();
	
	@Transient
	@Column(name="total")
	private Double total;

	public Order() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
