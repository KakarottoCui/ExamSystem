package com.exam.entity;

import java.util.List;

public class TestPaperTestsList {

	private Integer testpaperId;

	private List<Integer> questionBankId;

	public Integer getTestpaperId() {
		return testpaperId;
	}

	public void setTestpaperId(Integer testpaperId) {
		this.testpaperId = testpaperId;
	}

	public List<Integer> getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(List<Integer> questionBankId) {
		this.questionBankId = questionBankId;
	}

}
