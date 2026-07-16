package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;

@Service
public class ProductSevice implements IProductService {

	@Autowired
	private IProductRepo repo;

	@Override
	public List<Product> searchByPrice(Double price) {
		
		return repo.findByPrice(price);
	}

	@Override
	public List<Product> searchByPriceIs(Double price) {

		return repo.findByPriceIs(price);
	}

	@Override
	public List<Product> searchByPriceEquals(Double price) {

		return repo.findByPriceEquals(price);
	}

	@Override
	public List<Product> searchByPriceGreaterThan(Double price) {
		return repo.findByPriceGreaterThan(price);
	}

	@Override
	public List<Product> searchByPriceLessThan(Double price) {
		
		return repo.findByPriceLessThan(price);
	}

	@Override
	public List<Product> searchByPriceBetween(Double minPrice, Double maxPrice) {
		
		return repo.findByPriceBetween(minPrice, maxPrice);
	}

	@Override
	public List<Product> searchByCategoryEquals(String category) {
		
		return repo.findByCategoryEquals(category);
	}

	@Override
	public List<Product> searchByCategoryInAndPriceBetween(List<String> categories, Double minPrice, Double maxPrice) {
		return repo.findByCategoryInAndPriceBetween(categories, minPrice, maxPrice);
	}

	

	
	
	
}
 