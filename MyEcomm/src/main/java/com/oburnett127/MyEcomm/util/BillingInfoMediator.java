package com.oburnett127.MyEcomm.util;

import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.service.BillingInfoServiceImpl;

public class BillingInfoMediator {

	public BillingInfo getBillingInfo(int purchaseId) {
		BillingInfoServiceImpl billingInfoServiceImpl = new BillingInfoServiceImpl();
		BillingInfo billingInfo = billingInfoServiceImpl.getBillingInfo(purchaseId);
		
		return billingInfo;
	}
	
	public void createBillingInfo(BillingInfo billingInfo) {
		BillingInfoServiceImpl billingInfoServiceImpl = new BillingInfoServiceImpl();
		billingInfoServiceImpl.createBillingInfo(billingInfo);
	}
}