<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>会员管理</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/system/member/memberPage.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline" style="margin-bottom: 0;">
		  <div class="form-group">
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_employee_no" name="employeeNo" placeholder="请输入会员编号">
		    </div>
		  </div>
		   <div class="form-group">
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_employee_name" name="employeeName" placeholder="请输入会员姓名">
		    </div>
		  </div>
  		<button type="button" onclick="Employee.searchEmployee()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
</form>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-body" style="height: 50px;">
		今日开卡数：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 10</span> 
		今日充值金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 1000元</span> 
		今日消费金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 300元 </span> 
		本月充值金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 5000元  </span> 
		本月消费金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 2000元</span> 
	</div>
</div>
<!--toolbar  -->
<div id="employeeToolbar" class="btn-toolbar" style="margin-top: 15px;">
 <shiro:hasPermission name="employeeManager:add">
   		<button type="button" class="btn btn-info" onclick="Employee.openDlg()">
   			 <span class="glyphicon glyphicon-plus" >添加会员</span>
   		 </button>
 </shiro:hasPermission> 
  <shiro:hasPermission name="employeeManager:update">
  		<button type="button" class=" btn btn-info" onclick="Employee.openUpdateModal()">
  				 <span class="glyphicon glyphicon-pencil" >修改会员</span>
  		</button>
  </shiro:hasPermission>
  
 
  <shiro:hasPermission name="employeeManager:delete">
  		<button class=" btn btn-danger" type="button" onclick="Employee.deleteEmployee(2)">
  			<span class="glyphicon glyphicon-remove" >删除会员</span>
  		</button>
  </shiro:hasPermission>
   <shiro:hasPermission name="employeeManager:update">
  		<button type="button" class=" btn btn-info" onclick="Employee.openUpdateModal()">
  				 <span class="glyphicon glyphicon-pencil" >充值</span>
  		</button>
  </shiro:hasPermission>
    <shiro:hasPermission name="employeeManager:update">
  		<button type="button" class=" btn btn-info" onclick="Employee.openUpdateModal()">
  				 <span class="glyphicon glyphicon-pencil" >消费</span>
  		</button>
  </shiro:hasPermission>
  <shiro:hasPermission name="employeeManager:update">
  		<button type="button" class=" btn btn-info" onclick="Employee.openUpdateModal()">
  				 <span class="glyphicon glyphicon-pencil" >扣减积分</span>
  		</button>
  </shiro:hasPermission>
</div>
<!--列表 -->
<table id="employee-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!-- 添加会员 -->
<div id="employeeAddDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 600px;">
    <div class="modal-dialog" style="width: 100%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加会员</h4>
            </div>
            <div class="modal-body" style="height: 300px; overflow-y:scroll;">
				<form class="form-horizontal bv-form" id="addEmployeeForm"  method="post" style="margin-top: 15px;">
					<div class="form-group">
							<label class="col-md-4 control-label">姓名：</label>
							<div class="col-md-6 ">
								<input type="text"  id="employee_name" name="name" class="form-control form-control-static">
							</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">性别：</label>
						<div class="col-md-6 ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio"  name="sex" value="0">男&nbsp;&nbsp;&nbsp;&nbsp;
		                   <input type="radio"  name="sex" value="1">女
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">会员编号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="employee_no" name="employeeNo" class="form-control form-control-static">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">手机号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="mobile" name="mobile" class="form-control form-control-static">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">身份证号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="card_no" name="cardNo" class="form-control form-control-static">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">入职时间：</label>
						<div class="col-md-6 ">
							<input type="text" id="entry_time" name="entryDate" onfocus="WdatePicker({lang:'zh-cn'})" class="form-control form-control-static"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">所属部门：</label>
						<div class="col-md-6">
							<input type="text" id="department_name" name="departmentName" class="form-control" value="" onclick="" placeholder="所属部门">
							<input type="hidden" id="employee_dept_id" name="deptId" class="form-control" value="" onclick="" placeholder="所属部门">
							<div id="parentIdtreeview" style="z-index: 9999" class=""></div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">默认密码：</label>
						<div class="col-md-6 ">
							<input type="text"  id="password" name="password" value="123456" class="form-control form-control-static" placeholder="123456" readonly="readonly">
						</div>
					</div>
						
		            
	            </form>

            </div><!-- modal body -->
            <div class="modal-footer">
            	<!--用来清空表单数据-->
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Employee.closeDlg()">关闭</button>
                <button id="saveEmployeeButton"  type="button" onclick="Employee.saveEmployee()" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 


