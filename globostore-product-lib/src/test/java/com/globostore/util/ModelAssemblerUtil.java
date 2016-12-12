package com.globostore.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.globostore.client.service.model.DiscountDTO;
import com.globostore.client.service.model.ProductDTO;
import com.globostore.client.service.model.PromotionDTO;
import com.globostore.enums.DiscountTypeEnum;

/**
 * Util class for building various promotion sna product features for testing.
 * @author jyengk
 *
 */
public class ModelAssemblerUtil {
	
	public static final double UNIT_PRICE_A = 20.00;
	public static final double UNIT_PRICE_B = 10.00;
	public static final double DISCOUNT_PRICE_A = 10.00;
	public static final double DISCOUNT_PRICE_B = 5.00;
	public static final double UNIT_PRICE_DEFAULT = 30.00;
	public static final double DISCOUNT_PRICE_DEFAULT = 20.00;
	public static final int DISCOUNT_ITEM_COUNT_A = 3;
	public static final int DISCOUNT_ITEM_COUNT_B = 2;
	public static final int DISCOUNT_ITEM_COUNT_DEFAULT = 4;
	
	public static List<ProductDTO> buildProducts(List<Character> productIds){
		List<ProductDTO> products = new ArrayList<>();
		Set<Character> ids = new HashSet<>(productIds);
		for(Character id : ids){
			products.add(buildProductDTO(id));
		}
		return products;
	}
	
	public static Map<Character, PromotionDTO> buildPrmotions(List<Character> productIds){
		Map<Character, PromotionDTO> promotions = new HashMap<>();
		Set<Character> ids = new HashSet<>(productIds);
		for(Character id : ids){
			ProductDTO pdtDto = buildProductDTO(id);
			DiscountDTO discountDTO = buildDiscountDTOForProduct(id);
			PromotionDTO promotionDto = new PromotionDTO();
			promotionDto.setActive(true);
			promotionDto.setDiscount(discountDTO);
			promotionDto.setProduct(pdtDto);
			promotions.put(id, promotionDto);
		}
		
		return promotions;
	}
	
	public static ProductDTO buildProductDTO(char id){
		ProductDTO dto = new ProductDTO();
		dto.setId(id);
		dto.setCategory(id + "_CATEGORY");
		dto.setName(id +"");
		switch(id){
			case 'A' :
				dto.setUnitPrice(UNIT_PRICE_A);
				break;
			case 'B':
				dto.setUnitPrice(UNIT_PRICE_B);
				break;
			default:
				dto.setUnitPrice(UNIT_PRICE_DEFAULT);
		}
		
		return dto;
	}
	
	public static DiscountDTO buildDiscountDTOForProduct(char id){
		
		DiscountDTO dto = new DiscountDTO();
		dto.setEffectiveDate(new Date());
		dto.setEndDate(new Date());
		dto.setName(id + "");
		dto.setType(DiscountTypeEnum.DIRECT);
		
		switch(id){
			case 'A' :
				dto.setAmount(DISCOUNT_PRICE_A);
				dto.setCount(DISCOUNT_ITEM_COUNT_A);
				break;
			case 'B':
				dto.setAmount(DISCOUNT_PRICE_B);
				dto.setCount(DISCOUNT_ITEM_COUNT_B);
				break;
			default:
				dto.setAmount(DISCOUNT_PRICE_DEFAULT);
				dto.setCount(DISCOUNT_ITEM_COUNT_DEFAULT);
		}
		
		return dto;
	}
	
	
}
