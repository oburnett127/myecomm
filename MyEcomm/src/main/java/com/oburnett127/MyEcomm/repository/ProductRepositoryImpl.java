package com.oburnett127.MyEcomm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.repository.util.ProductRowMapper;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Product createProduct(Product product) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("name", product.getName());
		data.put("description", product.getDescription());
		data.put("unitPrice", product.getUnitPrice());
		data.put("unitsInStock", product.getUnitsInStock());
		
		List<String> columns = new ArrayList<>();
		columns.add("name");
		columns.add("description");
		columns.add("unitPrice");
		columns.add("unitsInStock");
		
		insert.setTableName("product");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		return getProduct(id.intValue());
	}
	
	@Override
	public Product getProduct(Integer id) {
		Product product = jdbcTemplate.queryForObject("select * from product where id = ?", new ProductRowMapper(), id);
		return product;
	}
	
	@Override
	public List<Product> getProducts() {
		List<Product> products = jdbcTemplate.query("select * from product", new ProductRowMapper());
		return products;
	}
	
	@Override
	public Product updateProduct(Product product) {
		jdbcTemplate.update("update product set name = ?, description = ?, unitPrice = ?, unitsInStock = ? where id = ?", 
				product.getName(), product.getDescription(), product.getUnitPrice(), product.getUnitsInStock(), product.getId());
		return product;
	}
	
	@Override
	public void deleteProduct(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from product where id = :id", paramMap);
	}
}