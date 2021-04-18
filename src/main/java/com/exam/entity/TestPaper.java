package com.exam.entity;

import java.util.Date;

public class TestPaper {
	private Integer testpaperId;

	private String testpaperName;

	private Integer testpaperState;

	private String startDate;

	private String endDate;

	private Integer isStart;

	public Integer getTestpaperId() {
		return testpaperId;
	}

	public void setTestpaperId(Integer testpaperId) {
		this.testpaperId = testpaperId;
	}

	public String getTestpaperName() {
		return testpaperName;
	}

	public void setTestpaperName(String testpaperName) {
		this.testpaperName = testpaperName;
	}

	public Integer getTestpaperState() {
		return testpaperState;
	}

	public void setTestpaperState(Integer testpaperState) {
		this.testpaperState = testpaperState;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

}