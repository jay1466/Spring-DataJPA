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
		
		service.findByCategory("Fashion").forEach(p->System.out.println(p));
		
		service.findByPrice(1000.0, 10000.0).forEach(p->System.out.println(p));
		
		
		int count = service.updatePriceByProductName(6000.0, "Watch");

		System.out.println("Rows Updated : " + count);
		
//		System.out.println(service.updatePriceByProductName(6000.0, "Watch"));
	}
}	
