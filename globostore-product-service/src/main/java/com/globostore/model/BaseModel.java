package com.globostore.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BaseModel {
	
	@Temporal(TemporalType.DATE)
	protected Date createdDate;
	
	@Temporal(TemporalType.DATE)
	protected Date modifiedDate;
	
	protected String createdBy;
	
	protected String updatedBy;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
}
