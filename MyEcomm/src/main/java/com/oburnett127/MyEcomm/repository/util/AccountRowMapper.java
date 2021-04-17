package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oburnett127.MyEcomm.model.Account;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAccountId(rs.getInt("accountId"));
		account.setEmail(rs.getString("email"));
		account.setFirstName(rs.getString("firstName"));
		account.setLastName(rs.getString("lastName"));
		account.setPassword(rs.getString("password"));
		account.setAdmin(rs.getBoolean("isAdmin"));
		
		return account;
	}
}
