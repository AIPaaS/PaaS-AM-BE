package com.ai.paas.cpaas.be.am.dao.interfaces;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ai.paas.cpaas.be.am.dao.mapper.bo.SysCodes;
import com.ai.paas.cpaas.be.am.dao.mapper.bo.SysCodesCriteria;

public interface SysCodesMapper {
    int countByExample(SysCodesCriteria example);

    int deleteByExample(SysCodesCriteria example);

    int insert(SysCodes record);

    int insertSelective(SysCodes record);

    List<SysCodes> selectByExample(SysCodesCriteria example);

    int updateByExampleSelective(@Param("record") SysCodes record, @Param("example") SysCodesCriteria example);

    int updateByExample(@Param("record") SysCodes record, @Param("example") SysCodesCriteria example);
}