<!-- 修改会员信息 -->
<div id="employeeUpdateDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 605px;">
    <div class="modal-dialog" style="width: 100%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改会员信息</h4>
            </div>
            
            <div class="modal-body" style="height: 300px; overflow-y:scroll;">
				<form class="form-horizontal bv-form" id="employeeUpdateForm"  method="post" style="margin-top: 15px;">
					<div class="form-group">
							<label class="col-md-4 control-label">姓名：</label>
							<div class="col-md-6 ">
								<input type="hidden"  id="update_employee_id" name="employeeId">
								<input type="text"  id="update_employee_name" name="name" class="form-control form-control-static">
							</div>
					</div>
			
					<div class="form-group">
						<label class="col-md-4 control-label">性别：</label>
						<div class="col-md-6 ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   <input type="radio" id="update_employee_sex0" name="sex" value="0">男&nbsp;&nbsp;&nbsp;&nbsp;
		                   <input type="radio" id="update_employee_sex1" name="sex" value="1">女
						</div>
					</div>
			
					<div class="form-group">
						<label class="col-md-4 control-label">会员编号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="update_employee_no" name="employeeNo" class="form-control form-control-static">
						</div>
					</div>
			
					<div class="form-group">
						<label class="col-md-4 control-label">手机号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="update_employee_mobile" name="mobile" class="form-control form-control-static">
						</div>
					</div>
				
					<div class="form-group">
						<label class="col-md-4 control-label">身份证号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="update_card_no" name="cardNo" class="form-control form-control-static">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">入职时间：</label>
						<div class="col-md-6 ">
							<input type="text" id="update_entry_time" name="entryDate" onfocus="WdatePicker({lang:'zh-cn'})" class="form-control form-control-static"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">所属部门：</label>
						<div class="col-md-6">
								<input type="text" id="update_departmentname" name="departmentname" class="form-control" value="" onclick="" placeholder="所属部门">
								<input type="hidden" id="employee_update_dept_id" name="deptId" class="form-control" value="" onclick="" placeholder="所属部门">
								<div id="update_parentIdtreeview" style="z-index: 9999" class=""></div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">密码还原：</label>
						<div class="col-md-6" class="form-control form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input   type="radio"  name="isResetPwd" value="1">是&nbsp;&nbsp;&nbsp;&nbsp;
							<input  type="radio"   name="isResetPwd" value="2">否
						</div>
					</div>
	            </form>
            </div>
            
            <div class="modal-footer">
            	<!--用来清空表单数据-->
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Employee.closeDlg()">关闭</button>
               <button type="button" onclick="Employee.updateEmployee()" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 

<!-- 模态框（Modal） -->
<!-- 角色分配-->
<div id="employeeRoleDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">分配角色</h4>
            </div>
            <div class="modal-body">
				<form class="form-horizontal  bv-form" id="roleForm"  method="post">			
					<div class="form-group">
						<label class="col-md-4 control-label">我的角色：</label>
						<div class="col-md-6 ">
							<input type="hidden" id="employeeId" >
							<select  style= "width:280px" id="employee_rid" name="role" multiple="multiple"  class="form-control form-control-static "></select>
						</div>
					</div>          
	            </form>
            </div>
            
            <div class="modal-footer"> 
            	<!--用来清空表单数据-->
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Employee.closeDlg()">关闭</button>
                <button type="button" onclick="Employee.saveRole()" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>