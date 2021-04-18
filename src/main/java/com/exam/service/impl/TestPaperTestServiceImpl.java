package com.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.TestPaperTestsMapper;
import com.exam.entity.TestPaperTests;
import com.exam.entity.TestPaperTestsList;
import com.exam.entity.vo.TestPaperTestsVo;
import com.exam.service.TestPaperTestService;

@Service
public class TestPaperTestServiceImpl implements TestPaperTestService {
	
	@Autowired
	private TestPaperTestsMapper testPaperTestsMapper;

	@Override
	public List<TestPaperTestsVo> findSelectTestPaperQuesion(int testpaperId) {
		// TODO Auto-generated method stub
		return testPaperTestsMapper.findSelectTestPaperQuesion(testpaperId);
	}

	@Override
	public int deleteTestPaperTestById(int testpaperId) {
		// TODO Auto-generated method stub
		return testPaperTestsMapper.deleteTestPaperTestById(testpaperId);
	}

	@Override
	public int addTestPaperQuestion(TestPaperTestsList testPaperTestsList) {
		
		List<TestPaperTests> testPaperTests = new ArrayList<TestPaperTests>();
		
		for (Integer id : testPaperTestsList.getQuestionBankId()) {
			TestPaperTests temp = new TestPaperTests();
			temp.setQuestionBankId(id);
			temp.setTestpaperId(testPaperTestsList.getTestpaperId());
			testPaperTests.add(temp);
		}
		
		return testPaperTestsMapper.addTestPaperQuestion(testPaperTests);
	}

}
