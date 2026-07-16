package com.telusko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.telusko.entity.Product;
import com.telusko.service.IProductService;
import com.telusko.view.ResultView1;
import com.telusko.view.ResultView2;
import com.telusko.view.ResultView3;

@SpringBootApplication
public class Datajpa1crudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Datajpa1crudApplication.class, args);
		
		IProductService service = container.getBean(IProductService.class);
		

		service.searchByPriceLessThan(1000.0, ResultView1.class).forEach(p->System.out.println(p));
		
	}
}	
