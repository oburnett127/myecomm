package com.oburnett127.MyEcomm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.oburnett127.MyEcomm.model.Purchase;
import com.oburnett127.MyEcomm.service.PurchaseService;
import com.oburnett127.MyEcomm.util.ServiceError;

@RestController
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public @ResponseBody Purchase createPurchase(@RequestBody Purchase purchase) {
		return purchaseService.createPurchase(purchase);
	}
	
	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public @ResponseBody List<Purchase> getPurchases() {
		return purchaseService.getPurchases();
	}
	
	@RequestMapping(value = "/purchase/{id}", method = RequestMethod.GET)
	public @ResponseBody Purchase getPurchase(@PathVariable(value="id") Integer id) {
		return purchaseService.getPurchase(id);
	}
	
//	@RequestMapping(value = "/purchase", method = RequestMethod.PUT)
//	public @ResponseBody Purchase updatePurchase(@RequestBody Purchase Purchase) {
//		return purchaseService.updatePurchase(Purchase);
//	}
	
	@RequestMapping(value = "/purchase/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		purchaseService.deletePurchase(id);
		return null;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}