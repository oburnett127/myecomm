package com.oburnett127.MyEcomm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.createProduct(product);
	}
	
	@Override
	public Product getProduct(Integer id) {
		return productRepository.getProduct(id);
	}
	
	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	@Override
	public Product updateProduct(Product product) {
		return productRepository.updateProduct(product);
	}
	
	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteProduct(id);
	}
}