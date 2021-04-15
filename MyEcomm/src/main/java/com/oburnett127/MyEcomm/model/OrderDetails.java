package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderDetails {
	private Long orderId;
	private Long productId;
	private BigDecimal unitPrice;
	private Long quantity;
}