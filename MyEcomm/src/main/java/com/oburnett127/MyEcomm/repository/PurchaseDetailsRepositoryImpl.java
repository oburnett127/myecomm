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
import com.oburnett127.MyEcomm.model.PurchaseDetails;
import com.oburnett127.MyEcomm.repository.util.PurchaseDetailsRowMapper;

@Repository("purchaseDetailsRepository")
public class PurchaseDetailsRepositoryImpl implements PurchaseDetailsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public PurchaseDetails createPurchaseDetails(PurchaseDetails purchaseDetails) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("purchaseId", purchaseDetails.getPurchaseId());
		data.put("productId", purchaseDetails.getProductId());
		data.put("quantity", purchaseDetails.getQuantity());
		
		List<String> columns = new ArrayList<>();
		columns.add("purchaseId");
		columns.add("productId");
		columns.add("quantity");
		
		insert.setTableName("purchaseDetails");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		return getPurchaseDetails(id.intValue());
	}
	
	@Override
	public PurchaseDetails getPurchaseDetails(Integer id) {
		PurchaseDetails purchaseDetails = jdbcTemplate.queryForObject("select * from purchasedetails where purchaseId = ?", new PurchaseDetailsRowMapper(), id);
		
		return purchaseDetails;
	}
	
	@Override
	public List<PurchaseDetails> getPurchasesDetails() {
		List<PurchaseDetails> purchaseDetails = jdbcTemplate.query("select * from purchasedetails", new PurchaseDetailsRowMapper());
		
		return purchaseDetails;
	}
	
	@Override
	public PurchaseDetails updatePurchaseDetails(PurchaseDetails purchaseDetails) {
		jdbcTemplate.update("update purchaseDetails set quantity = ? where purchaseId = ? and productId = ?", 
				purchaseDetails.getQuantity(), purchaseDetails.getPurchaseId(), purchaseDetails.getProductId());
		
		return purchaseDetails;
	}
	
	//I am making the assumption that when the last PurchaseDetails record for an purchase is deleted, the purchase should not be deleted
	//Delete a single record in the purchasedetails table
	@Override
	public void deleteSinglePurchaseDetails(Integer purchaseId, Integer productId) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("purchaseid", purchaseId);
		paramMap.put("productid", productId);
		
		namedTemplate.update("delete from purchasedetails where purchaseId = :purchaseid and productid = :productid", paramMap);
	}
	
	//I am making the assumption that when the last PurchaseDetails record for an purchase is deleted, the purchase should not be deleted
	//Delete all records in purchasedetails table for a given purchase
	@Override
	public void deleteAllPurchaseDetails(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from purchasedetails where purchaseId = :id", paramMap);
	}
}