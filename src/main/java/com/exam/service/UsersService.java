package com.exam.service;

import java.util.List;

import com.exam.entity.Users;

public interface UsersService {
    //查询所有用户
    
	//2.1查询用户数据 接口
    List<Users> findUserInfo();
    
    //删除用户信息
   int deleteByPrimaryKey(String userId);

}
