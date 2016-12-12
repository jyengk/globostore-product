package com.globostore.dao;

import java.util.List;

import com.globostore.model.Promotion;

/**
 * Specifies the database functions executable on Promotion DB on implementing this interface.
 * @author jyengk
 *
 */
public interface PromotionDAO {
	
	/**
	 * Fetch all the promotions which are active for that particular product
	 * @param Character productId
	 * @return List<Promotion>
	 */
	public List<Promotion> getActiveProductPromotion(Character productId);
}
