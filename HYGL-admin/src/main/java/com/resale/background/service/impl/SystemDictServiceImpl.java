package com.resale.background.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.SystemDictMapper;
import com.resale.background.pojo.SystemDict;
import com.resale.background.service.SystemDictService;
import com.resale.background.util.PageModel;

@Service
public class SystemDictServiceImpl implements SystemDictService {

	@Autowired
	private SystemDictMapper systemDictMapper;
	
	protected final Log logger = LogFactory.getLog(getClass());



	@Override
	public List<Map<String,Object>> findAllSystemDict() {
		return systemDictMapper.findAllSystemDict();
	}



	@Override
	public List<Map<String, Object>> findDictNameByDictType(String dictType) {
		return systemDictMapper.findDictNameByDictType(dictType);
	}
	
	@Override
	public PageModel getSysDictList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = systemDictMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = systemDictMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public void saveSysDict(SystemDict systemDict, int createId) {
		systemDict.setCreateTime(new Date());
		systemDict.setStatus("0");
		systemDictMapper.insert(systemDict);
	}

	@Override
	public SystemDict checkSysDict(Map<String, Object> map) {
		return  this.systemDictMapper.checkIsRepeat(map);
	}

	@Override
	public SystemDict quertDictById(int id) {
		return this.systemDictMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateSysDict(SystemDict dict, int employeeId) {
		systemDictMapper.updateByPrimaryKeySelective(dict);
		
	}

	@Override
	public void deleteSysDict(SystemDict dict, int employeeId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dictId", dict.getDictId());
		map.put("status", "1");
		systemDictMapper.deleteDictById(map);
		
	}

}
