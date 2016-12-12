package com.globostore.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globostore.model.Promotion;
import com.globostore.service.PromotionService;

@RestController
@RequestMapping(path = "/promotions")
public class PromotionRest {
	
	@Autowired
	private PromotionService promotionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Promotion> findActivePromotions() throws Exception{
		return promotionService.getActivePromotions();
	}

}
