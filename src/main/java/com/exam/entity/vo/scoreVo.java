package com.exam.entity.vo;

import com.exam.entity.Score;

public class scoreVo extends Score{
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user_name) {
		this.userName = user_name;
	}

	@Override
	public String toString() {
		return "scoreVo [userName=" + userName + "]";
	}
	
	

}
