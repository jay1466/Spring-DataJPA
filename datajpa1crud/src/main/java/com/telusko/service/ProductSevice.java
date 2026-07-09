package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;

@Service
public class ProductSevice implements IProductService {

	@Autowired
	private IProductRepo repo;
	
	@Override
	public String saveProduct(Product product) {
				
		Product pd = repo.save(product);
		
		return "Product Stored with id" + pd.getId();
	}

	@Override
	public Iterable<Product> saveMultipleProducts(Iterable<Product> products) {

		
		return repo.saveAll(products);
	}

	@Override
	public Iterable<Product> getAllProducts() {
		
		return repo.findAll();
		
	}

	@Override
	public Iterable<Product> getAllProductsByIds(List<Integer> ids) {
		
		return repo.findAllById(ids);
	}

	@Override
	public Product getProductById(Integer id) {

		Optional<Product> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return new Product();
		}

	}

	@Override
	public Boolean isProductAvailable(Integer id) {
		
		
		return repo.existsById(id);
		
	}

	@Override
	public Long getTotalProductsCont() {
		
		return repo.count();
		
	}

	@Override
	public String deleteProductById(Integer id) {
	
		Optional<Product> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			repo.deleteById(id);
		
			return "Product with id "+ id +" is deleted";
		}
		else {
			return "Product with id "+ id +" is not in the list";
		}
		
	}

	@Override
	public String deleteproductsByIds(List<Integer> ids) {
		
		List<Product> products = (List<Product>) repo.findAllById(ids);
		
		// 1st type -> where if one records are not there then no one will delete
		
		if(products.size()!=0) {
			repo.deleteAllById(ids);
			return "records deleted successfully";
		}
		else {
			return "Product Info with given ids are not in records to delete";
		}
		
		//2nd type -> ignore that that id whose record is not available
		
//		if(products.size()==ids.size()) {
//			repo.deleteAllById(ids);
//			return "records deleted successfully";
//		}
//		else {
//			return "Product Info with given ids are not in records to delete";
//		}
		
	}
}
