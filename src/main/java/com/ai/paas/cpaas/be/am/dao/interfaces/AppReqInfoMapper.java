package com.ai.paas.cpaas.be.am.dao.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppReqInfo;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.AppReqInfoCriteria;

public interface AppReqInfoMapper {
    int countByExample(AppReqInfoCriteria example);

    int deleteByExample(AppReqInfoCriteria example);

    int deleteByPrimaryKey(Integer reqId);

    int insert(AppReqInfo record);

    int insertSelective(AppReqInfo record);

    List<AppReqInfo> selectByExample(AppReqInfoCriteria example);

    AppReqInfo selectByPrimaryKey(Integer reqId);

    int updateByExampleSelective(@Param("record") AppReqInfo record, @Param("example") AppReqInfoCriteria example);

    int updateByExample(@Param("record") AppReqInfo record, @Param("example") AppReqInfoCriteria example);

    int updateByPrimaryKeySelective(AppReqInfo record);

    int updateByPrimaryKey(AppReqInfo record);
}