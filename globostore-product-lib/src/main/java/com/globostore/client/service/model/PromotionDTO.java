package com.globostore.client.service.model;

/**
 * DTO object to handle promotion details.
 * @author jyengk
 *
 */
public class PromotionDTO {
	
	private Long id;
	private ProductDTO product;
	private DiscountDTO discount;
	private Boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public DiscountDTO getDiscount() {
		return discount;
	}
	public void setDiscount(DiscountDTO discount) {
		this.discount = discount;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "PromotionDTO [id=" + id + ", product=" + product + ", discount=" + discount + ", active=" + active
				+ "]";
	}
}
