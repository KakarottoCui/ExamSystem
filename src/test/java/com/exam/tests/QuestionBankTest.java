package com.exam.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.dao.QuestionBankMapper;
import com.exam.entity.Options;
import com.exam.entity.vo.QuestionBankVo;
import com.exam.service.QuestionBankService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
public class QuestionBankTest {
	
	//查询所有试卷单元测试
	@Autowired
	private QuestionBankMapper questionBankMapper;
	@Autowired
	private QuestionBankService qbs;
	/**
	 * 查询所有试卷单元测试
	 */
	@Test
	public void testFindAllQuestionBank() {
		List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
		System.out.println(findAllQuestionBank.toString());
	}
	
	/**
	 * 测试添加题
	 */
	@Test
	public void testAddQuestionBank() {
		QuestionBankVo questionBankVo = new QuestionBankVo();
		questionBankVo.setStem("测试一个猪");
		questionBankVo.setAnswer("B");
		questionBankVo.setTestsType(1);
		questionBankVo.setState(1);
		
		int addQuestionBank = questionBankMapper.addQuestionBank(questionBankVo);
		System.out.println(addQuestionBank);
	}

	/**
	 * 测试添加题选项
	 */
	@Test
	public void testAddOPtions() {
		
		List<Options> options = new ArrayList<Options>();
		
		Options op1 = new Options();
		op1.setOp("A");
		op1.setContent("内容-op1");
		op1.setQuestionBankId(5);
		Options op2 = new Options();
		op2.setOp("B");
		op2.setContent("内容-op2");
		op2.setQuestionBankId(5);
		Options op3 = new Options();
		op3.setOp("C");
		op3.setContent("内容-op3");
		op3.setQuestionBankId(5);
		Options op4 = new Options();
		op4.setOp("D");
		op4.setContent("内容-op4");
		op4.setQuestionBankId(5);
		
		options.add(op1);
		options.add(op2);
		options.add(op3);
		options.add(op4);
		
		
		int addOptions = questionBankMapper.addOptions(options);
		
		System.out.println(addOptions);
	}
	
	/**
	 * 删除试题测试单元
	 */
	@Test
	public void deleteQuestionBank() {
		qbs.deleteQuestionBank("21");
		
	}
	
	/**
	 * 测试试卷分页
	 */
	@Test
	public void TestPageQuestionBank() {
		List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
	}
	
}


