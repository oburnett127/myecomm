package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.Cart;

public interface CartService {

	Cart createCart(Cart Cart);
	
	List<Cart> getCarts();
	
	Cart getCart(Integer id);

	Cart updateCart(Cart Cart);

	void deleteCart(Integer id);

}