package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;

public interface IProductService {

	Iterable<Product> fetchProductInfoSorting(Boolean status, String...Properties);
	
	Iterable<Product> fetchProductByPagination(int pgNo, int pgSize,Boolean status, String...Properties); 
	
	//prt 2nd (method 2nd where we only have to give pageSize no need to give pgNo. we can add sorting
	
	// we can use iterable but not have much time for this drama so used void 
	void fetchProductByPagination(int pgSize); 
}
