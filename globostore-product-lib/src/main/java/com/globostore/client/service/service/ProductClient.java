package com.globostore.client.service.service;

import java.util.List;

/**
 * Interface to be implemented for interfacing the backend services for fetching the 
 * product details
 * @author jyengk
 *
 */
public interface ProductClient<T,R> {
	
	/**
	 * Find a product by the provided product id
	 * @param productId
	 * @return R
	 */
	public R findProductByProductId(T productId);
	
	/**
	 * Find the product details of all the product Ids provided in the list
	 * @param productIds
	 * @return List<R>
	 */
	public List<R> findProducts(List<T> productIds);
}
