package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private int orderId;
	private int userId;
	private String orderDate;
	private OrderDetails orderDetails;
	private BillingInfo billingInfo;
}