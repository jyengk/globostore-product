package com.globostore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.globostore.model.Promotion;

@Repository
@Transactional
public interface PromotionRepository extends CrudRepository<Promotion, Long>{
	public List<Promotion> findByActive(Boolean flag);
}
