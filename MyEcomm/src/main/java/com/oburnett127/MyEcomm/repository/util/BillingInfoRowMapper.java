package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.oburnett127.MyEcomm.model.BillingInfo;

public class BillingInfoRowMapper implements RowMapper<BillingInfo> {

	@Override
	public BillingInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillingInfo billingInfo = new BillingInfo();
		billingInfo.setBillingId(rs.getInt("billingId"));
		billingInfo.setAccountId(rs.getInt("accountId"));
		billingInfo.setBillFirstName(rs.getString("billFirstName"));
		billingInfo.setBillFirstName(rs.getString("billLastName"));
		billingInfo.setBillingDate(rs.getString("billingDate"));
		billingInfo.setCreditCardExpDate(rs.getString("creditCardExpDate"));
		billingInfo.setCreditCardPin(rs.getString("creditCardPin"));
		billingInfo.setCreditCardNum(rs.getString("creditCardNum"));
		billingInfo.setCreditCardName(rs.getString("creditCardName"));
		
		return billingInfo;
	}
}
