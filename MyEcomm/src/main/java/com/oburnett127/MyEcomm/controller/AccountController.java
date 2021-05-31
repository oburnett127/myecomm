package com.oburnett127.MyEcomm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.oburnett127.MyEcomm.model.Account;
import com.oburnett127.MyEcomm.service.AccountService;
import com.oburnett127.MyEcomm.util.ServiceError;

import lombok.Data;

@Data
@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public @ResponseBody Account createaccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public @ResponseBody List<Account> getaccounts() {
		return accountService.getAccounts();
	}
	
	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public @ResponseBody Account getaccount(@PathVariable(value="id") Integer id) {
		return accountService.getAccount(id);
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.PUT)
	public @ResponseBody Account updateaccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}
	
	@RequestMapping(value = "account/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		accountService.deleteAccount(id);
		return null;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}