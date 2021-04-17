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
import com.oburnett127.MyEcomm.model.BillingInfo;
import com.oburnett127.MyEcomm.repository.util.BillingInfoRowMapper;

@Repository("billingInfoRepository")
public class BillingInfoRepositoryImpl implements BillingInfoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public BillingInfo createBillingInfo(BillingInfo billingInfo) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("billingId", billingInfo.getBillingId());
		data.put("userId", billingInfo.getUserId());
		data.put("billFirstName", billingInfo.getBillFirstName());
		data.put("billLastName", billingInfo.getBillLastName());
		data.put("billingDate", billingInfo.getBillingDate());
		data.put("creditCardExpDate", billingInfo.getCreditCardExpDate());
		data.put("creditCardPin", billingInfo.getCreditCardPin());
		data.put("creditCardNum", billingInfo.getCreditCardNum());
		data.put("creditCardName", billingInfo.getCreditCardName());
		
		List<String> columns = new ArrayList<>();
		columns.add("billingId");
		column.add("userId");
		column.add("billFirstName");
		column.add("billLastName");
		columns.add("billingDate");
		columns.add("creditCardExpDate");
		columns.add("creditCardPin");
		columns.add("creditCardNum");
		columns.add("creditCardName");
		
		insert.setTableName("billingInfo");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		return getBillingInfo(id.intValue());
	}
	
	@Override
	public BillingInfo getBillingInfo(Integer id) {
		BillingInfo billingInfo = jdbcTemplate.queryForObject("select * from billinginfo where billingId = ?", new BillingInfoRowMapper(), id);
		
		return billingInfo;
	}
	
	@Override
	public List<BillingInfo> getBillingInfos() {
		List<BillingInfo> billingInfos = jdbcTemplate.query("select * from billinginfo", new BillingInfoRowMapper());
		
		return billingInfos;
	}
	
	@Override
	public BillingInfo updateBillingInfo(BillingInfo billingInfo) {
		jdbcTemplate.update("update billinginfo set billingdate = ?, userid = ?, billfirstname = ?, billlastname = ?, creditcardexpdate = ?, creditcardpin = ?, creditcardnum = ?, creditcardname = ? where billingid = ?", 
				billingInfo.getBillingDate(), billingInfo.getUserId(), billingInfo.getBillFirstName(), billingInfo.getBillLastName(), billingInfo.getCreditCardExpDate(), billingInfo.getCreditCardPin(),
				billingInfo.getCreditCardNum(), billingInfo.getCreditCardName(), billingInfo.getBillingId());
		
		return billingInfo;
	}
	
	@Override
	public void deleteBillingInfo(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from billinginfo where billingid = :id", paramMap);
	}
}