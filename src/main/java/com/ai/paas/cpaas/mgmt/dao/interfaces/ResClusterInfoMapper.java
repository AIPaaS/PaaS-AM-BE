package com.ai.paas.cpaas.mgmt.dao.interfaces;

import com.ai.paas.cpaas.mgmt.dao.mapper.bo.ResClusterInfo;
import com.ai.paas.cpaas.mgmt.dao.mapper.bo.ResClusterInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResClusterInfoMapper {
    int countByExample(ResClusterInfoCriteria example);

    int deleteByExample(ResClusterInfoCriteria example);

    int deleteByPrimaryKey(String clusterId);

    int insert(ResClusterInfo record);

    int insertSelective(ResClusterInfo record);

    List<ResClusterInfo> selectByExample(ResClusterInfoCriteria example);

    ResClusterInfo selectByPrimaryKey(String clusterId);

    int updateByExampleSelective(@Param("record") ResClusterInfo record, @Param("example") ResClusterInfoCriteria example);

    int updateByExample(@Param("record") ResClusterInfo record, @Param("example") ResClusterInfoCriteria example);

    int updateByPrimaryKeySelective(ResClusterInfo record);

    int updateByPrimaryKey(ResClusterInfo record);
}