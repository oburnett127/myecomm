package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.Purchase;

public interface PurchaseService {

	Purchase createPurchase(Purchase Purchase);
	
	List<Purchase> getPurchases();
	
	Purchase getPurchase(Integer id);

//	Purchase updatePurchase(Purchase Purchase);

	void deletePurchase(Integer id);

}