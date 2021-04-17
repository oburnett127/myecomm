package com.oburnett127.MyEcomm.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private int accountId;
	private ArrayList<Integer> productIds; //the product IDs of the products that are in the account's cart
}