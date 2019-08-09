package com.resale.background.mapper;

import com.resale.background.pojo.ProcessConfig;
import com.resale.background.pojo.ProcessConfigExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProcessConfigMapper {
    long countByExample(ProcessConfigExample example);

    int deleteByExample(ProcessConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessConfig record);

    int insertSelective(ProcessConfig record);

    List<ProcessConfig> selectByExample(ProcessConfigExample example);

    ProcessConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessConfig record, @Param("example") ProcessConfigExample example);

    int updateByExample(@Param("record") ProcessConfig record, @Param("example") ProcessConfigExample example);

    int updateByPrimaryKeySelective(ProcessConfig record);

    int updateByPrimaryKey(ProcessConfig record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	void deleteProcessByOperator(String name);


	Map<String, Object> selectProcessByNameAndType(ProcessConfig processConfig);

	Map<String, Object> findProcessByIdAndStatus(ProcessConfig processConfig);

	List<ProcessConfig> findProcessConfig(Map<String,Object> map);
	
	List<ProcessConfig> findList(Map<String, Object> paramsCondition);

	Map<String, Object> checkStartRunStatus(Map<String, Object> map);

	List<Map<String, Object>> findRunningProcessConfig(Map<String, Object> map);
	
	List<Map<String, Object>> findByParams(Map<String, Object> paramsCondition);

	void insertAndReturnLastId(ProcessConfig processConfig);

	void updateByMap(Map<String, Object> map);

}