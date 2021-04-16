package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.BillingInfo;

public interface BillingInfoRepository {

	BillingInfo createBillingInfo(BillingInfo billingInfo);
	
	List<BillingInfo> getBillingInfos();

	BillingInfo getBillingInfo(Integer id);

	BillingInfo updateBillingInfo(BillingInfo billingInfo);

	void deleteBillingInfo(Integer id);
}