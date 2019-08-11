package com.resale.background.service;

import java.util.List;
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
	/**
	 * 扣减积分
	 * @param member
	 * @return
	 */
	String deduct(Member member);

	/**
	 * 查询账单列表
	 * @param paramsCondition
	 * @return
	 */
	PageModel getMemberBillList(Map<String, Object> paramsCondition);

	/**
	 * 修改账单流水
	 * @param data
	 */
	void updateMemberBill(List<Map<String, String>> data);
	/**
	 * 修改积分流水
	 * @param data
	 */
	void updateMemberScore(List<Map<String, String>> data);
	/**
	 * 查询积分列表
	 * @param paramsCondition
	 * @return
	 */
	PageModel getMemberScoreList(Map<String, Object> paramsCondition);

	/**
	 * 查询生日提醒列表
	 * @param paramsCondition
	 * @return
	 */
	PageModel getBirthdayList(Map<String, Object> paramsCondition);

	String getTodayNum(Map<String, Object> paramsCondition);

	String getMonthNum(Map<String, Object> paramsCondition);

	String getTodayMoney(Map<String, Object> paramsCondition);

	String getMonthMoney(Map<String, Object> paramsCondition);
	
}
