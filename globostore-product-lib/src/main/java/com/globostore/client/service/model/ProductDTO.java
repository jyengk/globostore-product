package com.globostore.client.service.model;

/**
 * DTO to handle product details in the product table
 * @author jyengk
 *
 */
public class ProductDTO {
	
	private char id;
	private String name;
	private String category;
	private Double unitPrice;
	
	public char getId() {
		return id;
	}
	public void setId(char id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", category=" + category + ", unitPrice=" + unitPrice + "]";
	}
	
}
