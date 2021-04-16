package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.Order;

public interface OrderRepository {

	Order createOrder(Order order);
	
	List<Order> getOrders();

	Order getOrder(Integer id);

	Order updateOrder(Order order);

	void deleteOrder(Integer id);
}