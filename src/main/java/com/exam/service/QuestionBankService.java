package com.exam.service;

import com.exam.entity.vo.QuestionBankVo;
import com.github.pagehelper.PageInfo;

/**
 * 题库业务类
 */
public interface QuestionBankService {

	//查询所有试题
	public PageInfo<QuestionBankVo> findAllQuestionBank(PageInfo<QuestionBankVo> pageInfo);
	
	//添加题
	public boolean addQuestionBank(QuestionBankVo questionBankVo);

	//删除题目
	public boolean deleteQuestionBank(String questionBankId);
	
	//更新题目
	public boolean updateQuestionBank(QuestionBankVo questionBankVo);
	
}
