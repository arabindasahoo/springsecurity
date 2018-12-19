package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	List<User> userList=new ArrayList<User>();
	
	@Override
	public List<User> getAllUser() {
		
			//userList = new ArrayList<User>();
			userList.add(new User("arabinda","arabinda21@gmail.com",21,"india"));
			userList.add(new User("arup","arup21@gmail.com",31,"Russia"));
			userList.add(new User("kunu","kunu21@gmail.com",41,"USA"));
			
		return userList;
	}

	@Override
	public void addUser(User user) {
		
		System.out.println(user.getEmail());
		userList.add(user);
	}
	
	

}
