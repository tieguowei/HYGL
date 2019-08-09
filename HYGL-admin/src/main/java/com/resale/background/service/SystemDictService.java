package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.SystemDict;
import com.resale.background.util.PageModel;

public interface SystemDictService {

	List<Map<String,Object>> findAllSystemDict();

	/**
	 *根据字典类型 查询列表
	 * @param dictType
	 * @return
	 */
	List<Map<String, Object>> findDictNameByDictType(String dictType);
	
	/***
	 * 查询列表数据
	 * @return
	 */
	public PageModel getSysDictList(Map<String, Object> paramsCondition);
	/**
	 * 添加字典
	 * @param systemDict
	 * @param dictId
	 */
	public void saveSysDict(SystemDict systemDict, int dictId);
	/**
	 * 根据字典编号，字典类型，字典名称是否已经存在
	 * @param map
	 * @return
	 */
	public SystemDict checkSysDict(Map<String, Object> map);
	/**
	 * 查询字典信息
	 * @param id
	 * @return
	 */
	public SystemDict quertDictById(int id);
	/**
	 * 修改字典信息
	 * @param dict
	 * @param employeeId
	 */
	public void updateSysDict(SystemDict dict, int employeeId);
	
	/**
	 * 删除字典  ---修改状态
	 * @param dict
	 * @param employeeId
	 */
	public void deleteSysDict(SystemDict dict, int employeeId);
	



}
