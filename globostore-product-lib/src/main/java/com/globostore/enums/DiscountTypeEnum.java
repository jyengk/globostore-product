package com.globostore.enums;

/**
 * Discount types being either direct discount or percentage type discount
 * @author jyengk
 *
 */
public enum DiscountTypeEnum {
	DIRECT('D', "Discount by value"),
	PERCENTAGE('P', "Discount by percentage");
	
	private Character type;
	private String description;
	
	private DiscountTypeEnum(Character type, String description){
		this.type = type;
		this.description = description;
	}
	
	public Character type(){
		return type;
	}
	
	public String description(){
		return description;
	}
}
