package com.resale.background.mapper;

import com.resale.background.pojo.JobBasic;
import com.resale.background.pojo.JobBasicExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JobBasicMapper {
    long countByExample(JobBasicExample example);

    int deleteByExample(JobBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JobBasic record);

    int insertSelective(JobBasic record);

    List<JobBasic> selectByExample(JobBasicExample example);

    JobBasic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JobBasic record, @Param("example") JobBasicExample example);

    int updateByExample(@Param("record") JobBasic record, @Param("example") JobBasicExample example);

    int updateByPrimaryKeySelective(JobBasic record);

    int updateByPrimaryKey(JobBasic record);

	List<Map<String, Object>> findJobBasicList();

	String findJobNamesByIds(Map<String, Object> request);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	JobBasic checkJobBasic(Map<String, Object> map);

	void deleteJobBasicById(Map<String, Object> map);

	JobBasic selectMaxJobNumber(JobBasic jobBasic);

	void insertJobBasic(List<JobBasic> resultList);

	Map<String, Object> findJobBasicAndRelation(Map<String, Object> map);
}