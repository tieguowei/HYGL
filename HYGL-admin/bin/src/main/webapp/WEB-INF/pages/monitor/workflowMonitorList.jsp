<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>流程监控列表</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/monitor/workflowMonitorList.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline">
		  <div class="form-group">
		  	<label for="disabledSelect"  class="col-sm-4 control-label">流程名称：</label>
		    <div class="col-md-2 ">
		   		 <input style="width: 180px;" type="text" class="form-control" id="monitor_search_process_name"  placeholder="请输入流程名称">
		    </div>
		  </div>
		  <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">流程类型：</label>
		    <div class="col-md-5 ">
		    <select style="width: 188px;" class="form-control form-control-static" id="monitor_search_process_type">
                        <option value="">请选择</option>
             </select>
		    </div>
		  </div>
		   <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">运行状态：</label>
		    <div class="col-md-5 ">
		    <select  style="width: 188px;" class="form-control form-control-static" id="monitor_search_run_status">
                        <option value="">请选择</option>
             </select>
		    </div>
		  </div>
  		<button type="button" onclick="ProcessConfigMonitor.searchProcessConfigMonitor()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
</form>
	</div>
</div>
<!--toolbar  -->
	<div id="monitorWorkflowToolbar" class="btn-toolbar" style="margin-top: 15px;">
	   		<button type="button" class="btn btn-info" onclick="ProcessConfigMonitor.manualStart()">
	   			 <span class="glyphicon glyphicon-plus" >手动启动</span>
	   		 </button>
	  		<button class=" btn btn-danger" type="button" onclick="ProcessConfigMonitor.manualStop()">
	  			<span class="glyphicon glyphicon-remove" >手动停止</span>
	  		</button>
	</div>
<!--列表 -->
<div style="overflow:scroll;">
	<table id="ProcessConfigMonitor-table" class="table table-hover table-striped table-condensed table-bordered" style="min-width:1600px;"></table>
</div>
</body>
</html>