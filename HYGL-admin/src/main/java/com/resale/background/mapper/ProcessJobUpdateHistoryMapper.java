package com.resale.background.mapper;

import com.resale.background.pojo.ProcessJobUpdateHistory;
import com.resale.background.pojo.ProcessJobUpdateHistoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProcessJobUpdateHistoryMapper {
    long countByExample(ProcessJobUpdateHistoryExample example);

    int deleteByExample(ProcessJobUpdateHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessJobUpdateHistory record);

    int insertSelective(ProcessJobUpdateHistory record);

    List<ProcessJobUpdateHistory> selectByExample(ProcessJobUpdateHistoryExample example);

    ProcessJobUpdateHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessJobUpdateHistory record, @Param("example") ProcessJobUpdateHistoryExample example);

    int updateByExample(@Param("record") ProcessJobUpdateHistory record, @Param("example") ProcessJobUpdateHistoryExample example);

    int updateByPrimaryKeySelective(ProcessJobUpdateHistory record);

    int updateByPrimaryKey(ProcessJobUpdateHistory record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	List<ProcessJobUpdateHistory> findList(Map<String, Object> paramsCondition);
}