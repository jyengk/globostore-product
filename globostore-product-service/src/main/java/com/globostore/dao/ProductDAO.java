package com.globostore.dao;

import com.globostore.model.Product;

/**
 * Specifies the database functions executable on Product DB on implementing this interface.
 * @author jyengk
 *
 */
public interface ProductDAO {
	
	/**
	 * Fetch the product details of the provided product id
	 * @param productId
	 * @return Product
	 */
	public Product getProductDetails(Character productId);
	
}
