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
import com.telusko.view.View;


@Service
public class ProductSevice implements IProductService {

	@Autowired
	private IProductRepo repo;

	@Override
	public <T extends View> List<T> searchByPriceLessThan(Double price, Class<T> cls) {
		
		return repo.findByPriceLessThan(price, cls);
	}

	
	
	
	
	
}
 