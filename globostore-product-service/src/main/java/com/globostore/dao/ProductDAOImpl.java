package com.globostore.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.globostore.model.Product;

/**
 * Services the product related functionalities to the client.
 * @author jyengk
 *
 */
public class ProductDAOImpl implements ProductDAO {
	
	private static final Map<Character, Product> productDetails = new HashMap<>();
	
	static{
		String products = "ABCDEFGHIJKLMNOPQRSTUVWZYZ";
		for(int i = 0 ; i < products.length() ; i++){
			productDetails.put(products.charAt(i), new Product());
		}
	}
	
	/**
	 * TODO Check if the client should handle exceptions or if we should be handling them and returning null
	 * Fetch the details of the product
	 * @param Character productId
	 * @return Product
	 */
	@Override
	public Product getProductDetails(Character productId) {
		if(MapUtils.isNotEmpty(productDetails)){
			return productDetails.get(productId);
		}
		return null;
	}
	
}
