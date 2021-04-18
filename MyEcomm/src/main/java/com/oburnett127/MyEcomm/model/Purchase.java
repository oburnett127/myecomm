package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
	private int purchaseId;
	private int accountId;
	private String purchaseDate;
	private PurchaseDetails purchaseDetails;
	private BillingInfo billingInfo;
}