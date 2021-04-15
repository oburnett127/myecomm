package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.Product;

public interface ProductService {

	Product createProduct(Product Product);
	
	List<Product> getProducts();
	
	Product getProduct(Integer id);

	Product updateProduct(Product Product);

	void deleteProduct(Integer id);

}