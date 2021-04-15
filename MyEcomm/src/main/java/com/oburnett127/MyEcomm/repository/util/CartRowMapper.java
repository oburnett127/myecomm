package com.oburnett127.MyEcomm.repository.util;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.model.Cart;

public class CartRowMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart(1, "fakeemail@fakeemail.com", "Bob", "Jones", "abc123", false, new Cart(1, 0, new BigDecimal(0.00), new ArrayList<Product>( ) ));
		cart.setCartId(rs.getInt("cartId"));
		cart.setEmail(rs.getString("email"));
		cart.setFirstName(rs.getString("firstName"));
		cart.setLastName(rs.getString("lastName"));
		cart.setPassword(rs.getString("password"));
		cart.setAdmin(rs.getBoolean("isAdmin"));
		cart.setCart(rs.getInt("cartID"));
		
		return cart;
	}
}
