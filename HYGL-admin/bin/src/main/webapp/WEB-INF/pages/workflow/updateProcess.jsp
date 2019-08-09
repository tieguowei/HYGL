<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>修改流程</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/workflow/updateProcess.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
    <script type="text/javascript" src="${path }/js/jquery.easyui.min.js" />
     <link rel="stylesheet" type="text/css" href="${path }/css/easyui.css">
 </head>

<body>

<div>
	<h4 style="margin-left: 15px;">	<span style="color: red;">流程信息</span></h4>
</div>
<div class="container">
 <form class="form-horizontal" id="updateProcessConfigForm" method="post">
 <input type="hidden" name="id" value="${process.id}">
	<div class="form-group">
		<label class="col-md-2 control-label">流程名称：</label>
		<div class="col-md-3 ">
			<input style="width: 280px;" type="text" id="process_name"
				name="processName" value="${process.processName}" class="form-control form-control-static"
				placeholder="不超过30字">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">流程类型：</label>
		<div class="col-md-3 ">
			<select style="width: 280px;" class="form-control form-control-static"
				id="update_process_type" name="processType">
				<option value="">请选择</option>
				 <c:forEach items="${dictList}" var="dict"> 
				    <option value="${dict.dict_code}" <c:if test="${dict.dict_code==process.processType}"> selected="selected"</c:if> >${dict.dict_name}</option>
				  </c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">流程简介：</label>
		<div class="col-md-3 ">
			<input style="width: 280px;" value="${process.processSketch}"  type="text" id="process_sketch" name="processSketch"
				class="form-control form-control-static">
		</div>
	</div>
	<!-- 操作内容赋值 -->
	<div class="form-group">
		<input type="hidden" name="remark" id ="remark">
	</div>
</form>
</div>
				
<div>
		<h4 style="margin-left: 12px;"><span style="color: red;">节点信息</span></h4>
</div>
			
<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline">
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_job_name" name="jobName" placeholder="请输入作业名称">
		    </div>
  		<button style="margin-left: 60px;margin-top: 5px;"  type="button" onclick="ProcessJobRelation.searchJobName()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
</form>
	</div>
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
<table id="ProcessJobRelation-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!-- 修改信息列表 -->
	<div>
			<h4 style="margin-left: 12px;"><span style="color: red;">修改信息</span></h4>
	</div>
	<div class="form-group">
		<div class="col-md-3 ">
		   		 <input type="text" style="margin-right:40px;  width: 1050px;"  class="form-control" id="update_content" name="updateContent" placeholder="请输入修改内容">
		</div>
	</div>
<table id="updateProcessHistory-table" class="table table-hover table-striped table-condensed table-bordered"></table>
			

<!-- 添加子节点model -->
<div id="relationAddDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="height: 450px;width: 605px;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加节点</h4>
            </div>
            
            <div class="container">
				<form class="form-horizontal" id="addRelationForm"  method="post">
					<!-- 隐藏流程id -->
					<input type="hidden" id="process_id" name="processId" value="${process.id}">
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
							<input readonly="readonly" onclick="ProcessJobRelation.tips()" type="text"  id="job_sketch"  class="form-control form-control-static">
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
					<div class="form-group">
						<label class="col-md-2 control-label">运行频率：</label>
					    <div class="col-md-3 ">
					    <select class="form-control form-control-static" id="add_operating_frequency" name="operatingFrequency">
			                        <option value="">请选择</option>
			                        <option value="1">每天</option>
			                        <option value="2">每周</option>
			                        <option value="3">每月</option>
			             </select>
					    </div>
				  	</div>
					<div class="form-group">
						<label class="col-md-2 control-label">运行时间：</label>
						<div class="col-md-3 ">
							<input type="text" id="run_time" name="runTime" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control form-control-static"/>
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

 <div class="modal-footer col-md-6">
		     <button   type="button" onclick="ProcessJobRelation.updateProcess(${menuId})" class="btn btn-primary">修改</button>
            <button type="button" class="btn btn-default" onclick="ProcessJobRelation.cancelUpdateProcess(${menuId})">取消</button>
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
				<form class="form-horizontal" id="updateRelationForm"  method="post">
					<!-- 节点id -->
					 <input type="hidden" id="update_id" name="id">
					 <!-- 节点的 job_basic_id -->
					 <input type="hidden" id="update_job_basic_id">
					 
     				<input type="hidden" id="update_id" name="id">
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
					<div class="form-group">
						<label class="col-md-2 control-label">运行频率：</label>
					    <div class="col-md-3 ">
					    <select class="form-control form-control-static" id="update_operating_frequency" name="operatingFrequency">
			                        <option value="">请选择</option>
			                        <option value="1">每天</option>
			                        <option value="2">每周</option>
			                        <option value="3">每月</option>
			             </select>
					    </div>
				  	</div>
					<div class="form-group">
						<label class="col-md-2 control-label">运行时间：</label>
						<div class="col-md-3 ">
							<input type="text" id="update_run_time" name="runTime" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control form-control-static"/>
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
<input type="hidden" id="global_process_id" value="${process.id}">
<input type="hidden" id="menu_id" value="${menuId}">

</body>
</html>