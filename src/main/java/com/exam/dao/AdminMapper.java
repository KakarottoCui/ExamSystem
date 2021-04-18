package com.exam.dao;

import com.exam.entity.Users;

public interface AdminMapper {
	
	//查询用户 id 密码
	public Users findByUser(Users users);
	
}
