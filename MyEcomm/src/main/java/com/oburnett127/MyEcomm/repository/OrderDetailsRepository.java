package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.OrderDetails;

public interface OrderDetailsRepository {

	OrderDetails createOrderDetails(OrderDetails orderDetails);
	
	List<OrderDetails> getOrderDetails();

	OrderDetails getOrderDetails(Integer id);

	OrderDetails updateOrderDetails(OrderDetails orderDetails);

	void deleteOrderDetails(Integer id);
}