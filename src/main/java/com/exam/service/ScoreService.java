package com.exam.service;

import java.util.List;

import com.exam.entity.vo.scoreVo;;

public interface ScoreService {
    //查询所有考生成绩信息
    List<scoreVo> findUserExamInfo();

}
