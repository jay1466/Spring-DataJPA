package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;

public interface IProductService {

	Product searchProductById(Integer id);
	List<Product> searchProductsByIds(Iterable <Integer> ids);
	
	List<Product> searchProductByProductInfo(Product product);
	
	String deleteproductsByIdsCrud(List<Integer> ids);
	
	String deleteproductsByIds(List<Integer> ids);
	
}
