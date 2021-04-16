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
import com.oburnett127.MyEcomm.model.Order;
import com.oburnett127.MyEcomm.repository.util.OrderRowMapper;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Order createOrder(Order order) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("orderId", order.getOrderId());
		data.put("userId", order.getUserId());
		data.put("orderDate", order.getOrderDate());
		
		List<String> columns = new ArrayList<>();
		columns.add("orderId");
		columns.add("userId");
		columns.add("orderDate");
		
		insert.setTableName("order");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		OrderDetailsRepositoryImpl orderDetailsRepositoryImpl = new OrderDetailsRepositoryImpl();
		orderDetailsRepositoryImpl.createOrderDetails(order.getOrderDetails());
		
		BillingInfoRepositoryImpl billingInfoRepositoryImpl = new billingInfoRepositoryImpl();
		billingInfoRepositoryImpl.createBillingInfo(order.getBillingInfo());
		
		return getOrder(id.intValue());
	}
	
	@Override
	public Order getOrder(Integer id) {
		Order order = jdbcTemplate.queryForObject("select * from order where orderId = ?", new OrderRowMapper(), id);
		
		return order;
	}
	
	@Override
	public List<Order> getOrders() {
		List<Order> orders = jdbcTemplate.query("select * from order", new OrderRowMapper());
		
		return orders;
	}
	
	@Override
	public Order updateOrder(Order order) {
		jdbcTemplate.update("update order set orderId = ?, userId = ?, orderDate = ? where orderId = ?", 
				order.getOrderId(), order.getUserId(), order.getOrderDate(), order.getOrderId());
		
		return order;
	}
	
	@Override
	public void deleteOrder(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from order where orderId = :id", paramMap);
	}
}