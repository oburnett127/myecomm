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
import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.service.BillingInfoService;
import com.oburnett127.MyEcomm.util.ServiceError;

@Controller
public class BillingInfoController {
	@Autowired
	private BillingInfoService billingInfoService;
	
	@RequestMapping(value = "/billinginfo", method = RequestMethod.POST)
	public @ResponseBody BillingInfo createBillingInfo(@RequestBody BillingInfo billingInfo) {
		return billingInfoService.createBillingInfo(billingInfo);
	}
	
	@RequestMapping(value = "/billinginfos", method = RequestMethod.GET)
	public @ResponseBody List<BillingInfo> getBillingInfos() {
		return billingInfoService.getBillingInfos();
	}
	
	@RequestMapping(value = "/billinginfo/{id}", method = RequestMethod.GET)
	public @ResponseBody BillingInfo getBillingInfo(@PathVariable(value="id") Integer id) {
		return billingInfoService.getBillingInfo(id);
	}
	
	@RequestMapping(value = "/billinginfo", method = RequestMethod.PUT)
	public @ResponseBody BillingInfo updateBillingInfo(@RequestBody BillingInfo BillingInfo) {
		return billingInfoService.updateBillingInfo(BillingInfo);
	}
	
	@RequestMapping(value = "/billinginfo/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable(value="id") Integer id) {
		billingInfoService.deleteBillingInfo(id);
		return null;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ServiceError> handle(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}