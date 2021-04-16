package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.Cart;

public interface CartRepository {

	Cart createCart(Cart cart);
	
	//List<Cart> getCarts();

	Cart getCart(Integer id);

	Cart updateCart(Cart cart);

	//void deleteCart(Integer id);
}