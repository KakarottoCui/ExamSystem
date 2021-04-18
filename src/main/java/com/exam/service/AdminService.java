package com.exam.service;

import com.exam.entity.Users;

/**
 * 业务管业务类
 *
 */
public interface AdminService {

	//查询用户名-密码--接口
	public Users findByUser(Users users);
	
}
