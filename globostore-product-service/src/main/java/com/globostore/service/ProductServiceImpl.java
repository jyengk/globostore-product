package com.globostore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globostore.model.Product;
import com.globostore.repository.ProductRepository;

/**
 * Product creation for the user 
 * @author jyengk
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductRepository repository;
	
	@Override
	public Product getProductDetails(Character id) {
		return repository.findOne(id);
	}

}
