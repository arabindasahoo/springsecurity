package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceDaoImpl implements UserServiceDao{

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> fetchUser() {

		return userDao.getAllUser();
	}

	@Override
	public void createUser(User user) {
		System.out.println(user.getName());
		userDao.addUser(user);
	}
}
