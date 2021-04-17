package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.PurchaseDetails;

public interface PurchaseDetailsRepository {

	PurchaseDetails createPurchaseDetails(PurchaseDetails purchaseDetails);
	
	List<PurchaseDetails> getPurchasesDetails();

	PurchaseDetails getPurchaseDetails(Integer id);

	PurchaseDetails updatePurchaseDetails(PurchaseDetails purchaseDetails);

	void deleteSinglePurchaseDetails(Integer purchaseId, Integer productId);
	
	void deleteAllPurchaseDetails(Integer id);
}