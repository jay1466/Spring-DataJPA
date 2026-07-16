package com.telusko.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.telusko.entity.Product;

public interface IProductService {

	public List<Product> findByCategory(@Param(":category")String cat);
		
	public List<String> findByPrice(Double minPrice, Double maxPrice);
	
	public int updatePriceByProductName(Double newPrice, String productName);
}
