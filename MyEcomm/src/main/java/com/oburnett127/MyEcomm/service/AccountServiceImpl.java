package com.oburnett127.MyEcomm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.Account;
import com.oburnett127.MyEcomm.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.createAccount(account);
	}
	
	@Override
	public Account getAccount(Integer id) {
		return accountRepository.getAccount(id);
	}
	
	@Override
	public List<Account> getAccounts() {
		return accountRepository.getAccounts();
	}
	
	@Override
	public Account updateAccount(Account account) {
		return accountRepository.updateAccount(account);
	}
	
	@Override
	public void deleteAccount(Integer id) {
		accountRepository.deleteAccount(id);
	}
}