<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>流程历史列表</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/history/workflowHistoryList.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline">
			<div class="form-group">
				<label class="col-md-2 control-label">流程名称：</label>
				<div class="col-md-3">
					<input type="text" class="form-control"  id="search_process_name" name="processName" placeholder="请输入流程名称">		     
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-2 control-label">流程类型：</label>
				<div class="col-md-3">
					<select class="form-control form-control-static" id="search_process_type" name="processType">
                        <option value="">请选择</option>
             		</select>
             	</div>
			</div>
		
		  <div class="form-group">		
		  	<label class="col-md-2 control-label">选择时间：</label>   	 
		     <input style="width: 180px;" class="form-control input-sm Wdate" id="minCreateTime" name="minCreateTime" type="text" placeholder="请选择开始运行时间" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"/>	
             <input style="width: 180px;"  class="form-control input-sm Wdate" id="maxCreateTime" type="text" name="maxCreateTime" placeholder="请选择结束运行时间" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"/>
	
		  </div>
	</form>
		<button type="button" onclick="ProcessHistory.searchProcessHistory()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
	</div>
</div>
<!--列表 -->
<table id="ProcessHistory-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
</body>
</html>