package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.QuestionBankMapper;
import com.exam.entity.Options;
import com.exam.entity.vo.QuestionBankVo;
import com.exam.service.QuestionBankService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 题库业务类
 */
@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	private QuestionBankMapper questionBankMapper;
	
	/**
	 * 查询所有试题
	 */
	@Override
	public PageInfo<QuestionBankVo> findAllQuestionBank(PageInfo<QuestionBankVo> pageInfo) {
		
		PageHelper.startPage(pageInfo.getPageNum()==0?1:pageInfo.getPageNum(), 40);
		
		List<QuestionBankVo> AllQuestionBank = questionBankMapper.findAllQuestionBank();
		
		PageInfo<QuestionBankVo> pageInfoQuestionBank = new PageInfo<QuestionBankVo>(AllQuestionBank);
		
		return pageInfoQuestionBank;
	}

	//添加题
	@Override
	public boolean addQuestionBank(QuestionBankVo questionBankVo) {
		//设置提状态
		questionBankVo.setState(1);//设置数据有效
		int questionBankState = questionBankMapper.addQuestionBank(questionBankVo);
		if (questionBankVo.getTestsType() == 0) {
			if (questionBankState >= 1) {
				return true;
			}
		}
		
		for (Options op : questionBankVo.getOptions()) {
			op.setQuestionBankId(questionBankVo.getQuestionBankId());
		}
		
		int optionsState = questionBankMapper.addOptions(questionBankVo.getOptions());
		
		if (questionBankState >= 1 && optionsState >= 1) {
			return true;
		}
		
		return false;
	}

	/**
	 * 删除试题
	 */
	@Override
	public boolean deleteQuestionBank(String questionBankId) {
		
		int updateQuestionBankState = questionBankMapper.updateQuestionBankState(questionBankId);
		if (updateQuestionBankState >= 1) {
			return true;
		}
		
		return false;
	}

	/**
	 * 更新题目
	 */
	@Override
	public boolean updateQuestionBank(QuestionBankVo questionBankVo) {
		
		Integer testsType = questionBankVo.getTestsType();
		int updateQuestionBank = questionBankMapper.updateQuestionBank(questionBankVo);
		if (updateQuestionBank >= 1) {
			questionBankMapper.deleteQuestionBankOptions(questionBankVo.getQuestionBankId().toString());
			if (testsType == 1) {
				for (Options op : questionBankVo.getOptions()) {
					op.setQuestionBankId(questionBankVo.getQuestionBankId());
				}
				questionBankMapper.addOptions(questionBankVo.getOptions());
			}
			return true;
		}
		
		return false;
	}

}
