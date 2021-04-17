package com.oburnett127.MyEcomm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.oburnett127.MyEcomm.model.Account;
import com.oburnett127.MyEcomm.repository.util.AccountRowMapper;

@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Account createAccount(Account account) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("accountId", account.getAccountId());
		data.put("email", account.getEmail());
		data.put("firstName", account.getFirstName());
		data.put("lastName", account.getLastName());
		data.put("password", account.getPassword());
		data.put("isAdmin", account.isAdmin());
		
		List<String> columns = new ArrayList<>();
		columns.add("accountId");
		columns.add("email");
		columns.add("firstName");
		columns.add("lastName");
		columns.add("password");
		columns.add("isAdmin");
		
		insert.setTableName("account");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		return getAccount(id.intValue());
	}
	
	@Override
	public Account getAccount(Integer id) {
		Account account = jdbcTemplate.queryForObject("select * from account where accountId = ?", new AccountRowMapper(), id);
		
		return account;
	}
	
	@Override
	public List<Account> getAccounts() {
		List<Account> accounts = jdbcTemplate.query("select * from account", new AccountRowMapper());
		
		return accounts;
	}
	
	@Override
	public Account updateAccount(Account account) {
		jdbcTemplate.update("update account set email = ?, firstName = ?, lastName = ?, password = ?, isAdmin = ? where accountId = ?", 
				account.getEmail(), account.getFirstName(), account.getLastName(), account.getPassword(), account.isAdmin(), account.getAccountId());
		
		return account;
	}
	
	@Override
	public void deleteAccount(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from account where accountId = :id", paramMap);
	}
}