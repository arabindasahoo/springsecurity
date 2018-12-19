package com.service;

import java.util.List;

import com.model.User;

public interface UserServiceDao {
	
	List<User> fetchUser();

	void createUser(User user);

}
