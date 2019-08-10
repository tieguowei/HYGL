package com.resale.background.service;

import java.util.Map;

import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Member;
import com.resale.background.util.PageModel;

public interface MemberService {
	/**
	 * 查询会员列表
	 */
	PageModel getMemberList(Map<String, Object> paramsCondition);

	/**
	 * 添加会员
	 * @param member
	 */
	void saveMember(Member member);
	/**
	 * 查询会员
	 * @param member
	 */
	Member getMemberById(int memberId);

	/**
	 * 修改会员信息
	 * @param member
	 */
	void updateMember(Member member);

	/**
	 * 删除会员
	 * @param member
	 */
	void deleteMember(Member member);

	/**
	 * 充值
	 * @param member
	 * @return
	 */
	void recharge(Member member);
	/**
	 * 消费
	 * @param member
	 * @return
	 */
	String consume(Member member);
	
}
