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
		
//		service.searchByPrice(5000.0).forEach(p->System.out.println(p));
//		service.searchByPriceIs(5000.0).forEach(p->System.out.println(p));
//		service.searchByPriceEquals(5000.0).forEach(p->System.out.println(p));
		
//		service.searchByPriceGreaterThan(6000.0).forEach(p->System.out.println(p));
//		service.searchByPriceLessThan(6000.0).forEach(p->System.out.println(p));
//		
//		service.searchByPriceBetween(501.0, 11000.0).forEach(p->System.out.println(p));

//		service.searchByCategoryEquals("Accessories").forEach(p->System.out.println(p));
		
		
		
		List<String> categories = Arrays.asList("Electronics","Accessories");
		service.searchByCategoryInAndPriceBetween(categories, 6000.0, 10000.0).forEach(p->System.out.println(p));
		
	}
}	
