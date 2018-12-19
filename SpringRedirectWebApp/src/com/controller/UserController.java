package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.UserServiceDao;

@Controller
public class UserController {

	@Autowired
	UserServiceDao userServiceDao;
	
	@RequestMapping(value="/")
	public String getRegisterPage()
	{
		return "registerForm";
	}
	
	@RequestMapping(value="/registerSuccess" ,method=RequestMethod.POST)
	public String getAllUser(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("age")int age,@RequestParam("country")String country)
	{
		//System.out.println(name + " " + email + " " + age + " " + country);
		
			User user=new User(name, email, age, country);
		
			userServiceDao.createUser(user);
		
		return "redirect:/listUser";
	}
	
	@RequestMapping(value="/listUser",method=RequestMethod.GET)
	public ModelAndView showUserList(ModelAndView modelAndView)
	{
		modelAndView.setViewName("userView");
		List<User> userList=userServiceDao.fetchUser();
		modelAndView.addObject("userList",userList);
		return modelAndView;
		
	}
	
}
