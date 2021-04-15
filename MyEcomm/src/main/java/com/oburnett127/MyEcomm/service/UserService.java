package com.oburnett127.MyEcomm.service;

import java.util.List;

import com.oburnett127.MyEcomm.model.User;

public interface UserService {

	User createUser(User User);
	
	List<User> getUsers();
	
	User getUser(Integer id);

	User updateUser(User User);

	void deleteUser(Integer id);

}