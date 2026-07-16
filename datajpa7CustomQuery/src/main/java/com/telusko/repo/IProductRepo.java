package com.telusko.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telusko.entity.Product;

@Repository // Optional if you write there is one benefit readability and maintainability only 
public interface IProductRepo extends JpaRepository<Product,Integer> {

	
	// 1st method ( not actually method)
//	@Query("FROM product where category=:category")
//	public List<Product> searchByCategory(String category);
	
	//when named parameter and variable name(cat) not matching you go with this method
	@Query("FROM Product where category=:category")
	public List<Product> searchByCategory(@Param("category")String cat);
	
	
	
	@Query("SELECT productName, category FROM Product WHERE price BETWEEN :minPrice AND :maxPrice")
	public List<String> searchByPrice(Double minPrice, Double maxPrice);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Product SET price = :newPrice Where productName = :productName")
	public int updatePriceByProductName(Double newPrice, String productName);
	
	
	

	@Transactional
	@Modifying
	@Query(
	    value = """
	            INSERT INTO product
	            (product_name, category, price, quantity)
	            VALUES	
	            (:productName, :category, :price, :quantity)
	            """,
	    nativeQuery = true
	)
	public int insertProductInfo(
			
	        @Param("productName") String productName,
	        @Param("category") String category,
	        @Param("price") Double price,
	        @Param("quantity") Integer quantity
	);
	
}
 	