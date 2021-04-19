package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.util.BillingInfoMediator;
import com.oburnett127.MyEcomm.util.PurchaseDetailsMediator;
import com.oburnett127.MyEcomm.model.Purchase;
import com.oburnett127.MyEcomm.model.PurchaseDetails;

public class PurchaseRowMapper implements RowMapper<Purchase> {
	@Override
	public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(rs.getInt("purchaseId"));
		purchase.setAccountId(rs.getInt("accountId"));
		purchase.setPurchaseDate(rs.getString("purchaseDate"));
		
		PurchaseDetailsMediator purchaseDetailsMediator = new PurchaseDetailsMediator();
		PurchaseDetails purchaseDetails = purchaseDetailsMediator.getPurchaseDetails(purchase.getPurchaseId());
		BillingInfoMediator billingInfoMediator = new BillingInfoMediator();
		BillingInfo billingInfo = billingInfoMediator.getBillingInfo(purchase.getPurchaseId());
		purchase.setPurchaseDetails(purchaseDetails);
		purchase.setBillingInfo(billingInfo);

		return purchase;
	}
}
