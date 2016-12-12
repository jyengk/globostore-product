package com.globostore.client.service.model;

import java.util.Date;

import com.globostore.enums.DiscountTypeEnum;

/**
 * DTO object holding details about the various available discounts for the week
 * 
 * @author jyengk
 *
 */
public class DiscountDTO {
	
	private Long id;
	private String name;
	private DiscountTypeEnum type;
	private Integer count;
	private Double amount;
	private Date effectiveDate;
	private Date endDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DiscountTypeEnum getType() {
		return type;
	}
	public void setType(DiscountTypeEnum type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "DiscountDTO [id=" + id + ", name=" + name + ", type=" + type + ", count=" + count + ", amount=" + amount
				+ ", effectiveDate=" + effectiveDate + ", endDate=" + endDate + "]";
	}
	
}