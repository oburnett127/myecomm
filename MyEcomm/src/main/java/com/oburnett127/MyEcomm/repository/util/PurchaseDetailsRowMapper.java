package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.oburnett127.MyEcomm.model.PurchaseDetails;

public class PurchaseDetailsRowMapper implements RowMapper<PurchaseDetails> {
	@Override
	public PurchaseDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		purchaseDetails.setPurchaseId(rs.getInt("purchaseId"));
		purchaseDetails.setProductId(rs.getInt("productId"));
		purchaseDetails.setQuantity(rs.getInt("quantity"));
		
		return purchaseDetails;
	}
}
