package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.base.controller.BaseController;
import com.resale.background.pojo.Employee;
import com.resale.background.pojo.SystemDict;
import com.resale.background.service.SystemDictService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

/**
 * 字典管理
 * 
 * @author huliping
 * @Date 2019/4/3
 *
 */
@Controller
@RequestMapping("/systemDict")
public class SystemDictController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SystemDictService systemDictService;

	/**
	 * 通过dictType查询字典
	 * 
	 * @return
	 */
	@RequestMapping("/findDictNameByDictType")
	@ResponseBody
	public List<Map<String, Object>> findDictNameByDictType(@RequestParam("dictType") String dictType) {
		try {
			return systemDictService.findDictNameByDictType(dictType);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("查询字典数据错误！");
		}
		return null;
	}

	/**
	 * 跳转到字典列表页面
	 * 
	 * @return
	 */
	@RequiresPermissions("systemDictManager:list")
	@RequestMapping("/goSysDictPage")
	public String goSysDictPage() {
		return "system/dict/sysDictList";
	}

	/**
	 * 查询所有字典 分页
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSysDictList")
	public DataMsg getSysDictList(HttpServletRequest request, DataMsg dataMsg) {
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			if (StringUtils.isNoneBlank(request.getParameter("dictName"))) {
				paramsCondition.put("dictName", request.getParameter("dictName"));
			}
			if (StringUtils.isNoneBlank(request.getParameter("dictType"))) {
				paramsCondition.put("dictType", request.getParameter("dictType"));
			}

			PageModel pageModel = systemDictService.getSysDictList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return dataMsg;
	}

	/**
	 * 添加字典
	 * 
	 * @param SysDict
	 * @return
	 */
	@RequiresPermissions("systemDictManager:add")
	@ResponseBody
	@RequestMapping("/saveSysDict")
	public boolean saveSysDict(SystemDict sysDict) {
		try {
			Employee employee = getCurrentEmployee();
			int employeeId = employee.getEmployeeId();
			systemDictService.saveSysDict(sysDict, employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 修改回显
	 */

	@ResponseBody
	@RequestMapping("/getDictById")
	public Map<String, Object> getRoleById(@RequestParam("dictId") int id, Model model) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			SystemDict sysDict = this.systemDictService.quertDictById(id);
			map.put("sysDict", sysDict);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验字典类型、字典编码、名称是否存在
	 * 
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkSysDict")
	public boolean checkSysDict(HttpServletRequest request) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String dictCode = StringUtil.trim(request.getParameter("dictCode"));
			if (StringUtil.isNotBlank(dictCode)) {
				map.put("dictCode", dictCode);
			}
			String dictName = StringUtil.trim(request.getParameter("dictName"));
			if (StringUtil.isNotBlank(dictName)) {
				map.put("dictName", dictName);
			}

			String dictType = StringUtil.trim(request.getParameter("dictType"));
			if (StringUtil.isNotBlank(dictType)) {
				map.put("dictType", dictType);
			}

			String dictId = StringUtil.trim(request.getParameter("dictId"));
			if (StringUtil.isNotBlank(dictId)) {
				map.put("dictId", dictId);
			}

			SystemDict result = this.systemDictService.checkSysDict(map);
			if (result == null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 修改
	 * 
	 * @param role
	 * @return
	 */
	@RequiresPermissions("systemDictManager:update")
	@ResponseBody
	@RequestMapping("/updateSysDict")
	public boolean updateSysDict(SystemDict dict) {
		try {
			Employee employee = getCurrentEmployee();
			int employeeId = employee.getEmployeeId();
			this.systemDictService.updateSysDict(dict, employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 删除
	 * 
	 * @param role
	 * @return
	 */
	@RequiresPermissions("systemDictManager:delete")
	@ResponseBody
	@RequestMapping("/deleteSysDict")
	public boolean deleteSysDict(SystemDict dict) {
		try {
			Employee employee = getCurrentEmployee();
			int employeeId = employee.getEmployeeId();
			this.systemDictService.deleteSysDict(dict, employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}