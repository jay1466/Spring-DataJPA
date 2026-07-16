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
	public List<Product> findByCategory(String cat) {
		// TODO Auto-generated method stub
		return repo.searchByCategory(cat);
	}

	@Override
	public List<String> findByPrice(Double minPrice, Double maxPrice) {
		// TODO Auto-generated method stub
		return repo.searchByPrice(minPrice, maxPrice);
	}

	@Override
	public int updatePriceByProductName(Double newPrice, String productName) {
		// TODO Auto-generated method stub
		return repo.updatePriceByProductName(newPrice, productName);
	}

	
	

	
	
	
}
 