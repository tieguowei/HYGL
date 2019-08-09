<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>新增流程</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/workflow/addProcess.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
    <script type="text/javascript" src="${path }/js/jquery.easyui.min.js" ></script>
    <link rel="stylesheet" type="text/css" href="${path }/css/easyui.css">
    <link rel="stylesheet" href="${path}/css/job.css">
</head>
<body>


<div class="panel panel-default" style="background: #fff; padding: 10px; margin-bottom: 20px;">
<h4 class="form-title">流程信息</h4>
 <form class="form-horizontal" id="addProcessConfigForm" method="post">
	<div class="form-group col-md-4">
		<label class="col-md-4 control-label">流程名称：</label>
		<div class="col-md-8 " style="position: relative; overflow: visible;">
			<input type="text" id="process_name"
				name="processName" class="form-control form-control-static"
				placeholder="不超过30字">
		</div>
	</div>
	<div class="form-group col-md-4">
		<label class="col-md-4 control-label">流程类型：</label>
		<div class="col-md-8 " style="position: relative; overflow: visible;">
			<select class="form-control form-control-static"
				id="add_process_type" name="processType">
				<option value="">请选择</option>
			</select>
		</div>
	</div>
	<div class="form-group col-md-4">
		<label class="col-md-4 control-label">流程简介：</label>
		<div class="col-md-8 " style="position: relative; overflow: visible;">
			<input type="text" id="process_sketch" name="processSketch"
				class="form-control form-control-static">
		</div>
	</div>
</form>
</div>
			
<div class="panel panel-default" style="background: #fff; padding: 10px 10px 0; ">
	<h4 class="form-title">节点信息</h4>
	<form id="emplpyeeConForm" class="form-inline" style="margin-bottom: 0">
	    <div class="form-group ">
	   		 <input type="text" class="form-control" id="add_search_job_name" name="jobName" placeholder="请输入作业名称">
	    	<button type="button" onclick="ProcessJobRelation.searchJobName()" class="btn btn-info ">
	   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
	   		</button>
	    </div>
	</form>
</div>

<!--toolbar  -->
<div id="jobBasicToolbar" class="btn-toolbar" style="margin-top: 15px;">
   		<button type="button" class="btn btn-info" onclick="ProcessJobRelation.openRelationAddDlg()">
   			 <span class="glyphicon glyphicon-plus" >添加</span>
   		 </button>
  		<button type="button" class=" btn btn-info" onclick="ProcessJobRelation.openRelationUpdateDlg()">
  				 <span class="glyphicon glyphicon-pencil" >修改</span>
  		</button>
  		<button class=" btn btn-danger" type="button" onclick="ProcessJobRelation.deleteRelation()">
  			<span class="glyphicon glyphicon-remove" >删除</span>
  		</button>
</div>
<!--列表 -->
<table id="ProcessJobRelation-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>

<!-- 添加子节点model -->
<div id="relationAddDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="height: 450px;width: 605px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加节点</h4>
            </div>
            
            <div class="container">
				<form class="form-horizontal" id="addRelationForm"  method="post" style="margin-top: 15px;">
					<!-- 隐藏流程id -->
					<input type="hidden" id="add_process_id" name="processId">
					<div class="form-group">
						<label class="col-md-2 control-label">作业名称：</label>
					    <div class="col-md-3 ">
					    <select onchange="ProcessJobRelation.selectJob()" class="form-control form-control-static" id="add_job_name" name="jobBasicId">
			                        <option value="">请选择</option>
			             </select>
					    </div>
				  	</div>
				  	
				  	<div class="form-group">
						<label class="col-md-2 control-label">作业简述：</label>
						<div class="col-md-3 ">
							<input readonly="readonly" onclick="ProcessJobRelation.tips()" type="text"  id="add_job_sketch" name="jobSketch"  class="form-control form-control-static">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">起止作业：</label>
					    <div class="col-md-3 ">
					     <select onchange="ProcessJobRelation.selectStartWorking()" class="form-control form-control-static" id="add_starting_work" name="startingWork">
			                        <option value="">请选择</option>
			                         <option value="0">起点</option>
			                        <option value="1">终点</option>
			                        <option value="2">普通</option>
			             </select>
					    </div>
				  	</div>
				  	<div id="isShow"  style="display: none; overflow: hidden;">
					  	<div class="form-group">
							<label class="col-md-2 control-label">上一关联作业：</label>
						    <div class="col-md-3 ">
								<input id="lastJobName" style="width: 220px;height:32px;"   name="lastJobName" />
						    </div>
					  	</div>
				  	</div>
				  	
				  	<div id="dateIsShow" style="display: none; overflow: hidden;">
					  	<div class="form-group">
							<label class="col-md-2 control-label">运行频率：</label>
						    <div class="col-md-3 ">
						    <select onchange="ProcessJobRelation.selectRunDate()" class="form-control form-control-static" id="add_operating_frequency" name="operatingFrequency">
				                        <option value="">请选择</option>
				                        <option value="1">每天</option>
				                        <option value="2">每周</option>
				                        <option value="3">每月</option>
				             </select>
						    </div>
					  	</div>
			       	<div id="runDateIsShow" style="display: none; overflow: hidden;">
					  	<div class="form-group">
							<label class="col-md-2 control-label">运行日期：</label>
							<div class="col-md-3 ">
							 <select class="form-control form-control-static" id="add_run_date" name="runDate">
			            	 </select>
							</div>
						</div>
					</div>
						<div class="form-group">
							<label class="col-md-2 control-label">运行时间：</label>
							<div class="col-md-3 ">
								<input type="text" id="run_time" name="runTime" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm'})" class="form-control form-control-static"/>
							</div>
						</div>
				  	</div>
					
					
		            <div class="modal-footer col-md-6">
		            <!--用来清空表单数据-->
		            <input type="reset" name="reset" style="display: none;" />
		               <button  type="button" onclick="ProcessJobRelation.saveRelation()" class="btn btn-primary">新增</button>
		                <button type="button" class="btn btn-default" onclick="ProcessJobRelation.closeRelationDlg()">取消</button>
		            </div>
	            </form>
            </div>
        </div>
    </div>
