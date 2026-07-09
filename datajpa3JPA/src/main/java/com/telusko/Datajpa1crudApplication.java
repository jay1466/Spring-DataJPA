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
		
//		System.out.println(service.searchProductById(52));
//		
//		List<Integer> ids = Arrays.asList(2,53,3,4);
//		service.searchProductsByIds(ids).forEach(p->System.out.println(p));
//		
		
		//System.out.println(service.searchProductByProductInfo(new Product("Watch", "Accessories", 5000.0, 50)));
		
		
		List<Integer> ids = Arrays.asList(5,52,55);
		
		//1st method that create query for each record separately mena for deleting 3 record 3 query will be generated
//		String status = service.deleteproductsByIdsCrud(ids);
		
		
		//2nd method form JPA repo. only one query will be generated wheather there is n no. of record want to delete
		String status = service.deleteproductsByIds(ids);
	}

}	
