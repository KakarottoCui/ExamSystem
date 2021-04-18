package com.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.AdminMapper;
import com.exam.entity.Users;
import com.exam.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	//查询用户名-密码--接口
	@Override
	public Users findByUser(Users users) {
		
		Users user = adminMapper.findByUser(users);
		
		return user;
	}

}
