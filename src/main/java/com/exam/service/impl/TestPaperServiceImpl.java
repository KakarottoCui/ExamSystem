package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.QuestionBankMapper;
import com.exam.dao.TestPaperMapper;
import com.exam.entity.TestPaper;
import com.exam.entity.vo.QuestionBankVo;
import com.exam.service.TestPaperService;

@Service
public class TestPaperServiceImpl implements TestPaperService {
	@Autowired
	private TestPaperMapper testPaperMapper;
	@Autowired
	private QuestionBankMapper questionBankMapper; //题库

	@Override
	public List<TestPaper> findTestPaperInfo() {

		return testPaperMapper.findTestPaperInfo();
	}

	@Override
	public int updateTestPaperState(int testpaperId) {
		// TODO Auto-generated method stub
		return testPaperMapper.updateTestPaperState(testpaperId);
	}

	@Override
	public TestPaper selectByPrimaryKey(Integer testpaperId) {
		// TODO Auto-generated method stub
		return testPaperMapper.selectByPrimaryKey(testpaperId);
	}

	@Override
	public int updateTestPaperInfo(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return testPaperMapper.updateTestPaperInfo(testPaper);
	}

	@Override
	public List<QuestionBankVo> findAllQuestionBank() {
		
		List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
		
		return findAllQuestionBank;
	}


}
