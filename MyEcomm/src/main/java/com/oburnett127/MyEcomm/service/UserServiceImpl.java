package com.oburnett127.MyEcomm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oburnett127.MyEcomm.model.User;
import com.oburnett127.MyEcomm.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.createUser(user);
	}
	
	@Override
	public User getUser(Integer id) {
		return userRepository.getUser(id);
	}
	
	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteUser(id);
	}
}