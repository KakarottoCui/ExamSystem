package com.exam.dao;

import com.exam.entity.Options;

public interface OptionsMapper {
    int deleteByPrimaryKey(Integer optionsId);

    int insert(Options record);

    int insertSelective(Options record);

    Options selectByPrimaryKey(Integer optionsId);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKeyWithBLOBs(Options record);

    int updateByPrimaryKey(Options record);
}