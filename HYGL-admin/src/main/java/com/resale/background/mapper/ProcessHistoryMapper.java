package com.resale.background.mapper;

import com.resale.background.pojo.ProcessHistory;
import com.resale.background.pojo.ProcessHistoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProcessHistoryMapper {
    long countByExample(ProcessHistoryExample example);

    int deleteByExample(ProcessHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessHistory record);

    int insertSelective(ProcessHistory record);

    List<ProcessHistory> selectByExample(ProcessHistoryExample example);

    ProcessHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessHistory record, @Param("example") ProcessHistoryExample example);

    int updateByExample(@Param("record") ProcessHistory record, @Param("example") ProcessHistoryExample example);

    int updateByPrimaryKeySelective(ProcessHistory record);

    int updateByPrimaryKey(ProcessHistory record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
}