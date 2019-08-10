package com.resale.background.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.base.controller.BaseController;
import com.resale.background.pojo.Employee;
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
	 * 跳转到员工列表页面
	 * 
	 * @return
	 */
	@RequiresPermissions("memberManager:list") // 权限管理;
	@RequestMapping("/goMemberPage")
	public String goMemberPage() {
		return "system/member/memberList";
	}

	/**
	 * 分页查询所有员工
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
			String employeeNo = StringUtil.trim(request.getParameter("employeeNo"));
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


}
