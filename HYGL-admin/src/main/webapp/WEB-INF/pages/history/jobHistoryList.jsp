<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>作业运行历史</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
    <link rel="stylesheet" href="${path}/css/job.css">
   	<script src="${path}/js/history/jobHistoryList.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
 </head>
<body>
<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline">
		  <div class="form-group">
		  	<label for="disabledSelect"  class="col-sm-4 control-label">作业名称：</label>
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_job_history_name" name="search_job_history_name"  placeholder="请输入作业名称">
		    </div>
		  </div>
		  <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">作业类型：</label>
		    <div class="col-md-5 ">
		    <select class="form-control form-control-static" id="search_job_history_type" >
                        <option value="">请选择</option>
             </select>
		    </div>
		  </div>
  		<button type="button" onclick="JobHistory.searchJobHistory()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
   		<button type="button" onclick="JobHistory.empty()" class="btn btn-danger ">
   			<span class="glyphicon glyphicon-remove" aria-hidden="true" > 清空</span>
   		</button>
</form>
	</div>
</div>
<div class="panel panel-default" style="background: #fff; padding: 10px; ">
    <h4 class="form-title">作业运行历史列表</h4>
	<!--作业运行历史列表 -->
	<table id="JobHistory-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
</div>

<div class="panel panel-default" style="background: #fff; padding: 10px; ">
    <h4 class="form-title">错误及操作日志</h4>
	<!--作业错误及操作日志列表 -->
	<table id="JobErrorOrLog-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
</div>
<div class="modal-footer">
 		<button   type="button" onclick="JobHistory.returnWorkflowHistoryList(${menuId})" class="btn btn-primary">返回</button>
 </div>
<!-- 流程id -->
<input type="hidden" id="job_history_process_id" value="${id}">
<!-- version -->
<input type="hidden" id="job_history_version" value="${version}">
<!-- menuId -->
<input type="hidden" id="job_history_menu_id" value="${menuId}">
<!-- 流程状态 区分查找节点数据源 -->
<input type="hidden" id="job_history_status" value="${runStatus}">
</body>
</html>