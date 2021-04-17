package com.oburnett127.MyEcomm.repository;

import java.util.List;

import com.oburnett127.MyEcomm.model.Account;

public interface AccountRepository {

	Account createAccount(Account account);
	
	List<Account> getAccounts();

	Account getAccount(Integer id);

	Account updateAccount(Account account);

	void deleteAccount(Integer id);
}