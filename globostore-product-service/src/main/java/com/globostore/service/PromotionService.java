package com.globostore.service;

import java.util.List;

import com.globostore.model.Promotion;

public interface PromotionService {
	List<Promotion> getActivePromotions();
}
