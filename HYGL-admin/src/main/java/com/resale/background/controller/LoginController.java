package com.resale.background.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.resale.background.base.controller.BaseController;
import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Menu;
import com.resale.background.service.MenuService;

/**
 * <dl>
 * <dt>类名：LoginController.java</dt>
 * <dd>描述: 登录管理逻辑实现</dd>
 * <dd>创建时间： 2018年8月13日 下午5:20:33</dd>
 * <dd>创建人： TieGuowei</dd>
 * <dt>版本历史:</dt>
 * 
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月13日 下午5:20:33    TieGuowei       1.0        1.0 Version
 * </pre>
 * </dl>
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	private MenuService menuService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据商户id获取所拥有的菜单
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping({ "/", "/indexPage" })
	public String index(Model model) {
		try {
			Employee employee = getCurrentEmployee();
			List<Menu> menuList = menuService.getMenuByEmployeeId(employee.getEmployeeId());
			model.addAttribute("mlist", menuList);
			model.addAttribute("employee", employee);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "index";
		}

	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
		// 登录失败从request中获取shiro处理的异常信息。
		String exception = (String) request.getAttribute("shiroLoginFailure");
		// 进行验证码校验
		String msg = "";
		if (exception != null) {
			logger.info("shiro验证授权 异常信息：" + exception);
			if (UnknownAccountException.class.getName().equals(exception)) {
				msg = "<font color='red' size='2px' >账号验证失败或已被禁用！</font>";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				msg = "<font color='red' size='2px' >密码不正确！</font>";
			} else if ("randomCodeError".equals(exception)) {
				msg = "<font color='red' size='2px' >验证码有误！</font>";
			} else {
				msg = "<font color='red' size='2px' >系统异常！</font>";
			}
		}
		map.put("msg", msg);
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		// 登陆失败还到login页面
		return "/login";
	}

	@RequestMapping("/403")
	public String unauthorizedRole() {
		return "403";
	}

}
