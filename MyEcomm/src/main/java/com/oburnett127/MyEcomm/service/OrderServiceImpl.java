package com.oburnett127.MyEcomm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.Order;
import com.oburnett127.MyEcomm.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order createOrder(Order order) {
		return orderRepository.createOrder(order);
	}
	
	@Override
	public Order getOrder(Integer id) {
		return orderRepository.getOrder(id);
	}
	
	@Override
	public List<Order> getOrders() {
		return orderRepository.getOrders();
	}
	
	@Override
	public Order updateOrder(Order order) {
		return orderRepository.updateOrder(order);
	}
	
	@Override
	public void deleteOrder(Integer id) {
		orderRepository.deleteOrder(id);
	}
}