
package com.resale.background.base.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.resale.background.pojo.Employee;




/**
*<dl>
*<dt>类名：BaseController.java</dt>
*<dd>描述: Controller的父类，用于封装一些公共的逻辑</dd>
*<dd>创建时间： 2019年5月22日 上午11:12:06</dd>
*<dd>创建人：tie</dd>
*<dt>版本历史: </dt>
* <pre>
* Date Author Version Description
* ------------------------------------------------------------------
* 2019年5月22日 上午11:12:06 tie 1.0 1.0 Version
* </pre>
*</dl>
*/
public class BaseController {
	
	public Employee getCurrentEmployee () {
		Subject subject = SecurityUtils.getSubject();
		Employee employee = (Employee) subject.getPrincipal();
		return employee;
	}

	
}
