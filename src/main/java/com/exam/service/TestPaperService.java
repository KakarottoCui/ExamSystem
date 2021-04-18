package com.exam.service;

import java.util.List;

import com.exam.entity.TestPaper;
import com.exam.entity.vo.QuestionBankVo;
import com.github.pagehelper.PageInfo;

public interface TestPaperService {
    //查询所有有效试卷
    List<TestPaper> findTestPaperInfo();
    //更改试卷状态
    int updateTestPaperState(int testpaperId);
    //根据id查询试卷信息
    TestPaper selectByPrimaryKey(Integer testpaperId);
    
    //编辑试卷信息
    int updateTestPaperInfo(TestPaper testPaper);
    
    //查询所有题库
  	public List<QuestionBankVo> findAllQuestionBank();
}
