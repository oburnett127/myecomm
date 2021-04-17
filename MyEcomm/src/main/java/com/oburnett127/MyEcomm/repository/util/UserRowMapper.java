package com.oburnett127.MyEcomm.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oburnett127.MyEcomm.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setPassword(rs.getString("password"));
		user.setAdmin(rs.getBoolean("isAdmin"));
		
		return user;
	}
}
