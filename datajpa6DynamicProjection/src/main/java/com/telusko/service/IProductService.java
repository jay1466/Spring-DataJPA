package com.telusko.service;

import java.util.List;

import com.telusko.entity.Product;
import com.telusko.view.View;


public interface IProductService {

	<T extends View>List<T> searchByPriceLessThan(Double price, Class<T> cls);
}
