package com.globostore.client.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.globostore.client.service.model.ProductDTO;

public class ProductHttpClientImpl implements ProductClient<Character, ProductDTO>{
	
	private RestTemplate restTemplate = new RestTemplate();
	String uri ="http://loclahost:8080/products/{id}";

	@Override
	public ProductDTO findProductByProductId(Character productId) {
		Map<String, String> params = new HashMap<>();
	    params.put("id", "1");
	    ProductDTO product = restTemplate.getForObject(uri, ProductDTO.class, params);
	    return product;
	}

	@Override
	public List<ProductDTO> findProducts(List<Character> productIds) {
		// TODO Auto-generated method stub
		return null;
	}
}
