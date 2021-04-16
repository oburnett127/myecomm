package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.service.BillingInfoServiceImpl;
import com.oburnett127.MyEcomm.service.OrderDetailsServiceImpl;
import com.oburnett127.MyEcomm.model.Order;
import com.oburnett127.MyEcomm.model.OrderDetails;

public class OrderRowMapper implements RowMapper<Order> {
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderId(rs.getInt("orderId"));
		order.setUserId(rs.getInt("userId"));
		order.setOrderDate(rs.getString("orderDate"));
		
		OrderDetails orderDetails = new OrderDetails();
		OrderDetailsServiceImpl orderDetailsServiceImpl = new OrderDetailsServiceImpl();
		orderDetailsServiceImpl.getOrderDetails(order.getOrderId());
		BillingInfo billingInfo = new BillingInfo();
		BillingInfoServiceImpl billingInfoServiceImpl = new BillingInfoServiceImpl();
		billingInfoServiceImpl.getBillingInfo(order.getOrderId());
		
		return order;
	}
}
