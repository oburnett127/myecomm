package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.service.OrderDetailsServiceImpl;
import com.oburnett127.MyEcomm.model.Order;
import com.oburnett127.MyEcomm.model.OrderDetails;

public class OrderDetailsRowMapper implements RowMapper<OrderDetails> {
	@Override
	public OrderDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(rs.getInt("orderId"));
		orderDetails.setProductId(rs.getInt("productId"));
		orderDetails.setQuantity(rs.getInt("quantity"));
		
		return orderDetails;
	}
}
