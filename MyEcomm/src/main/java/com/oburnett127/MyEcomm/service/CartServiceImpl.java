package com.oburnett127.MyEcomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.repository.CartRepository;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.createCart(cart);
	}
	
	@Override
	public Cart getCart(Integer id) {
		return cartRepository.getCart(id);
	}
	
//	@Override
//	public List<Cart> getCarts() {
//		return cartRepository.getCarts();
//	}
//	
//	@Override
//	public Cart updateCart(Cart cart) {
//		return cartRepository.updateCart(cart);
//	}
//	
//	@Override
//	public void deleteCart(Integer id) {
//		cartRepository.deleteCart(id);
//	}
}