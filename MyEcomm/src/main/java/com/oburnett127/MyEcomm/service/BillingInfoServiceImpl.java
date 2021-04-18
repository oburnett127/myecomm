package com.oburnett127.MyEcomm.service;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.repository.BillingInfoRepository;

@Component
@Service("billingInfoService")
public class BillingInfoServiceImpl implements BillingInfoService {

	@Autowired
	private BillingInfoRepository billingInfoRepository;
	
	@Override
	public BillingInfo createBillingInfo(BillingInfo billingInfo) {
		return billingInfoRepository.createBillingInfo(billingInfo);
	}
	
	@Override
	public BillingInfo getBillingInfo(Integer purchaseId) {
		return billingInfoRepository.getBillingInfo(purchaseId);
	}
	
	@Override
	public List<BillingInfo> getBillingInfos() {
		return billingInfoRepository.getBillingInfos();
	}
	
	@Override
	public BillingInfo updateBillingInfo(BillingInfo billingInfo) {
		return billingInfoRepository.updateBillingInfo(billingInfo);
	}
	
	@Override
	public void deleteBillingInfo(Integer id) {
		billingInfoRepository.deleteBillingInfo(id);
	}
}