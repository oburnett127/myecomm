package com.oburnett127.MyEcomm.service;

import com.oburnett127.MyEcomm.model.Cart;

public interface CartService {

	Cart createCart(Cart Cart);
	
	Cart getCart(Integer id);
	
	//List<Cart> getCarts();

	//Cart updateCart(Cart Cart);

	//void deleteCart(Integer id);

}