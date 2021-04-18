package com.exam.entity.vo;

import java.util.List;

import com.exam.entity.Options;
import com.exam.entity.QuestionBank;


public class QuestionBankVo extends QuestionBank {

	private List<Options> options;

	private boolean ifCorrect;

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public boolean isIfCorrect() {
		return ifCorrect;
	}

	public void setIfCorrect(boolean ifCorrect) {
		this.ifCorrect = ifCorrect;
	}

}
