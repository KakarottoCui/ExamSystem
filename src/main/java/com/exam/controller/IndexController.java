package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dao.UsersMapper;
import com.exam.entity.Users;

@RestController
public class IndexController {

	@Autowired
	private UsersMapper UsersMapper;
	
	@RequestMapping(value = {"/", "/index.html"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
