package com.resale.background.mapper;

import com.resale.background.pojo.ProcessJobRelation;
import com.resale.background.pojo.ProcessJobRelationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProcessJobRelationMapper {
    long countByExample(ProcessJobRelationExample example);

    int deleteByExample(ProcessJobRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessJobRelation record);

    int insertSelective(ProcessJobRelation record);

    List<ProcessJobRelation> selectByExample(ProcessJobRelationExample example);

    ProcessJobRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessJobRelation record, @Param("example") ProcessJobRelationExample example);

    int updateByExample(@Param("record") ProcessJobRelation record, @Param("example") ProcessJobRelationExample example);

    int updateByPrimaryKeySelective(ProcessJobRelation record);

    int updateByPrimaryKey(ProcessJobRelation record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	List<Map<String, Object>> findLastJobByProcessId(Map<String,Object> map);

	Map<String, Object> findRelationById(Integer id);

	void deleteByProcessId(Integer processId);

	List<Map<String, Object>> findFirstJob(Map<String, Object> params);

	void deleteJobRelation(Map<String, Object> map);

	List<Map<String, Object>> findListOrderByLevel(Map<String, Object> params);

	String findNextLevel(Map<String, Object> map);

	List<Map<String, Object>> findByParams(Map<String, Object> paramsCondition);

	void insertAndReturnLastId(ProcessJobRelation relation);

}