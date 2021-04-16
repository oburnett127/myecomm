package com.oburnett127.MyEcomm.controller;

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

import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.service.CartService;
import com.oburnett127.MyEcomm.util.ServiceError;

@RestController
@RequestMapping("/carts")
class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public @ResponseBody Cart createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}
	
	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable(value="id") Integer id) {
		return cartService.getCart(id);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/cart", method = RequestMethod.PUT)
//	public @ResponseBody Cart updateCart(@RequestBody Cart Cart) {
//		return cartService.updateCart(Cart);
//	}
	
//	@RequestMapping(value = "/carts", method = RequestMethod.GET)
//	public @ResponseBody List<Cart> getCarts() {
//		return cartService.getCarts();
//	}
	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
//		cartService.deleteCart(id);
//		return null;
//	}
}