<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>作业运行监控详情</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/monitor/jobMonitorDetail.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
 </head>
 <style>
 .form-title {
	font-family: PingFangSC-Semibold;
	font-size: 16px;
	color: #000000;
	letter-spacing: 0;
	line-height: 14px;
	padding-left: 15px;
	position: relative;
	line-height: 1.5;
	margin-bottom: 20px;
}
.form-title:before {
    content:'';
    display: block; 
    width: 4px; height: 14px;
    background: #3872FF;
	border-radius: 1px;
	position: absolute; left: 0; top: 50%; margin-top: -7px;
}

.form-group .help-block {
	margin-bottom: 0;
    position: absolute;
    left: 310px;
    width: 300px;
    top: 6px;
    color: #f00;
}
 </style>
<body>
<div class="panel panel-default" style="background: #fff; padding: 10px; margin-bottom: 20px;">
<h4 class="form-title">作业信息</h4>
 <form  method="post" class="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label">作业ID：</label>
		<div class="col-sm-4 ">
			<input readonly="readonly"  value="${jobHistory.jobNumber}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
		<label class="col-sm-2 control-label">作业名称：</label>
		<div class="col-sm-4 ">
			<input readonly="readonly" value="${jobHistory.jobName}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">作业类型：</label>
		<div class="col-sm-4 ">
			<select disabled="disabled" style="width: 280px;" class="form-control form-control-static"
				id="update_process_type" name="processType">
				<option value="">请选择</option>
				 <c:forEach items="${dictList}" var="dict"> 
				    <option value="${dict.dict_code}" <c:if test="${dict.dict_code==jobHistory.jobType}"> selected="selected"</c:if> >${dict.dict_name}</option>
				  </c:forEach>
			</select>
		</div>
		<label class="col-sm-2 control-label">作业简述：</label>
		<div class="col-sm-4 ">
			<input onclick="JobMonitorDetail.showJobHistorySketch()" id="job_detail_history_sketch" readonly="readonly" value="${jobHistory.jobSketch}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2  control-label">作业路径：</label>
		<div class="col-sm-4 ">
			<input onclick="JobMonitorDetail.showJobHistoryUrl()" id="job_detail_history_url" readonly="readonly" value="${jobHistory.jobUrl}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
</form>
</div>
<div class="panel panel-default" style="background: #fff; padding: 10px 10px 0;">
	<h4 class="form-title">修改历史</h4>
	<!-- 作业历史详情 -->
	<table id="JobMonitorDetail-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
	<div class="modal-footer col-md-6">
 		<button   type="button" onclick="JobMonitorDetail.returnJobMonitorList()" class="btn btn-primary">返回</button>
 	</div>
</div>
 <!-- 作业jobBasicId -->
<input type="hidden" id="job_monitor_jobBasicId"  value="${jobBasicId}">
<!-- 此条记录的流程id -->
<input type="hidden" id="job_monitor_detail_process_id" value="${jobHistory.processId}">
<!-- 此条记录的version-->
<input type="hidden" id="job_monitor_detail_version" value="${jobHistory.version}">
<!-- 流程运行状态 -->
<input type="hidden" id="job_monitor_process_runStatus" value="${processRunStatus}">

</body>
</html>