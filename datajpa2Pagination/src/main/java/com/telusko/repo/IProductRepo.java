package com.telusko.repo;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;

@Repository // Optional if you write there is one benefit readability and maintainability only 
public interface IProductRepo extends PagingAndSortingRepository<Product, Integer> {

}
 