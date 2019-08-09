package com.resale.background.mapper;

import com.resale.background.pojo.JobLog;
import com.resale.background.pojo.JobLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JobLogMapper {
    long countByExample(JobLogExample example);

    int deleteByExample(JobLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JobLog record);

    int insertSelective(JobLog record);

    List<JobLog> selectByExample(JobLogExample example);

    JobLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JobLog record, @Param("example") JobLogExample example);

    int updateByExample(@Param("record") JobLog record, @Param("example") JobLogExample example);

    int updateByPrimaryKeySelective(JobLog record);

    int updateByPrimaryKey(JobLog record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
}