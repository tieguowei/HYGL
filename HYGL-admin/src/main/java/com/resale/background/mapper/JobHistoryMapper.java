package com.resale.background.mapper;

import com.resale.background.pojo.JobHistory;
import com.resale.background.pojo.JobHistoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JobHistoryMapper {
    long countByExample(JobHistoryExample example);

    int deleteByExample(JobHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JobHistory record);

    int insertSelective(JobHistory record);

    List<JobHistory> selectByExample(JobHistoryExample example);

    JobHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JobHistory record, @Param("example") JobHistoryExample example);

    int updateByExample(@Param("record") JobHistory record, @Param("example") JobHistoryExample example);

    int updateByPrimaryKeySelective(JobHistory record);

    int updateByPrimaryKey(JobHistory record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	void insertBatch(List<JobHistory> list);

	void updateByParams(JobHistory jh);

	List<JobHistory> findList(Map<String, Object> jobParams);

	List<Map<String, Object>> findJobHistoryListByProcessId(Map<String, Object> map);

	List<Map<String, Object>> findByParams(Map<String, Object> paramsCondition);
}