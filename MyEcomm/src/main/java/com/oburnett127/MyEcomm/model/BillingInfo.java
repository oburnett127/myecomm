package com.oburnett127.MyEcomm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingInfo {
	private int billingId;
	private int accountId;
	private String billFirstName;
	private String billLastName;
	private String billingDate;
	private String billingAddress;
	private String creditCardExpDate;
	private String creditCardPin;
	private String creditCardNum;
	private String creditCardName;
}