package com.globostore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globostore.model.Promotion;
import com.globostore.repository.PromotionRepository;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	public PromotionRepository repository;
	
	@Override
	public List<Promotion> getActivePromotions() {
		return repository.findByActive(true);
	}

}
