package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.PurchaseDetails;

public interface PurchaseDetailsService {

	PurchaseDetails createPurchaseDetails(PurchaseDetails PurchaseDetails);
	
	List<PurchaseDetails> getPurchasesDetails();
	
	PurchaseDetails getPurchaseDetails(Integer id);

	PurchaseDetails updatePurchaseDetails(PurchaseDetails PurchaseDetails);

	void deleteSinglePurchaseDetails(Integer purchaseId, Integer productId);
	
	void deleteAllPurchaseDetails(Integer purchaseId);
}