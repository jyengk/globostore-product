package com.globostore.client.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globostore.client.service.model.DiscountDTO;
import com.globostore.client.service.model.ProductDTO;
import com.globostore.client.service.model.PromotionDTO;
import com.globostore.client.service.service.ProductClient;
import com.globostore.client.service.service.PromotionClient;
import com.globostore.enums.DiscountTypeEnum;

/**
 * Checkout implementation class for allowing product scanning during checkout and amount calculation.
 * @author jyengk
 *
 */
public class CheckoutImpl implements Checkout<Character>{
	
	private final Logger logger = LoggerFactory.getLogger(CheckoutImpl.class);
	
	private Map<Character, Integer> scannedProductsCountMap = new HashMap<>();
	private PromotionClient<Character, PromotionDTO> promotionClient;
	private ProductClient<Character, ProductDTO> productClient;
	
	
	/**
	 * Add the scanned product ID and add the count of the same products into a map;
	 * @param Character productId
	 */
	public void scan(Character productId) {
		
		logger.debug("Scanned product with id :" + productId);
		System.out.println("Scanned product with id :" + productId);
		int count  = 1;
		if(scannedProductsCountMap.containsKey(productId)){
			count = scannedProductsCountMap.get(productId);
			count++;
			logger.debug("Count of the product " + productId + " increased to "+ count);
		}
		//Add count of scanned products
		scannedProductsCountMap.put(productId, count);
	}
	
	
	/**
	 * Calculate the final amount applicable for the checked out items on the basis of discounts etc.
	 * TODO - Validation and Exception need to be handled
	 * @return Double amount to be paid
	 */
	public Double amount() {

		List<Character> productIds = new ArrayList<>(scannedProductsCountMap.keySet());
		
		if(CollectionUtils.isNotEmpty(productIds)){
			
			Map<Character, PromotionDTO> activePromotions=  promotionClient.getActivePromotionsPerProductId(productIds);
			List<ProductDTO> products = productClient.findProducts(productIds);
			Double actualTotal = 0.00;
			Double discountAmountTotal = 0.00;
			
			//Loop to calculate the discount and the final price amount
			for(ProductDTO product : products){
				logger.debug("Product details  :" + product);
				System.out.println("Product details  :" + product);
				Character productId = product.getId();
				Integer scannedProductCount = scannedProductsCountMap.get(productId);
				actualTotal = actualTotal + (product.getUnitPrice() * scannedProductsCountMap.get(productId));
				System.out.println("actualTotal :" +actualTotal);
				
				if(MapUtils.isNotEmpty(activePromotions) 
						&& activePromotions.get(productId) != null 
						&& activePromotions.get(productId).getDiscount() != null){
					
					PromotionDTO activePromotion = activePromotions.get(productId);
					
					//Fetch discount details for this promotion
					DiscountDTO discount = activePromotion.getDiscount();
					DiscountTypeEnum discountType = discount.getType();
					Double discountAmount = discount.getAmount();
					int discountItemCount = discount.getCount();
					
					//Calculate the number of items on which this discount is applicable on.
					Integer appllicatbleCountProductDiscount = scannedProductCount / discountItemCount;
					
					if(discountType.equals(DiscountTypeEnum.PERCENTAGE)){
						discountAmountTotal = + (appllicatbleCountProductDiscount * product.getUnitPrice() * discountAmount * .01);
					}
					else{
						discountAmountTotal = + (appllicatbleCountProductDiscount * discountAmount);
					}
					System.out.println("discountAmountTotal :" +discountAmountTotal);
				}
			}
			return actualTotal - discountAmountTotal; 
		}
		
		return null;
	}
	
	public void setPromotionClient(PromotionClient<Character, PromotionDTO> promotionClient) {
		this.promotionClient = promotionClient;
	}

	public void setProductClient(ProductClient<Character, ProductDTO> productClient) {
		this.productClient = productClient;
	}

	public Map<Character, Integer> getScannedProductsCountMap() {
		return scannedProductsCountMap;
	}
	
}
