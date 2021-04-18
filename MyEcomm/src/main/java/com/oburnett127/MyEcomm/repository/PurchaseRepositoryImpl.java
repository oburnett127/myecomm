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
import com.oburnett127.MyEcomm.model.Purchase;
import com.oburnett127.MyEcomm.repository.util.PurchaseRowMapper;

@Repository("purchaseRepository")
public class PurchaseRepositoryImpl implements PurchaseRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Purchase createPurchase(Purchase purchase) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("purchaseId", purchase.getPurchaseId());
		data.put("accountId", purchase.getAccountId());
		data.put("purchaseDate", purchase.getPurchaseDate());
		
		List<String> columns = new ArrayList<>();
		columns.add("purchaseId");
		columns.add("accountId");
		columns.add("purchaseDate");
		
		insert.setTableName("purchase");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		PurchaseDetailsRepositoryImpl purchaseDetailsRepositoryImpl = new PurchaseDetailsRepositoryImpl();
		purchaseDetailsRepositoryImpl.createPurchaseDetails(purchase.getPurchaseDetails());
		
		BillingInfoRepositoryImpl billingInfoRepositoryImpl = new BillingInfoRepositoryImpl();
		billingInfoRepositoryImpl.createBillingInfo(purchase.getBillingInfo());
		
		return getPurchase(id.intValue());
	}
	
	@Override
	public Purchase getPurchase(Integer id) {
		Purchase purchase = jdbcTemplate.queryForObject("select * from purchase where purchaseId = ?", new PurchaseRowMapper(), id);
		
		return purchase;
	}
	
	@Override
	public List<Purchase> getPurchases() {
		List<Purchase> purchases = jdbcTemplate.query("select * from purchase", new PurchaseRowMapper());
		
		return purchases;
	}
	
//	@Override
//	public Purchase updatePurchase(Purchase purchase) {
//		jdbcTemplate.update("update purchase set purchaseDate = ? where purchaseId = ?", 
//				purchase.getPurchaseId(), purchase.getaccountId(), purchase.getPurchaseDate(), purchase.getPurchaseId());
//		
//		return purchase;
//	}
	
	@Override
	public void deletePurchase(Integer id) {
		PurchaseDetailsRepositoryImpl purchaseDetailsRepositoryImpl = new PurchaseDetailsRepositoryImpl();
		purchaseDetailsRepositoryImpl.deleteAllPurchaseDetails(id); //delete all records in purchasedetails table for this purchase
		
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from purchase where purchaseId = :id", paramMap);
	}
}