package com.resale.background.mapper;

import com.resale.background.pojo.WbsSqlLog;
import com.resale.background.pojo.WbsSqlLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WbsSqlLogMapper {
    int countByExample(WbsSqlLogExample example);

    int deleteByExample(WbsSqlLogExample example);

    int insert(WbsSqlLog record);

    int insertSelective(WbsSqlLog record);

    List<WbsSqlLog> selectByExampleWithBLOBs(WbsSqlLogExample example);

    List<WbsSqlLog> selectByExample(WbsSqlLogExample example);

    int updateByExampleSelective(@Param("record") WbsSqlLog record, @Param("example") WbsSqlLogExample example);

    int updateByExampleWithBLOBs(@Param("record") WbsSqlLog record, @Param("example") WbsSqlLogExample example);

    int updateByExample(@Param("record") WbsSqlLog record, @Param("example") WbsSqlLogExample example);
    
    /**
     * 根据日期和类型查询SQL日志
     * @param map
     * @return
     */
    List<Map<String, Object>> getSqlLogByDateAndType(Map<String, Object> map);
    
    /**
     * 根据日期和类型查询SQL日志数目
     */
    long countSqlLogByDateAndType(Map<String, Object> map);
}