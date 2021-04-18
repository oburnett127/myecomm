package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingInfo {
	private int billingId; //Including billing id for future functionality
	private int purchaseId;
	private String billFirstName;
	private String billLastName;
	private String billingAddress;
	private String creditCardExpDate;
	private String creditCardPin;
	private String creditCardNum;
	private String creditCardName;
}