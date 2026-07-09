package com.telusko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.entity.Product;
import com.telusko.service.IProductService;

@SpringBootApplication
public class Datajpa1crudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Datajpa1crudApplication.class, args);
		
		IProductService service = container.getBean(IProductService.class);
		
		
		// 1st part for storing single product at a time
		
//		Product product1 = new Product("Laptop", "Electronics", 75000.0, 20);
//		
//		
//		System.out.println ( service.saveProduct(product1) );
		
		// 2nd part for Storing multiple product
		
		
		List<Product> products = new ArrayList<>();
		products.add(new Product("Mobile", "Electronics", 10000.0, 30));
		products.add(new Product("Watch", "Accessories", 5000.0, 50));
		products.add(new Product("Shoes", "Fashion", 500.0, 60));
		products.add(new Product("Books", "Stationary", 1000.0, 10));
//
//		
		service.saveMultipleProducts(products).forEach(p -> System.out.println(p));
		
		//3rd part Retrieval
		
		service.getAllProducts().forEach(p->System.out.println(p));
		
		
		//4th Part
//		List<Integer> ids = Arrays.asList(2,4,1);
//		service.getAllProductsByIds(ids).forEach(p->System.out.println(p));
		
		
		//System.out.println(service.getProductById(3));
		
		
		//5th part
//		
//		System.out.println("Total Products Count " +  service.getTotalProductsCont());
//		
//		Boolean status = service.isProductAvailable(8);
//		
//		if(status) {
//			System.out.println("Product Available");
//		}
//		else {
//			System.out.println("Product Not Available");
//		}
		
		//6th part
		
//		int id =8;
//		System.out.println(service.deleteProductById(id));
//		
//		List<Integer> ids = Arrays.asList(2,4,1);
//		String status = service.deleteproductsByIds(ids);
//		
//		System.out.println(status);
	}

}
