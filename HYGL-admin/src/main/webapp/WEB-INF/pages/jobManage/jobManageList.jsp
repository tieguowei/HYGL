<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>作业管理列表</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/job/job.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
    <script src="${path}/static/js/jquery-form.js"></script>
    
</head>
<body>
<div class="panel panel-default">
	<div class="panel-body">
 		<form id="jobConForm" class=" form-inline" style="margin-bottom: 0;">
		  <div class="form-group">
		  	<label for="disabledSelect"  class="col-sm-4 control-label">作业名称：</label>
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_job_name" name="jobName" placeholder="请输入作业名称">
		    </div>
		  </div>
		  <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">作业类型：</label>
		    <div class="col-md-5 ">
		    <select class="form-control form-control-static" id="search_job_type_first" name="processType">
                        <option value="">请选择</option>
             </select>
		    </div>
		  </div>
  			<button type="button"  class="btn btn-primary"  onclick="Job.searchJob()" class="btn btn-info ">
   				<i class="glyphicon glyphicon-search"  ></i>搜索
   			</button>
		</form>
	</div>
</div>	
<div id="jobToolbar" class="btn-toolbar" style="margin-top: 15px;">
 	<shiro:hasPermission name="jobBasicManager:detail">
    	<button class="btn btn-success" type="button" onclick="Job.openJobDetailModel()">
    			<i class="glyphicon glyphicon-th-large"></i>查看
    	</button>
    </shiro:hasPermission>
	<shiro:hasPermission name="jobBasicManager:add">
	    	<button class="btn btn-primary" type="button" onclick="Job.openAddModal()">
	    		<i class="glyphicon glyphicon-plus"></i>添加
	    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="jobBasicManager:update">
    	<button type="button" class=" btn btn-info" onclick="Job.openUpdateModal()">
    			<i class="glyphicon glyphicon-edit"></i>修改
    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="jobBasicManager:delete">
    	<button class="btn btn-danger" type="button" onclick="Job.deleteJob()">
    			<i class="glyphicon glyphicon-trash"></i>删除
    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="jobBasicManager:import">
    	<button class="btn  btn-info" type="button" onclick="Job.importJobModel()">
    			<i class="glyphicon glyphicon-arrow-up"></i>导入
    	</button>
    </shiro:hasPermission>
</div> 
<!--列表 -->
<table id="job-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>

<!-- 模态框（Modal） -->
<!-- 添加 -->
<div id="jobAddDlg" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width: 800px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加作业
				</h4>
			</div>
            <div class="modal-body" style="height:200px;" >
			<form class="form-horizontal" id="addJobForm"  method="post" >
			
			<div class="form-group">
				<label class="col-sm-2 control-label">*作业名称：</label>
				<div class="col-sm-4 ">
					<input type="text" id="jobName"  name="jobName" class="form-control form-control-static" placeholder="请输入作业名称">
				</div>
				<label for="disabledSelect" class="col-sm-2 control-label">*作业类型：</label>
		    	<div class="col-sm-4 ">
		    	<select class="form-control form-control-static" id="search_job_type" name="jobType" >
                        <option value="">请选择</option>
            	 </select>
		    	</div>
			</div>
			
		  	<div class="form-group">
				<label class="col-sm-2 control-label">*作业路径：</label>
				<div class="col-sm-4">
					<input type="text" id="jobUrl"  name="jobUrl" class="form-control form-control-static" placeholder="请输入作业路径">
					<input type="file" id="rarfileName" accept=".rar,.kjb"  name="rarFile" class="form-control form-control-static" >
					<input type="button" value="上传" onclick="Job.importRarJob()" class="btn btn-info" />  
				</div>
				<label class="col-sm-2 control-label">*作业简述：</label>
				<div class="col-sm-4">
					<textarea  id="jobSketch"  name="jobSketch" class="form-control form-control-static" ></textarea>
				</div>
			</div>
            </form>
            </div>
            <div class="modal-footer">
            	<input type="reset" name="reset" style="display: none;" />
				<button type="button" class="btn btn-default" oncllick="Job.close()" data-dismiss="modal">关闭</button>
				<button type="button" id="saveJobButton" onclick="Job.addJob()" class="btn btn-primary">保存</button>
			</div>
        </div>
    </div>
</div>


