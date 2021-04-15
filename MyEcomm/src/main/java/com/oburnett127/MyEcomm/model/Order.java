package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Order {
	private Long orderId;
	private Long userId;
	private String orderDate;
	private OrderDetails orderDetails;
	private BillingInfo billingInfo;
}