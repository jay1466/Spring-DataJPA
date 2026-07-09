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
	public Product searchProductById(Integer id) {
	
		return repo.getReferenceById(id);
		
	}

	@Override
	public List<Product> searchProductsByIds(Iterable<Integer> ids) {
		
		return repo.findAllById(ids);
		
	}

	@Override
	public List<Product> searchProductByProductInfo(Product product) {
		
		Example<Product> example = Example.of(product);
		
		return repo.findAll(example);
		
	}


	@Override
	public String deleteproductsByIdsCrud(List<Integer> ids) {
		List<Product> products = (List<Product>) repo.findAllById(ids);
		
		// 1st type -> where if one records are not there then no one will delete
		
		if(products.size()!=0) {
			repo.deleteAllById(ids);
			return "records deleted successfully";
		}
		else {
			return "Product Info with given ids are not in records to delete";
		}
	}
	


	
	@Override
	public String deleteproductsByIds(List<Integer> ids) {
		List<Product> products = (List<Product>) repo.findAllById(ids);
		
		// 1st type -> where if one records are not there then no one will delete
		
		if(products.size()!=0) {
			repo.deleteAllByIdInBatch(ids);
			return "records deleted successfully";
		}
		else {
			return "Product Info with given ids are not in records to delete";
		}
	}

	
	
	
}
 