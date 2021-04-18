package com.exam.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dao.ExamMapper;
import com.exam.dao.ScoreMapper;
import com.exam.entity.Score;
import com.exam.entity.TestPaper;
import com.exam.entity.Times;
import com.exam.entity.Users;
import com.exam.entity.vo.QuestionBankVo;
import com.exam.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private ScoreMapper scoreMapper;

	// 查询所有开始考试试卷到前端
	public List<TestPaper> findAllTestPaper() {

		List<TestPaper> allTestPaper = examMapper.findAllTestPaper();
		return allTestPaper;
	}

	// 查询题目
	@Override
	public void findJudgmentQuestionAndChoiceQuestion(ModelAndView modelAndView, String id, HttpSession session) {

		/**
		 * 查询是否存在成绩
		 */
		Score score = new Score();
		score.setTestpaperId(Integer.parseInt(id));
		Users users = (Users) session.getAttribute("myUser");
		score.setUsersId(users.getUserId());
		Score ifExistenceScore = examMapper.findIfExistenceScore(score);
		if (ifExistenceScore != null) {
			modelAndView.addObject("Fraction", ifExistenceScore.getFraction());
			modelAndView.setViewName("_exam/score");
			return;
		}

		session.setAttribute("testpaperId", id);

		List<QuestionBankVo> findAllJudgmentQuestion = examMapper.findAllJudgmentQuestion(Integer.parseInt(id));// 判断题
		for (QuestionBankVo questionBankVo : findAllJudgmentQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
		}

		List<QuestionBankVo> findAllChoiceQuestion = examMapper.findAllChoiceQuestion(Integer.parseInt(id));// 选择题
		for (QuestionBankVo questionBankVo : findAllChoiceQuestion) {
			session.setAttribute(questionBankVo.getQuestionBankId().toString(), questionBankVo.getAnswer());
		}

		Times times = new Times();// 当前试卷-当前用户的试卷如果没时间设置时间
		times.setUserId(users.getUserId());
		times.setTestpaperId(Integer.parseInt(id));
		Times ifExamTimes = examMapper.findExamTimes(times);
		if (ifExamTimes == null) {
			times.setDataMin(60.0);
			examMapper.addExamTimes(times);
			session.setAttribute("ExamTime", "60");
		} else {
			session.setAttribute("ExamTime", String.valueOf(ifExamTimes.getDataMin().intValue()));
		}

		modelAndView.addObject("JudgmentQuestion", findAllJudgmentQuestion);
		modelAndView.addObject("ChoiceQuestion", findAllChoiceQuestion);
		modelAndView.setViewName("_exam/exam");
	}

	/**
	 * 判题方法
	 */
	@Override
	public List<QuestionBankVo> JudgmentSystem(List<QuestionBankVo> questionBankVos, HttpSession session) {
		double fraction = 0;
		for (QuestionBankVo questionBankVo : questionBankVos) {
			if (questionBankVo.getAnswer() != null) {
				if (session.getAttribute(questionBankVo.getQuestionBankId().toString())
						.equals(questionBankVo.getAnswer())) {
					fraction = fraction + 10;
					questionBankVo.setIfCorrect(true);
				} else {
					questionBankVo.setIfCorrect(false);
					questionBankVo
							.setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
				}
			} else {
				questionBankVo.setIfCorrect(false);
				questionBankVo
						.setAnswer(session.getAttribute(questionBankVo.getQuestionBankId().toString()).toString());
			}
		}
		Score score = new Score();
		score.setTestpaperId(Integer.parseInt(session.getAttribute("testpaperId").toString()));
		score.setUsersId(((Users) session.getAttribute("myUser")).getUserId());
		score.setFraction(fraction);
		int insertSelective = scoreMapper.insertSelective(score);
		if (insertSelective == 0) {// 设置分数是否成功
			return null;
		}

		return questionBankVos;// 返回状态
	}

	/**
	 * 自动生成试卷
	 */
	@Override
	public boolean autoGenerate(HttpSession session, Integer id) {
		// 判断题
		List<QuestionBankVo> findAllJudgmentQuestion = examMapper.findAllJudgmentQuestion(id);

		// 选择题
		List<QuestionBankVo> findAllChoiceQuestion = examMapper.findAllChoiceQuestion(id);
		if (findAllChoiceQuestion.size() >= 5 && findAllChoiceQuestion.size() >= 5) {
			HashMap<String, List<QuestionBankVo>> hashMap = new HashMap<String, List<QuestionBankVo>>();
			hashMap.put("JudgmentQuestion", findAllJudgmentQuestion);
			hashMap.put("ChoiceQuestion", findAllChoiceQuestion);
			session.setAttribute("question", hashMap);
			session.setAttribute("XiaoBing", "XiaoBingBy");
			session.setAttribute("JudgmentQuestion", findAllJudgmentQuestion);
			session.setAttribute("ChoiceQuestion", findAllChoiceQuestion);
			// 存入时间
			// 初始化成绩
			return true;
		}

		return false;
	}

}
