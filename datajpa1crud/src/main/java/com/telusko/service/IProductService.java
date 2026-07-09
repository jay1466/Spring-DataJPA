package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;

public interface IProductService {

	public String saveProduct(Product product);
	
	Iterable<Product> saveMultipleProducts(Iterable<Product> products);
	
	Iterable<Product> getAllProducts();
	
	Iterable<Product> getAllProductsByIds(List<Integer> ids);
	
	Product getProductById(Integer id);
	
	Boolean isProductAvailable(Integer id);
	
	Long getTotalProductsCont();
	
	String deleteProductById(Integer id);
	
	String deleteproductsByIds(List<Integer> ids);
	
}
