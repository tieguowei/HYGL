package com.resale.background.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.base.controller.BaseController;
import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Member;
import com.resale.background.service.MemberService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

/**
 * <dl>
 * <dt>类名：MemberController.java</dt>
 * <dd>描述:会员管理逻辑实现</dd>
 * <dd>创建时间： 2018年8月6日 下午5:33:38</dd>
 * <dd>创建人： TieGuowei</dd>
 * <dt>版本历史:</dt>
 * 
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月6日 下午5:33:38    TieGuowei       1.0        1.0 Version
 * </pre>
 * </dl>
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Autowired
	private MemberService memberService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 跳转到会员列表页面
	 * 
	 * @return
	 */
	@RequiresPermissions("memberManager:list") // 权限管理;
	@RequestMapping("/goMemberPage")
	public String goMemberPage() {
		return "member/memberList";
	}

	/**
	 * 分页查询会员
	 * 
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMemberList")
	public DataMsg getMemberList(HttpServletRequest request, DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			Employee employee = getCurrentEmployee();
			if(!"admin".equals(employee.getEmployeeNo())){
				paramsCondition.put("operator", employee.getEmployeeId());
			}
			String memberName = StringUtil.trim(request.getParameter("memberName"));
			if (StringUtil.isNotBlank(memberName)) {
				paramsCondition.put("memberName", memberName);
			}
			String memberPhone = StringUtil.trim(request.getParameter("memberPhone"));
			if (StringUtil.isNotBlank(memberPhone)) {
				paramsCondition.put("memberPhone", memberPhone);
			}
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel = memberService.getMemberList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}

	/**
	 * 添加会员
	 * @return
	 */
	@RequestMapping("/saveMember")
	@ResponseBody
	public boolean saveMember(Member member, @RequestParam("entryDate") String entryDate) {
		try {
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			if (StringUtil.isNotEmpty(entryDate)) {
				member.setMemberBirthday(date.parse(entryDate));
			}
			Employee employee =getCurrentEmployee();
			member.setMemberNo(getRandom());
			member.setOperator(employee.getEmployeeId());
			member.setCreateTime(new Date());
			member.setMemberStatus("0");
			memberService.saveMember(member);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 修改会员回显
	 */
	@RequestMapping("/getMemberById")
	@ResponseBody
	public Map<String, Object> getMemberById(@RequestParam("memberId") int memberId) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Member member = memberService.getMemberById(memberId);
			map.put("member", member);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	};

	/**
	 * 修改会员信息
	 */
	@RequestMapping("/updateMember")
	@ResponseBody
	public boolean updateMember(Member member, @RequestParam("entryDate") String entryDate) {
		try {
			if("1".equals(member.getIsResetPwd())){
				member.setMemberPwd("000000");
			}
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			if (StringUtil.isNotEmpty(entryDate)) {
				member.setMemberBirthday(date.parse(entryDate));
			}
			Employee employee =getCurrentEmployee();
			member.setOperator(employee.getEmployeeId());
			memberService.updateMember(member);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	};
	
	/**
	 * 删除会员
	 */
	@ResponseBody
	@RequestMapping("/deleteMember")
	public boolean deleteMember(Member member) {
		try {
			memberService.deleteMember(member);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	};
	
	/**
	 * 充值
	 */
	@RequestMapping("/recharge")
	@ResponseBody
	public boolean recharge(Member member) {
		try {
			Employee employee = getCurrentEmployee();
			member.setOperator(employee.getEmployeeId());
			memberService.recharge(member);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	};


	/**
	 * 充值
	 */
	@RequestMapping("/consume")
	@ResponseBody
	public String consume(Member member) {
		try {
			Employee employee = getCurrentEmployee();
			member.setOperator(employee.getEmployeeId());
			String result = memberService.consume(member);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	};
	public String getRandom(){
		Random random = new Random();
		DecimalFormat df = new DecimalFormat("00");
		String no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + df.format(random.nextInt(20));
		return no;
	}

}
