package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.oburnett127.MyEcomm.model.Cart;

public class CartRowMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setCartId(rs.getInt("cartId"));
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		do {
			tempList.add(rs.getInt("productId"));
		} while(rs.next());
		
		cart.setProductIds(tempList);
		
		return cart;
	}
}
