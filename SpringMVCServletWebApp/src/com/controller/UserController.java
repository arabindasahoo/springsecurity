package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller
public class UserController {
	//second commit
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getUser()
	{
		return "registerForm";
	}
	@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public ModelAndView viewUser(HttpServletRequest req,HttpServletResponse res)
	{
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int age=Integer.parseInt(req.getParameter("age"));
		String country=req.getParameter("country");
		
		User user=new User(name, email, age, country);
		ModelAndView mav=new ModelAndView("success");
		mav.addObject("user",user);
		return mav;
	}

}
