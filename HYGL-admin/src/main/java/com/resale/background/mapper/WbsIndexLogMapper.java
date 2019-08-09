package com.resale.background.mapper;

import com.resale.background.pojo.WbsIndexLog;
import com.resale.background.pojo.WbsIndexLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WbsIndexLogMapper {
    int countByExample(WbsIndexLogExample example);

    int deleteByExample(WbsIndexLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WbsIndexLog record);

    int insertSelective(WbsIndexLog record);

    List<WbsIndexLog> selectByExample(WbsIndexLogExample example);

    WbsIndexLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WbsIndexLog record, @Param("example") WbsIndexLogExample example);

    int updateByExample(@Param("record") WbsIndexLog record, @Param("example") WbsIndexLogExample example);

    int updateByPrimaryKeySelective(WbsIndexLog record);

    int updateByPrimaryKey(WbsIndexLog record);
    
    /**
     * 根据日期和类型查询CRM系统的访问日志
     */
    List<Map<String, Object>> getByDateAndContent(Map<String, Object> params);
    
    /**
     * 根据日期和类型查询CRM系统的导出次数
     */
    long countByDateAndContent(Map<String, Object> params);
    
    /**
     * 查询CRM导出和Log日志数目列表
     */
    List<Map<String, Object>> getLogCountList();
}