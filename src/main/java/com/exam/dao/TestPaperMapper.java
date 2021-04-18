package com.exam.dao;

import java.util.List;

import com.exam.entity.TestPaper;

public interface TestPaperMapper {
    int deleteByPrimaryKey(Integer testpaperId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(Integer testpaperId);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
    
    
    //查询所有有效试卷
    List<TestPaper> findTestPaperInfo();
    
    //更改试卷状态
    int updateTestPaperState(int testpaperId);
    //编辑试卷信息
    int updateTestPaperInfo(TestPaper testPaper);
    
}