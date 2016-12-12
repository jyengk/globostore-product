package com.globostore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.globostore.enums.DiscountTypeEnum;

/**
 * Model object for Discount DB details
 * @author jyengk
 *
 */
@Entity
public class Discount extends BaseModel{
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@Enumerated(EnumType.STRING)
	private DiscountTypeEnum type;
	
	private Integer count;
	
	//The amount by which the value has to be discounted. It can be in form of the price discount or percentage.
	private Double amount;
	
	@Temporal(TemporalType.DATE)
	private Date effectiveDate;
	
	@Temporal(TemporalType.DATE)
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
		return "Discount [id=" + id + ", name=" + name + ", type=" + type + ", count=" + count + ", amount=" + amount
				+ ", effectiveDate=" + effectiveDate + ", endDate=" + endDate + "]";
	}
	
}
