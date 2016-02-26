package com.ai.paas.cpaas.be.am.dao.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskDetail;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppTaskDetailCriteria;

public interface AppTaskDetailMapper {
    int countByExample(AppTaskDetailCriteria example);

    int deleteByExample(AppTaskDetailCriteria example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(AppTaskDetail record);

    int insertSelective(AppTaskDetail record);

    List<AppTaskDetail> selectByExample(AppTaskDetailCriteria example);

    AppTaskDetail selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") AppTaskDetail record, @Param("example") AppTaskDetailCriteria example);

    int updateByExample(@Param("record") AppTaskDetail record, @Param("example") AppTaskDetailCriteria example);

    int updateByPrimaryKeySelective(AppTaskDetail record);

    int updateByPrimaryKey(AppTaskDetail record);
}