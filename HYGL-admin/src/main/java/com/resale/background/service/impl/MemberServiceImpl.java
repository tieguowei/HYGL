package com.resale.background.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resale.background.mapper.MemberBillMapper;
import com.resale.background.mapper.MemberMapper;
import com.resale.background.mapper.MemberScoreMapper;
import com.resale.background.pojo.Member;
import com.resale.background.pojo.MemberBill;
import com.resale.background.pojo.MemberScore;
import com.resale.background.service.MemberService;
import com.resale.background.util.PageModel;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberBillMapper memberBillMapper;
	@Autowired
	private MemberScoreMapper memberScoreMapper;
	@Override
	public PageModel getMemberList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = memberMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = memberMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public void saveMember(Member member) {
		memberMapper.insertSelective(member);
	}

	@Override
	public Member getMemberById(int memberId) {
		return memberMapper.selectByPrimaryKey(memberId);
	}

	@Override
	public void updateMember(Member member) {
		memberMapper.updateByPrimaryKeySelective(member);
		
	}

	@Override
	public void deleteMember(Member member) {
		memberMapper.deleteMember(member);
	}

	@Override
	@Transactional
	public void recharge(Member member) {
		//修改总金额 -  可用余额
		memberMapper.updateTotalMoney(member);
		MemberBill bill  = buildBill(member,"0");
		//记录充值流水
		memberBillMapper.insertSelective(bill);
	}

	private MemberBill buildBill(Member member,String type) {
		MemberBill bill = new MemberBill();
		bill.setBillMoney(member.getTotalMoney());
		bill.setBillRemark(member.getRemark());
		bill.setBillType(type);	
		bill.setCreateTime(new Date());
		bill.setMemberId(member.getMemberId());	
		bill.setOperator(member.getOperator());
		return bill;
	}

	@Override
	@Transactional
	public String consume(Member member) {
		//校验密码
		Member oldMember =  memberMapper.checkPwd(member);
		if(null == oldMember){
			return "2";
		}
		//余额不足
		BigDecimal totalMoney = member.getTotalMoney();
		BigDecimal 	residueMoney  = oldMember.getResidueMoney();
		if(totalMoney.compareTo(residueMoney) == 1){
			return "3";
		}
		//修改可用余额
		memberMapper.updateResidueMoney(member);
		MemberBill bill  = buildBill(member,"1");
		//记录消费流水
		memberBillMapper.insertSelective(bill);
		//新增积分流水
		MemberScore record = buildScore(member,"0",member.getTotalMoney().intValue());
		memberScoreMapper.insertSelective(record);
		return "1";
	}

	private MemberScore buildScore(Member member,String type,int jf) {
		MemberScore score = new MemberScore();
		score.setMemberId(member.getMemberId());
		score.setOperator(member.getOperator());
		score.setScoreType(type);
		score.setCreateTime(new Date());
		score.setScore(jf);
		score.setScoreRemark(member.getRemark());
		return score;
	}

	@Override
	@Transactional
	public String deduct(Member member) {
		//校验密码
		Member oldMember =  memberMapper.checkPwd(member);
		if(null == oldMember){
			return "2";
		}
		//积分不足
		int  AggregateScore = member.getAggregateScore();
		int residueScore  = oldMember.getResidueScore();
		if(AggregateScore > residueScore){
			return "3";
		}
		//修改可用积分
		memberMapper.updateResidueScore(member);
		//新增扣减积分流水
		MemberScore record = buildScore(member,"1",AggregateScore);
		memberScoreMapper.insertSelective(record);
		return "1";
	}

	@Override
	public PageModel getMemberBillList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = memberBillMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = memberBillMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public void updateMemberBill(List<Map<String, String>> data) {
		memberBillMapper.updateMemberBill(data);
	}

	@Override
	public void updateMemberScore(List<Map<String, String>> data) {
		memberScoreMapper.updateMemberScore(data);
	}

	@Override
	public PageModel getMemberScoreList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = memberScoreMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = memberScoreMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public PageModel getBirthdayList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = memberMapper.findBirthdayAllRetMapByPage(paramsCondition);
		Long totalRecords = memberMapper.findBirthdayAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

}
