package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.model.Cart;
import com.oburnett127.MyEcomm.model.Product;
import com.oburnett127.MyEcomm.service.BillingInfoServiceImpl;
import com.oburnett127.MyEcomm.service.PurchaseDetailsServiceImpl;
import com.oburnett127.MyEcomm.model.Purchase;
import com.oburnett127.MyEcomm.model.PurchaseDetails;

public class PurchaseRowMapper implements RowMapper<Purchase> {
	@Override
	public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(rs.getInt("purchaseId"));
		purchase.setAccountId(rs.getInt("accountId"));
		purchase.setPurchaseDate(rs.getString("purchaseDate"));
		
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		PurchaseDetailsServiceImpl purchaseDetailsServiceImpl = new PurchaseDetailsServiceImpl();
		purchaseDetailsServiceImpl.getPurchaseDetails(purchase.getPurchaseId());
		BillingInfo billingInfo = new BillingInfo();
		BillingInfoServiceImpl billingInfoServiceImpl = new BillingInfoServiceImpl();
		billingInfoServiceImpl.getBillingInfo(purchase.getPurchaseId());
		
		return purchase;
	}
}
