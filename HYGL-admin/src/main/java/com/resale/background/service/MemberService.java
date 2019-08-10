package com.resale.background.service;

import java.util.Map;

import com.resale.background.util.PageModel;

public interface MemberService {
	/**
	 * 查询会员列表
	 */
	PageModel getMemberList(Map<String, Object> paramsCondition);
	
}
