package com.exam.time;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.dao.ExamMapper;
import com.exam.dao.ScoreMapper;
import com.exam.entity.Score;
import com.exam.entity.Times;

/**
 * 定时器
 */
public class ExamTask {

	@Autowired
	private ExamMapper examMapper;
	@Autowired
	private ScoreMapper scoreMapper;
	
	/**
	 * 更新考试时间
	 */
	public void updateTime() {
		//所有用户时间
		List<Times> allExamTimes = examMapper.findAllExamTimes();
		//更新用户时间-1分钟
		for (Times times : allExamTimes) {
			Double dataMin = times.getDataMin();
			dataMin--;
			times.setDataMin(dataMin);
			examMapper.updateExamTimes(times);
			/**
			 * 时间到。更新时间如果没成绩设置0分
			 */
			if (dataMin == -1) {
				Score score = new Score();
				score.setUsersId(times.getUserId());
				score.setTestpaperId(times.getTestpaperId());
				Score ifExistenceScore = examMapper.findIfExistenceScore(score);
				if (ifExistenceScore == null) {//如果空 设置成绩0分
					Score record = new Score();
					record.setTestpaperId(times.getTestpaperId());
					record.setUsersId(times.getUserId());
					record.setFraction(0.0);
					scoreMapper.insertSelective(record);
				}
				//更新考试时间无效
				times.setTimesState(0);
				examMapper.updateExamTimes(times);
			}
			
			
			
		}
		
	}

}
