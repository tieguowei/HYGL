<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>字典管理</title>
    <link rel="stylesheet" href="${path}/css/system/role/role.css">
    <script src="${path}/js/system/dict/dict.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js" charset="UTF-8" type="text/javascript"></script>
</head>
<body>
<div class="panel panel-default">
	<div class="panel-body">
		<form id="emplpyeeConForm" class=" form-inline" style="margin-bottom: 0;">
		  <div class="form-group">
		  	<label for="disabledSelect"  class="col-sm-4 control-label">字典名称：</label>
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_dict_name" name="dictName" placeholder="请输入字典名称">
		    </div>
		  </div>
		  <div class="form-group">
		   <label for="disabledSelect"  class="col-sm-4 control-label">字典类别：</label>
		    <div class="col-md-5 ">
		   	 <input type="text" class="form-control" id="search_dict_type" name="dictType" placeholder="请输入字典类别">
		    </div>
		  </div>
  			<button type="button"  class="btn btn-info"  onclick="Dict.searchDict()">
   				<span class="glyphicon glyphicon-search">搜索</span>	
   			</button>
		</form>
	</div>
</div>	
<div id="sysToolbar" class="btn-toolbar" style="margin-top: 15px;">
	<shiro:hasPermission name="systemDictManager:add">
	    	<button class="btn btn-primary" type="button" onclick="Dict.openAddModal()">
	    		<span class="glyphicon glyphicon-plus">添加</span>	
	    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="systemDictManager:update">
    	<button type="button" class=" btn btn-info" onclick="Dict.openUpdateModal()">
    			<span class="glyphicon glyphicon-edit">修改</span>	
    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="systemDictManager:delete">
    	<button class="btn btn-danger" type="button" onclick="Dict.deleteDict()">
    			<span class="glyphicon glyphicon-trash">删除</span>	
    	</button>
    </shiro:hasPermission>
</div> 
<table id="dict-table" class="text-nowrap table table-condensed table-hover table-bordered"></table>

<!-- 模态框（Modal） -->
<!-- 添加 -->
<div id="dictAddDlg"  class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width:500px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					添加字典
				</h4>
			</div>
            <div class="modal-body" style="height:270px;" >
			<form class="form-horizontal" id="addDictForm"  method="post" >
			
			<div class="form-group">
				<label class="col-sm-4 control-label">*字典类别：</label>
				<div class="col-sm-6 ">
					<input type="text" id="dictType"  name="dictType" class="form-control form-control-static" placeholder="请输入字典类别">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">字典类别名称：</label>
				<div class="col-sm-6 ">
					<input type="text" id="dictTypeName"  name="dictTypeName" class="form-control form-control-static" placeholder="字典类别名称">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-4 control-label">*字典编码：</label>
				<div class="col-sm-6">
					<input type="text" id="dictCode"  name="dictCode" class="form-control form-control-static" placeholder="请输入字典编码">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">*字典名称：</label>
				<div class="col-sm-6">
					<input type="text" id="dictName"  name="dictName" class="form-control form-control-static" placeholder="请输入字典名称">
				</div>
			</div>
            </form>
            </div>
            <div class="modal-footer">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Dict.closeDlg()">关闭</button>
                <button id="saveDictButton" type="button" onclick="Dict.addDict()" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<!-- 修改 -->
<div id="dictMydlg"  class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" 
aria-hidden="true" style=" width:500px;">
    <div class="modal-dialog" style="width:100%;">
		<div class="modal-content" style="width:100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改字典
				</h4>
			</div>
            <div class="modal-body" style="height:270px; " >
				<form class="form-horizontal" id="updateDictForm"  method="post">
					<input type="hidden" id="dict_update_id" name="dictId" />
					<div class="form-group">
						<label class="col-sm-4 control-label">*字典类别：</label>
						<div class="col-sm-6 ">
						<input type="text" id="dict_update_dictType"  name="dictType" class="form-control form-control-static" placeholder="请输入字典类别">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label">字典类别名称：</label>
						<div class="col-sm-6 ">
						<input type="text" id="dict_update_dictTypeName"  name="dictTypeName" class="form-control form-control-static" placeholder="字典类别名称">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label">*字典编码：</label>
						<div class="col-sm-6">
						<input type="text" id="dict_update_dictCode"  name="dictCode" class="form-control form-control-static" placeholder="请输入字典编码">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-4 control-label">*字典名称：</label>
						<div class="col-sm-6">
						<input type="text" id="dict_update_dictName"  name="dictName" class="form-control form-control-static" placeholder="请输入字典名称">
						</div>
					</div>
		            
            </form>
            </div>
            <div class="modal-footer">
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Dict.closeDlg()">关闭</button>
                <button type="button" onclick="Dict.updateDict()" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>