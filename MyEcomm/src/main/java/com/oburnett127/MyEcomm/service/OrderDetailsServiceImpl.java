package com.oburnett127.MyEcomm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.OrderDetails;
import com.oburnett127.MyEcomm.repository.OrderDetailsRepository;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public OrderDetails createOrderDetails(OrderDetails orderDetails) {
		return orderDetailsRepository.createOrderDetails(orderDetails);
	}
	
	@Override
	public OrderDetails getOrderDetails(Integer id) {
		return orderDetailsRepository.getOrderDetails(id);
	}
	
	@Override
	public List<OrderDetails> getOrdersDetails() {
		return orderDetailsRepository.getOrdersDetails();
	}
	
	@Override
	public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
		return orderDetailsRepository.updateOrderDetails(orderDetails);
	}
	
	@Override
	public void deleteSingleOrderDetails(Integer orderId, Integer productId) {
		orderDetailsRepository.deleteAllOrderDetails(orderId);
	}
	
	@Override
	public void deleteAllOrderDetails(Integer id) {
		orderDetailsRepository.deleteAllOrderDetails(id);
	}
}