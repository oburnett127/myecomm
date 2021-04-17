package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.Purchase;

public interface PurchaseRepository {

	Purchase createPurchase(Purchase purchase);
	
	List<Purchase> getPurchases();

	Purchase getPurchase(Integer id);

	//Purchase updatePurchase(Purchase purchase);

	void deletePurchase(Integer id);
}