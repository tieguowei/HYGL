<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>作业监控列表</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/monitor/jobMonitorList.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline">
		  <div class="form-group">
		  	<label for="disabledSelect"  class="col-sm-4 control-label">作业名称：</label>
		    <div class="col-md-2 ">
		   		 <input style="width: 180px;" type="text" class="form-control" id="search_job_monitor_name"  placeholder="请输入作业名称">
		    </div>
		  </div>
		  <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">作业类型：</label>
		    <div class="col-md-5 ">
		    <select style="width: 188px;" class="form-control form-control-static" id="search_job_monitor_type" >
                        <option value="">请选择</option>
             </select>
		    </div>
		  </div>
		   <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">运行状态：</label>
		    <div class="col-md-5 ">														
		    <select  style="width: 188px;" class="form-control form-control-static" id="search_job_monitor_run_status">
                        <option value="">请选择</option>
             </select>
		    </div>
		  </div>
  		<button type="button" onclick="JobMonitor.searchJobMonitor()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
</form>
	</div>
</div>
<!--列表 -->
<table id="JobMonitor-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
<div class="modal-footer col-md-6">
 		<button   type="button" onclick="JobMonitor.returnWorkflowMonitorList(${menuId})" class="btn btn-primary">返回</button>
 </div>
<!-- 流程id -->
<input type="hidden" id="job_monitor_process_id" value="${id}">
<!-- version -->
<input type="hidden" id="job_monitor_version" value="${version}">
<!-- 流程状态 区分查找节点数据源 -->
<input type="hidden" id="job_monitor_status" value="${runStatus}">
</body>



<div id="errorModel" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width:700px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					提示信息
				</h4>
			</div>
			 <div class="modal-body" style="height:200px; overflow:scroll;" >
			<form class="form-horizontal" enctype="multipart/form-data"  id="errorForm" >
				<div class="form-group">
					<div class="col-sm-12" id="errorInfoDiv" style="color:red;">
						
					</div>
				</div>
	         </form>
            </div>
            <div class="modal-footer">
             	<input type="reset" name="reset" style="display: none;" />
				<button type="button" class="btn btn-default" onclick="JobMonitor.closeDlg()">关闭</button>
			</div>
        </div>
    </div>
</div>
<!-- 导入 /.modal -->
</html>