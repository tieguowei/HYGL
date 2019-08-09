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
   	<script src="${path}/js/history/jobHistoryDetail.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${path}/css/job.css">
 </head>

<body>
<div class="panel panel-default" style="background: #fff; padding: 10px 10px 0; margin-bottom: 20px;">
<h4 class="form-title">作业信息</h4>
<div class="container" style="margin-top: 10px;">
 <form class="form-horizontal"  method="post">
	<div class="form-group">
		<label class="col-md-2 control-label">作业ID：</label>
		<div class="col-md-3 ">
			<input readonly="readonly"  value="${jobHistory.jobNumber}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">作业名称：</label>
		<div class="col-md-3 ">
			<input readonly="readonly" value="${jobHistory.jobName}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">作业类型：</label>
		<div class="col-md-3 ">
			<select disabled="disabled" style="width: 280px;" class="form-control form-control-static"
				id="update_process_type" name="processType">
				<option value="">请选择</option>
				 <c:forEach items="${dictList}" var="dict"> 
				    <option value="${dict.dict_code}" <c:if test="${dict.dict_code==jobHistory.jobType}"> selected="selected"</c:if> >${dict.dict_name}</option>
				  </c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">作业简述：</label>
		<div class="col-md-3 ">
			<input onclick="JobHistoryDetail.showJobHistorySketch()" id="job_detail_history_sketch" readonly="readonly" value="${jobHistory.jobSketch}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
		<div class="form-group">
		<label class="col-md-2 control-label">作业路径：</label>
		<div class="col-md-3 ">
			<input onclick="JobHistoryDetail.showJobHistoryUrl()" id="job_detail_history_url" readonly="readonly" value="${jobHistory.jobUrl}" style="width: 280px;" type="text" class="form-control form-control-static">
		</div>
	</div>
</form>
</div>
</div>
<div class="panel panel-default" style="background: #fff; padding: 10px 10px 0; margin-bottom: 20px;">
	<h4 class="form-title">修改历史</h4>
	<!-- 作业历史详情 -->
	<table id="JobHistoryDetail-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
	<div class="modal-footer col-md-6">
	 		<button   type="button" onclick="JobHistoryDetail.returnJobHistoryList()" class="btn btn-primary">返回</button>
	 </div>
</div>
 <!-- 作业jobBasicId -->
<input type="hidden" id="job_detail_jobBasicId"  value="${jobHistory.jobBasicId}">
<!-- 此条记录的流程id -->
<input type="hidden" id="job_detail_process_id" value="${jobHistory.processId}">
<!-- 此条记录的version-->
<input type="hidden" id="job_detail_version" value="${jobHistory.version}">
</body>
</html>