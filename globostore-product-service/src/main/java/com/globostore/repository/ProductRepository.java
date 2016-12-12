package com.globostore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globostore.model.Product;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Character> {
	public Product findById(Character id);
}
