package br.com.lab.orders.api.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ItemDTO")
public class ItemDTO {
	
	private Integer id;
		
	private ProductDTO product;
	
	@ApiModelProperty(example="2",required = true)
	private Integer quantity;
	
	
	@JsonBackReference
	private OrderDTO orderDTO;
	
	public ItemDTO() {		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}
	
	
	
}
