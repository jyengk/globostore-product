package com.globostore.client.service.service;

import java.util.List;
import java.util.Map;

/**
 * Interface to be implemented for interfacing the backend services for fetching the 
 * discount details
 * @author jyengk
 *
 * @param <T> The object type to be provided to fetch the details
 * @param <R> The object type to be obtained
 */
public interface PromotionClient<T, R> {
	
	/**
	 * Fetch all active discounts
	 * @return List<R>
	 */
	public List<R> getActivePromotions();
	
	/**
	 * Fetch all the active discounts filtered by the product IDs
	 * @param productIds
	 * @return
	 */
	public List<R> getActivePromotionByProductIds(List<T> productIds);
	
	/**
	 * Find the map of active promotions by product id
	 * @param productIds
	 * @return
	 */
	public Map<T, R> getActivePromotionsPerProductId(List<T> productIds);
}
