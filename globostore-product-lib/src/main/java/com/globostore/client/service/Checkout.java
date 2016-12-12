package com.globostore.client.service;

/**
 * Interface providng checkout features.
 * 
 * @author jyengk
 *
 * @param <T>
 */
public interface Checkout<T> {
	
	public void scan(T t);
	public Double amount();

}
