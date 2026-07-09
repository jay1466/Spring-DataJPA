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
		
		//Part 1 : only for sorting
		//service.fetchProductInfoSorting(true, "price").forEach(p->System.out.println(p));
		
//		service.fetchProductByPagination(1, 2, false, "price").forEach(p->System.out.println(p));
		
		service.fetchProductByPagination(2);
		
	}

}
