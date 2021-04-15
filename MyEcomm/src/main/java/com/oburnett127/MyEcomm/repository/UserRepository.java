package com.oburnett127.MyEcomm.repository;

import java.util.List;
import com.oburnett127.MyEcomm.model.User;

public interface UserRepository {

	User createUser(User user);
	
	List<User> getUsers();

	User getUser(Integer id);

	User updateUser(User user);

	void deleteUser(Integer id);
}