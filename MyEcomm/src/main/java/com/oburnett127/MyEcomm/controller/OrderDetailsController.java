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
import com.oburnett127.MyEcomm.model.OrderDetails;
import com.oburnett127.MyEcomm.service.OrderDetailsService;
import com.oburnett127.MyEcomm.util.ServiceError;

@RestController
@RequestMapping("/orderdetails")
class OrderDetailsDetailsController {
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@RequestMapping(value = "/orderdetails", method = RequestMethod.POST)
	public @ResponseBody OrderDetails createOrderDetails(@RequestBody OrderDetails orderDetails) {
		return orderDetailsService.createOrderDetails(orderDetails);
	}
	
	@RequestMapping(value = "/ordersdetails", method = RequestMethod.GET)
	public @ResponseBody List<OrderDetails> getOrderDetails() {
		return orderDetailsService.getOrdersDetails();
	}
	
	@RequestMapping(value = "/orderdetails/{id}", method = RequestMethod.GET)
	public @ResponseBody OrderDetails getOrderDetails(@PathVariable(value="id") Integer id) {
		return orderDetailsService.getOrderDetails(id);
	}
	
	@RequestMapping(value = "/orderdetails", method = RequestMethod.PUT)
	public @ResponseBody OrderDetails updateOrderDetails(@RequestBody OrderDetails OrderDetails) {
		return orderDetailsService.updateOrderDetails(OrderDetails);
	}
	
	@RequestMapping(value = "/deleteSingle/{orderid}/{productid}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteSingleOrderDetails(@PathVariable(value="orderid") Integer orderid, @PathVariable(value="productid") Integer productid) {
		orderDetailsService.deleteSingleOrderDetails(orderid, productid);
	}
	
	@RequestMapping(value = "/deleteAll/{orderid}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAllOrderDetails(@PathVariable(value="orderid") Integer orderid) {
		orderDetailsService.deleteAllOrderDetails(orderid);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}