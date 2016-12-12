package com.globostore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 * Maps the Promotion db details
 * @author jyengk
 *
 */
@Entity
public class Promotion extends BaseModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Product product;
	
	@OneToOne
	@JoinTable(name = "id")
	private Discount dicount;
	
	private Boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Discount getDicount() {
		return dicount;
	}
	public void setDicount(Discount dicount) {
		this.dicount = dicount;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", product=" + product + ", dicount=" + dicount + ", active=" + active + "]";
	}
	
}
