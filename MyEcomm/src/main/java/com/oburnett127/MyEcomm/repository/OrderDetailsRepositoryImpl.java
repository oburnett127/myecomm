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
import com.oburnett127.MyEcomm.model.OrderDetails;
import com.oburnett127.MyEcomm.repository.util.OrderDetailsRowMapper;

@Repository("orderDetailsRepository")
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public OrderDetails createOrderDetails(OrderDetails orderDetails) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("orderId", orderDetails.getOrderId());
		data.put("productId", orderDetails.getProductId());
		data.put("quantity", orderDetails.getQuantity());
		
		List<String> columns = new ArrayList<>();
		columns.add("orderId");
		columns.add("productId");
		columns.add("quantity");
		
		insert.setTableName("orderDetails");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		return getOrderDetails(id.intValue());
	}
	
	@Override
	public OrderDetails getOrderDetails(Integer id) {
		OrderDetails orderDetails = jdbcTemplate.queryForObject("select * from orderdetails where orderId = ?", new OrderDetailsRowMapper(), id);
		
		return orderDetails;
	}
	
	@Override
	public List<OrderDetails> getOrdersDetails() {
		List<OrderDetails> orderDetails = jdbcTemplate.query("select * from orderdetails", new OrderDetailsRowMapper());
		
		return orderDetails;
	}
	
	@Override
	public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
		jdbcTemplate.update("update orderDetails set quantity = ? where orderId = ? and productId = ?", 
				orderDetails.getQuantity(), orderDetails.getOrderId(), orderDetails.getProductId());
		
		return orderDetails;
	}
	
	//I am making the assumption that when the last OrderDetails record for an order is deleted, the order should not be deleted
	//Delete a single record in the orderdetails table
	@Override
	public void deleteSingleOrderDetails(Integer orderId, Integer productId) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("orderid", orderId);
		paramMap.put("productid", productId);
		
		namedTemplate.update("delete from orderdetails where orderId = :orderid and product = :productid", paramMap);
	}
	
	//I am making the assumption that when the last OrderDetails record for an order is deleted, the order should not be deleted
	//Delete all records in orderdetails table for a given order
	@Override
	public void deleteAllOrderDetails(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from orderdetails where orderId = :id", paramMap);
	}
}