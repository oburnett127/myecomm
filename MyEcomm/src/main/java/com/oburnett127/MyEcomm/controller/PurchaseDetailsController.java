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
import com.oburnett127.MyEcomm.model.PurchaseDetails;
import com.oburnett127.MyEcomm.service.PurchaseDetailsService;
import com.oburnett127.MyEcomm.util.ServiceError;

@RestController
@RequestMapping("/purchasedetails")
class PurchaseDetailsDetailsController {
	@Autowired
	private PurchaseDetailsService purchaseDetailsService;
	
	@RequestMapping(value = "/purchasedetails", method = RequestMethod.POST)
	public @ResponseBody PurchaseDetails createPurchaseDetails(@RequestBody PurchaseDetails purchaseDetails) {
		return purchaseDetailsService.createPurchaseDetails(purchaseDetails);
	}
	
	@RequestMapping(value = "/purchasesdetails", method = RequestMethod.GET)
	public @ResponseBody List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetailsService.getPurchasesDetails();
	}
	
	@RequestMapping(value = "/purchasedetails/{id}", method = RequestMethod.GET)
	public @ResponseBody PurchaseDetails getPurchaseDetails(@PathVariable(value="id") Integer id) {
		return purchaseDetailsService.getPurchaseDetails(id);
	}
	
	@RequestMapping(value = "/purchasedetails", method = RequestMethod.PUT)
	public @ResponseBody PurchaseDetails updatePurchaseDetails(@RequestBody PurchaseDetails PurchaseDetails) {
		return purchaseDetailsService.updatePurchaseDetails(PurchaseDetails);
	}
	
	@RequestMapping(value = "/deleteSingle/{purchaseid}/{productid}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteSinglePurchaseDetails(@PathVariable(value="purchaseid") Integer purchaseid, @PathVariable(value="productid") Integer productid) {
		purchaseDetailsService.deleteSinglePurchaseDetails(purchaseid, productid);
	}
	
	@RequestMapping(value = "/deleteAll/{purchaseid}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAllPurchaseDetails(@PathVariable(value="purchaseid") Integer purchaseid) {
		purchaseDetailsService.deleteAllPurchaseDetails(purchaseid);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}