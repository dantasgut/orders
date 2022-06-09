package br.com.lab.orders.api.dtos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderDTO")
public class OrderDTO {
	
	
	private Integer id;
	
	@JsonProperty("date")
	@ApiModelProperty(example="2021-02-22",required = true)
	private LocalDate date;
	
	@JsonProperty("status")
	@ApiModelProperty(example="finalizado",required = true)
	private String status;
	
	@JsonProperty("currency")
	@ApiModelProperty(example="BRL",required = true)
	private String currency;
	
	@JsonProperty("promotionCode")
	@ApiModelProperty(name="items",required = true)
	private String promotionCode;
	
	@JsonProperty("items")
	@JsonManagedReference
	private List<ItemDTO> itemsDTO;
	private Double total;
	
	public OrderDTO() {
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

	public List<ItemDTO> getItemsDTO() {
		return itemsDTO;
	}

	public void setItemsDTO(List<ItemDTO> itemsDTO) {
		this.itemsDTO = itemsDTO;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
}
