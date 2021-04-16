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
import com.oburnett127.MyEcomm.model.User;
import com.oburnett127.MyEcomm.repository.util.UserRowMapper;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User createUser(User user) {		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("userId", user.getUserId());
		data.put("email", user.getEmail());
		data.put("firstName", user.getFirstName());
		data.put("lastName", user.getLastName());
		data.put("password", user.getPassword());
		data.put("isAdmin", user.isAdmin());
		data.put("cartId", user.getCartId());
		
		List<String> columns = new ArrayList<>();
		columns.add("userId");
		columns.add("email");
		columns.add("firstName");
		columns.add("lastName");
		columns.add("password");
		columns.add("isAdmin");
		columns.add("cartId");
		
		insert.setTableName("user");
		insert.setColumnNames(columns);
		Number id = insert.executeAndReturnKey(data);
		
		return getUser(id.intValue());
	}
	
	@Override
	public User getUser(Integer id) {
		User user = jdbcTemplate.queryForObject("select * from user where userId = ?", new UserRowMapper(), id);
		
		return user;
	}
	
	@Override
	public List<User> getUsers() {
		List<User> users = jdbcTemplate.query("select * from user", new UserRowMapper());
		
		return users;
	}
	
	@Override
	public User updateUser(User user) {
		jdbcTemplate.update("update user set email = ?, firstName = ?, lastName = ?, password = ?, isAdmin = ? where userId = ?", 
				user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.isAdmin(), user.getUserId());
		
		return user;
	}
	
	@Override
	public void deleteUser(Integer id) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		
		namedTemplate.update("delete from user where userId = :id", paramMap);
	}
}