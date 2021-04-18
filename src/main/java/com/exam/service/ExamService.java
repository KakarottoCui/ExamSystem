package com.exam.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.exam.entity.TestPaper;
import com.exam.entity.vo.QuestionBankVo;

public interface ExamService {

	//查询所有开始考试试卷到前端
	public List<TestPaper> findAllTestPaper();
	
	//查询选择判断题
	public void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session);

	//判题系统
	public List<QuestionBankVo> JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session);

	public boolean autoGenerate(HttpSession session, Integer id);

	
}
