package com.resale.background.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.MemberMapper;
import com.resale.background.service.MemberService;
import com.resale.background.util.PageModel;
@Service
public class MemberServiceImpl implements MemberService {


	@Autowired
	private MemberMapper membereeMapper;
	
	@Override
	public PageModel getMemberList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = membereeMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = membereeMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

}
