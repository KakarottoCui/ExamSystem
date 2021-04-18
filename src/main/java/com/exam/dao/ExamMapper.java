package com.exam.dao;

import java.util.List;

import com.exam.entity.Score;
import com.exam.entity.TestPaper;
import com.exam.entity.Times;
import com.exam.entity.vo.QuestionBankVo;

public interface ExamMapper {

	public List<TestPaper> findAllTestPaper();

	// 查询所有判断题
	public List<QuestionBankVo> findAllJudgmentQuestion(Integer id);

	//用户成绩是否存在
	public Score findIfExistenceScore(Score score);

	// 查询所有选择题
	public List<QuestionBankVo> findAllChoiceQuestion(Integer id);

	// 查询当前用户当前时间
	public Times findExamTimes(Times times);

	// 查询所有用户时间
	public List<Times> findAllExamTimes();

	// 添加当前用户当前时间当前试卷
	public Integer addExamTimes(Times times);

	// 更新当前数据时间-1分钟
	public Integer updateExamTimes(Times times);

}
