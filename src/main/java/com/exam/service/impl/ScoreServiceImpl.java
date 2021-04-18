package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.ScoreMapper;
import com.exam.entity.vo.scoreVo;
import com.exam.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreMapper scoreMapper;
	@Override
	public List<scoreVo> findUserExamInfo() {
		return scoreMapper.findUserExamInfo();
	}

}
