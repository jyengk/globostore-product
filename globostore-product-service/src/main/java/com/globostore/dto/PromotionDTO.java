package com.globostore.dto;

import org.springframework.stereotype.Component;

/**
 * DTO object to handle promotion details.
 * @author jyengk
 *
 */
@Component
public class PromotionDTO {
	
	private Long id;
	private Character productId;
	private Double productUnitPrice;
	private String discountType;
	private String discountAmount;
	private String discountItemCount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Character getProductId() {
		return productId;
	}
	public void setProductId(Character productId) {
		this.productId = productId;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getDiscountItemCount() {
		return discountItemCount;
	}
	public void setDiscountItemCount(String discountItemCount) {
		this.discountItemCount = discountItemCount;
	}
	public Double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(Double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + ", productUnitPrice=" + productUnitPrice
				+ ", discountType=" + discountType + ", discountAmount=" + discountAmount + ", discountItemCount="
				+ discountItemCount + "]";
	}
	
}
