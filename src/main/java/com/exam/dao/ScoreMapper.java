package com.exam.dao;

import java.util.List;

import com.exam.entity.Score;
import com.exam.entity.vo.scoreVo;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer scoreId);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer scoreId);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    
    //查询所有考生成绩信息
    List<scoreVo> findUserExamInfo();
    
}