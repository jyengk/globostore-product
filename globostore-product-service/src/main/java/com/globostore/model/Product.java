package com.globostore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Maps Product DB details
 * @author jyengk
 *
 */
@Entity
public class Product extends BaseModel{
	
	@Id
	private char id;
	
	private String name;
	
	private String category;
	
	private Double unitPrice;
	
	private Boolean active;
	
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
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", unitPrice=" + unitPrice
				+ ", active=" + active + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
}
