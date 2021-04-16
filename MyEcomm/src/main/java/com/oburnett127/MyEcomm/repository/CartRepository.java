package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.Cart;

public interface CartRepository {

	Cart createCart(Cart cart);
	
	Cart getCart(Integer id);
	
	//List<Cart> getCarts();

	//Cart updateCart(Cart cart);

	//void deleteCart(Integer id);
}