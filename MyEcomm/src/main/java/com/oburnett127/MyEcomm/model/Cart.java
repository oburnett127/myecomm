package com.oburnett127.MyEcomm.model;

import java.math.BigDecimal;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cart {
	private int cartId;
	private int numProducts;
	private BigDecimal totalPrice;
	private ArrayList<Product> products;
}