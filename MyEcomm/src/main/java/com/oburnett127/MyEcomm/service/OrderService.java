package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.Order;

public interface OrderService {

	Order createOrder(Order Order);
	
	List<Order> getOrders();
	
	Order getOrder(Integer id);

//	Order updateOrder(Order Order);

	void deleteOrder(Integer id);

}