</div> 

 <div class="modal-footer" style="text-align: center; margin-top: 20px;">
		     <button   type="button" onclick="ProcessJobRelation.saveProcessAndRelation(${menuId})" class="btn btn-primary">新增</button>
            <button type="button" class="btn btn-default" onclick="ProcessJobRelation.deleteProcessAndRelation(${menuId})">取消</button>
 </div>
<!-- 隐藏中间表最新一条数据的id -->	            
 <input type="hidden" id="process_job_relation_id">
  
  
  <!-- 修改子节点model -->
<div id="relationUpdateDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="height: 450px;width: 605px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改节点</h4>
            </div>
            
            <div class="container">
				<form class="form-horizontal" id="updateRelationForm"  method="post" style="margin-top: 15px;">
					<!-- 节点id -->
					 <input type="hidden" id="update_id" name="id">
					 <!-- 节点的 job_basic_id -->
					 <input type="hidden" id="update_job_basic_id">
     				<!-- 隐藏流程id -->
					<input type="hidden" id="update_process_id" name="processId">
					<div class="form-group">
						<label class="col-md-2 control-label">作业名称：</label>
					    <div class="col-md-3 ">
					    	<input readonly="readonly"  type="text"  id="update_job_name"  class="form-control form-control-static">
					    </div>
				  	</div>
				  	
				  	<div class="form-group">
						<label class="col-md-2 control-label">作业简述：</label>
						<div class="col-md-3 ">
							<input readonly="readonly" type="text" onclick="ProcessJobRelation.updateTips()"  id="update_job_sketch"  class="form-control form-control-static">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">起止作业：</label>
					    <div class="col-md-3 ">
					     <select onchange="ProcessJobRelation.updateSelectStartWorking()" class="form-control form-control-static" id="update_starting_work" name="startingWork">
			                        <option value="">请选择</option>
			                         <option value="0">起点</option>
			                        <option value="1">终点</option>
			                        <option value="2">普通</option>
			             </select>
					    </div>
				  	</div>
				  	<div id="update_isShow"  style="display: none; overflow: hidden;">
					  	<div class="form-group">
							<label class="col-md-2 control-label">上一关联作业：</label>
						    <div class="col-md-3 ">
								<input id="updateLastJobName" style="width: 220px;height:32px;"   name="lastJobName" />
						    </div>
					  	</div>
				  	</div>
				  	
				<div id="update_date_isShow"  style="display: none; overflow: hidden;">
					<div class="form-group">
						<label class="col-md-2 control-label">运行频率：</label>
					    <div class="col-md-3 ">
					    <select onchange="ProcessJobRelation.updateSelectRunDate()" class="form-control form-control-static" id="update_operating_frequency" name="operatingFrequency">
			                        <option value="">请选择</option>
			                        <option value="1">每天</option>
			                        <option value="2">每周</option>
			                        <option value="3">每月</option>
			             </select>
					    </div>
				  	</div>
				  	
				  	 <div id="updateRunDateIsShow" style="display: none; overflow: hidden;">
						  	<div class="form-group">
								<label class="col-md-2 control-label">运行日期：</label>
								<div class="col-md-3 ">
									 <select class="form-control form-control-static" id="update_run_date" name="runDate" />
								</div>
							</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-2 control-label">运行时间：</label>
						<div class="col-md-3 ">
							<input type="text" id="update_run_time" name="runTime" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm'})" class="form-control form-control-static"/>
						</div>
					</div>
					</div>
		            <div class="modal-footer col-md-6">
		            <!--用来清空表单数据-->
		            <input type="reset" name="reset" style="display: none;" />
		                <button   type="button" onclick="ProcessJobRelation.updateRelation()" class="btn btn-primary">修改</button>
		                <button type="button" class="btn btn-default" onclick="ProcessJobRelation.closeRelationDlg()">取消</button>
		            </div>
	            </form>
            </div>
        </div>
    </div>
</div> 
<!-- 全局流程id -->
<input type="hidden" id="add_global_process_id" name="globalProcessId">
<input type="hidden" id="add_process_menu_id" value="${menuId}">

</body>
</html>