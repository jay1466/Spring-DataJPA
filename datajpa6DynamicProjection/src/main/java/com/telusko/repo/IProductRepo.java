package com.telusko.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.telusko.entity.Product;

import com.telusko.view.View;

@Repository // Optional if you write there is one benefit readability and maintainability only 
public interface IProductRepo extends JpaRepository<Product,Integer> {

	<T extends View>List<T> findByPriceLessThan(Double price, Class<T> cls);
}
 