package com.globostore.client.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.globostore.client.service.model.ProductDTO;
import com.globostore.client.service.model.PromotionDTO;
import com.globostore.client.service.service.ProductClient;
import com.globostore.client.service.service.PromotionClient;
import com.globostore.util.ModelAssemblerUtil;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutImplTest {
	
	@Mock
	public PromotionClient<Character, PromotionDTO> promotionClient;
	
	@Mock
	public ProductClient<Character, ProductDTO> productClient;
	
	@InjectMocks
	public CheckoutImpl checkout = new CheckoutImpl();
	
	@Before
	public void setUp(){
	}
	
	@After
    public void tearDown() {
		promotionClient = null;
		productClient = null;
		checkout = null;       
    }
	
	/**
	 * Verify if the scanned value is being added correctly with the correct count.
	 */
	@Test
	public void testScan(){
		Character[] products = {'A','B','A','A'};
		for(Character id : products){
			checkout.scan(id);
		}
		assertTrue(checkout.getScannedProductsCountMap().size() == 2);
		assertTrue(checkout.getScannedProductsCountMap().get('A') == 3);
		assertTrue(checkout.getScannedProductsCountMap().get('B') == 1);
	}
	
	/**
	 * Verify the discount amount is correct for multiple odd numbered product checkout
	 */
	@Test
	public void testAmountForDuplicateDiscountableProducts(){
		Character[] products = {'A','A','A','A','A','A','A','A'};
		when(promotionClient.getActivePromotionsPerProductId(any(List.class)))
						.thenReturn(ModelAssemblerUtil.buildPrmotions(Arrays.asList(products)));
		when(productClient.findProducts(any(List.class))).thenReturn(ModelAssemblerUtil.buildProducts(Arrays.asList(products)));
		
		for(Character id : products){
			checkout.scan(id);
		}
		Double totalAmount = checkout.amount();
		System.out.println("totalAmount : "+totalAmount);
		assertTrue(totalAmount.equals(140.00));
		
	}
	
	/**
	 * Verify the discount amount is correct for multiple even numbered product checkout
	 */
	@Test
	public void testAmountForMultipleDuplicateDiscountableProducts(){
		Character[] products = {'A','A','A','B','B'};
		when(promotionClient.getActivePromotionsPerProductId(any(List.class)))
						.thenReturn(ModelAssemblerUtil.buildPrmotions(Arrays.asList(products)));
		when(productClient.findProducts(any(List.class))).thenReturn(ModelAssemblerUtil.buildProducts(Arrays.asList(products)));
		
		for(Character id : products){
			checkout.scan(id);
		}
		Double totalAmount = checkout.amount();
		System.out.println("totalAmount : "+totalAmount);
		assertTrue(totalAmount.equals(75.00));
	}
	
	/**
	 * Verify the discount amount is correct for multiple duplicate product checkout.
	 * The count of the products should be more than or less than the discountable product count
	 */
	@Test
	public void testAmountForMultipleProducts(){
		Character[] products = {'A','A','A','B','B','A','B'};
		when(promotionClient.getActivePromotionsPerProductId(any(List.class)))
						.thenReturn(ModelAssemblerUtil.buildPrmotions(Arrays.asList(products)));
		when(productClient.findProducts(any(List.class))).thenReturn(ModelAssemblerUtil.buildProducts(Arrays.asList(products)));
		
		for(Character id : products){
			checkout.scan(id);
		}
		Double totalAmount = checkout.amount();
		System.out.println("totalAmount : "+totalAmount);
		assertTrue(totalAmount.equals(105.00));
	}
	
	/**
	 * Verify no discount is provided for products without promotions
	 */
	@Test
	public void testAmountForMultipleNonDiscountableProducts(){
		Character[] products = {'C','D','E'};
		when(promotionClient.getActivePromotionsPerProductId(any(List.class)))
						.thenReturn(null);
		when(productClient.findProducts(any(List.class))).thenReturn(ModelAssemblerUtil.buildProducts(Arrays.asList(products)));
		
		for(Character id : products){
			checkout.scan(id);
		}
		Double totalAmount = checkout.amount();
		System.out.println("totalAmount : "+totalAmount);
		assertTrue(totalAmount.equals(90.00));
	}
	
	/**
	 * Negative test case scenario to check that NULL is returned in case no scanning of products have been done.
	 */
	@Test
	public void testForNullAmountForUnscannedProducts(){
		Double totalAmount = checkout.amount();
		assertNull(totalAmount);
	}
	
	
}
