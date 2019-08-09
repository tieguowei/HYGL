package com.resale.background.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.resale.background.pojo.SystemDict;
import com.resale.background.pojo.SystemDictExample;

public interface SystemDictMapper {
    int countByExample(SystemDictExample example);

    int deleteByExample(SystemDictExample example);

    int deleteByPrimaryKey(Integer dictId);

    int insert(SystemDict record);

    int insertSelective(SystemDict record);

    List<SystemDict> selectByExample(SystemDictExample example);

    SystemDict selectByPrimaryKey(Integer dictId);

    int updateByExampleSelective(@Param("record") SystemDict record, @Param("example") SystemDictExample example);

    int updateByExample(@Param("record") SystemDict record, @Param("example") SystemDictExample example);

    int updateByPrimaryKeySelective(SystemDict record);

    int updateByPrimaryKey(SystemDict record);

	List<Map<String, Object>> findAllSystemDict();
	//根据字典类型查询
	List<Map<String, Object>> findDictNameByDictType(String dictType);
	
	void deleteDictById(Map<String, Object> map);
	
	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
	
	SystemDict checkIsRepeat(Map<String, Object> map);


}