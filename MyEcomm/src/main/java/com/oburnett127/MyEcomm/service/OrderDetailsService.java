package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.OrderDetails;

public interface OrderDetailsService {

	OrderDetails createOrderDetails(OrderDetails OrderDetails);
	
	List<OrderDetails> getOrdersDetails();
	
	OrderDetails getOrderDetails(Integer id);

	OrderDetails updateOrderDetails(OrderDetails OrderDetails);

	void deleteOrderDetails(Integer id);

}