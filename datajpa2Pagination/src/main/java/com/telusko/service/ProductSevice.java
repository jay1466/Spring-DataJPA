package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<Product> fetchProductInfoSorting(Boolean status, String... Properties) {
		
		//We have to pass sort object in the findall mathod so we create this and based on user input we perfom sorting		
		
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, Properties);
		return repo.findAll(sort);
		
	 
	}

	@Override
	public Iterable<Product> fetchProductByPagination(int pgNo, int pgSize, Boolean status, String... Properties) {
		
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, Properties);
		PageRequest pageable=PageRequest.of(pgNo, pgSize, sort);
		
		
		Page<Product> page =  repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchProductByPagination(int pgSize) {
		
		long count=6l;  //in this we dont neeed to hardcoded count . use count method of Crud Repository
		long pageCount = count/pgSize; // ==> 12 (record) / 3 (Page SIze (in one page how many record)) = 4 Page
		// 14/5 ==>2.8==> 2 ==>3 //in if size is 5 and in 2 page 14 record will not fit so minimun page required is 3 for this
		//14%5 == 0 ? increment pageCount
		//14%2 == 0 ?keep as it is pagecount
		
		pageCount = count % pgSize == 0 ? pageCount : ++pageCount;

		for(int i=0; i<pageCount; i++) {
			PageRequest pageable = PageRequest.of(i, pgSize);
			
			Page<Product> page = repo.findAll(pageable);
			
			page.getContent().forEach(p -> System.out.println(p));
			
			System.out.println("*************************************************");
			
		}
	}
	
	
}
 