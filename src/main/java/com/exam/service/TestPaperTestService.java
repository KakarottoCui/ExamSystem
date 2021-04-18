package com.exam.service;

import java.util.List;

import com.exam.entity.TestPaperTests;
import com.exam.entity.TestPaperTestsList;
import com.exam.entity.vo.TestPaperTestsVo;

public interface TestPaperTestService {
	
    //根据试卷id查询试卷试题
 
    List<TestPaperTestsVo> findSelectTestPaperQuesion(int testpaperId);
    //根据试卷id删除试卷试题表信息
    
    int deleteTestPaperTestById(int testpaperId);
    
    //添加试卷试题
    
    int addTestPaperQuestion(TestPaperTestsList testPaperTestsList);

}