<!-- 修改模态框（Modal） -->
<div id="jobUpdateMydlg" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width: 800px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改作业
				</h4>
			</div>
            <div class="modal-body" style="height:320px;" >
				<form class="form-horizontal" id="updateJobForm"  method="post">
					<input type="hidden" id="job_update_id" name="id" />
					<input type="hidden" id="job_update_jobStatus" name="jobStatus" />
					
					<div class="form-group">
						<label class="col-sm-2 control-label">*作业id：</label>
						<div class="col-sm-4">
							<input type="text" id="job_update_jobNumber"  name="jobNumber" class="form-control form-control-static" disabled>
						</div>
						<label class="col-sm-2 control-label">*作业名称：</label>
						<div class="col-sm-4 ">
							<input type="text" id="job_update_jobName"  name="jobName" class="form-control form-control-static" disabled>
						</div>
					</div>
					
					
					
					<div class="form-group">
				  	 	<label for="disabledSelect" class="col-sm-2 control-label">*作业类型：</label>
				    	<div class="col-sm-4 ">
				    	<select class="form-control form-control-static" id="update_search_job_type" name="jobType" disabled>
		                        <option value="">请选择</option>
		            	 </select>
				    	</div>
				    	<label class="col-sm-2 control-label">*作业路径：</label>
						<div class="col-sm-4">
							<input type="text" id="job_update_jobUrl"  name="jobUrl" class="form-control form-control-static" >
							<input type="file" id="update_rarfileName" accept=".rar,.kjb"  name="update_rarFile" class="form-control form-control-static" >
							<input type="button" value="上传" onclick="Job.importRarJob(2)" />  
						</div>
				  	</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">*作业简介：</label>
						<div class="col-sm-10">
							<textarea  id="job_update_jobSketch"  name="jobSketch" class="form-control form-control-static" >
							</textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">*修改备注：</label>
						<div class="col-sm-8">
							<input type="text" id="job_update_remark"  name="remark" class="form-control form-control-static" placeholder="请输入字典名称">
						</div>
					</div>
            	</form>
            </div>
            <div class="modal-footer">
				<button type="button" class="btn btn-default" oncllick="Job.close()" data-dismiss="modal">关闭</button>
				<button type="button" onclick="Job.updateJob()" class="btn btn-primary">保存</button>
			</div>
        </div>
    </div>
</div>
<!-- 修改模态框（Modal） -->

<!-- 导入 模态框（Modal） -->

<div id="jobImportDlg" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width:650px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					导入作业
				</h4>
			</div>
			 <div class="modal-body" style="height:150px;" >
			<form class="form-horizontal" enctype="multipart/form-data"  id="importJobForm" >
				<div class="form-group">
					<label class="col-sm-3 control-label">*上传文件：</label>
					<div class="col-sm-6">
						<input type="file" id="fileName"  name="file" class="form-control form-control-static" >
					</div>
					<label class="col-sm-3 control-label"><a href="jobBasic/downExcel" style="color:red;float:left;" >点击下载模板</a></label>
				</div>
	         </form>
            </div>
            <div class="modal-footer">
             	<input type="reset" name="reset" style="display: none;" />
				<button type="button" class="btn btn-default" onclick="Job.closeDlg()">关闭</button>
				<button id="importJobButton" type="button" onclick="Job.importJob()" class="btn btn-primary">上传</button>
			</div>
        </div>
    </div>
</div>
<!-- 导入 /.modal -->

<!--查看 模态框（Modal） -->
<div id="jobDetailMydlg" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width: 800px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					查看作业
				</h4>
			</div>
            <div class="modal-body" style="height:300px; overflow-y:scroll;" >
				<form class="form-horizontal" id="detailJobForm"  method="post">
					<input type="hidden" id="job_detail_id" name="id" />
					<input type="hidden" id="job_detail_jobStatus" name="jobStatus" />
					
					<div class="form-group">
						<label class="col-sm-2 control-label">*作业id：</label>
						<div class="col-sm-4">
							<input type="text" id="job_detail_jobNumber"  name="jobNumber" class="form-control form-control-static" disabled>
						</div>
						<label class="col-sm-2 control-label">*作业名称：</label>
						<div class="col-sm-4 ">
							<input type="text" id="job_detail_jobName"  name="jobName" class="form-control form-control-static" disabled>
						</div>
					</div>
					<div class="form-group">
				  	 	<label for="disabledSelect" class="col-sm-2 control-label">*作业类型：</label>
				    	<div class="col-sm-4 ">
					    	<select class="form-control form-control-static" id="detail_search_job_type" name="jobType" disabled>
			                        <option value="">请选择</option>
			            	 </select>
				    	</div>
				    	<label class="col-sm-2 control-label">*作业路径：</label>
						<div class="col-sm-4">
							<input type="text" id="job_detail_jobUrl"  name="jobUrl" class="form-control form-control-static" disabled>
						</div>
				  	</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">*作业简介：</label>
						<div class="col-sm-10">
							<textarea  id="job_detail_jobSketch"  name="jobSketch" class="form-control form-control-static" disabled></textarea>
						</div>
					</div>
            	</form>
            	 <!--列表 -->
			    <div style ="margin: 26px 1px -10px 26px;">
					<table id="job--log-table" class="text-nowrap table table-condensed table-hover table-bordered" style='table-layout:fixed;'></table>
				</div>
            </div>
    		<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
    	 </div>
    </div>
</div>


</body>
</html>