package com.globostore.client.service.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.globostore.client.service.model.PromotionDTO;

/**
 * Service to access restful services via an http client for obtaining discounts
 * @author jyengk
 *
 */
public class PromotionHttpClientImpl implements PromotionClient<Character, PromotionDTO>{
	
	private RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/";
	
	@Override
	public List<PromotionDTO> getActivePromotions() {
		ResponseEntity<PromotionDTO[]> responseEntity = restTemplate.getForEntity(url, PromotionDTO[].class);
		PromotionDTO[] promotions = responseEntity.getBody();
		return Arrays.asList(promotions);
	}
	
	//TODO - To be completed
	@Override
	public List<PromotionDTO> getActivePromotionByProductIds(List<Character> productIds) {
		return null;
	}
	
	//TODO - To be completed
	@Override
	public Map<Character, PromotionDTO> getActivePromotionsPerProductId(List<Character> productIds) {
		return null;
	}

}
