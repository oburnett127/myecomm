package com.oburnett127.MyEcomm.util;

import com.oburnett127.MyEcomm.model.PurchaseDetails;
import com.oburnett127.MyEcomm.repository.PurchaseDetailsRepositoryImpl;
import com.oburnett127.MyEcomm.service.PurchaseDetailsServiceImpl;
import com.oburnett127.MyEcomm.controller.PurchaseDetailsController;

public class PurchaseDetailsMediator {

	public PurchaseDetails getPurchaseDetails(int purchaseId) {
		PurchaseDetailsController purchaseDetailsController = new PurchaseDetailsController();
		purchaseDetailsController.setPurchaseDetailsService();
		PurchaseDetailsServiceImpl purchaseDetailsServiceImpl = new PurchaseDetailsServiceImpl();
		purchaseDetailsServiceImpl.setPurchaseDetailsRepository();
		PurchaseDetails purchaseDetails = purchaseDetailsController.getPurchaseDetails(purchaseId);
		
		return purchaseDetails;
	}
	
	public void createPurchaseDetails(PurchaseDetails purchaseDetails) {
		PurchaseDetailsRepositoryImpl purchaseDetailsRepositoryImpl = new PurchaseDetailsRepositoryImpl();
		purchaseDetailsRepositoryImpl.createPurchaseDetails(purchaseDetails);
	}
}