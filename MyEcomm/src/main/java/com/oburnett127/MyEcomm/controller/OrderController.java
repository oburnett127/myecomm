package com.oburnett127.MyEcomm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.oburnett127.MyEcomm.model.Order;
import com.oburnett127.MyEcomm.service.OrderService;
import com.oburnett127.MyEcomm.util.ServiceError;

@RestController
@RequestMapping("/orders")
class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public @ResponseBody Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public @ResponseBody List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public @ResponseBody Order getOrder(@PathVariable(value="id") Integer id) {
		return orderService.getOrder(id);
	}
	
//	@RequestMapping(value = "/order", method = RequestMethod.PUT)
//	public @ResponseBody Order updateOrder(@RequestBody Order Order) {
//		return orderService.updateOrder(Order);
//	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		orderService.deleteOrder(id);
		return null;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}