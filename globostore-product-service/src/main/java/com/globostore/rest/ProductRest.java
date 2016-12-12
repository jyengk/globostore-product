package com.globostore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globostore.model.Product;
import com.globostore.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductRest {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Product findByProductId(@PathVariable Character id) throws Exception{
		return productService.getProductDetails(id);
	}
}
