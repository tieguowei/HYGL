<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>字典管理12</title>
    <link rel="stylesheet" href="${path}/css/system/role/role.css">
    <script src="${path}/js/system/dict/dict.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js" charset="UTF-8" type="text/javascript"></script>
</head>
<body>
<div class="wrapper wrapper-content">
<div class="panel panel-primary">
<div class="panel-body">
<div id="roleToolbar" class="btn-toolbar" style="margin: 15px 0px 10px 0px;">
	<shiro:hasPermission name="systemDictManager:add">
	    	<button class="btn btn-primary" type="button" onclick="Dict.openAddModal()">
	    		<i class="glyphicon glyphicon-plus"></i>添加
	    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="systemDictManager:update">
    	<button type="button" class=" btn btn-info" onclick="Dict.openUpdateModal()">
    			<i class="glyphicon glyphicon-edit"></i>修改
    	</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="systemDictManager:delete">
    	<button class="btn btn-danger" type="button" onclick="Dict.deleteDict()">
    			<i class="glyphicon glyphicon-trash"></i>删除
    	</button>
    </shiro:hasPermission>
</div> 
<table id="role-table" class="text-nowrap table table-condensed table-hover table-bordered"></table>
</div>
</div>
</div>

<!-- 模态框（Modal） -->
<!-- 添加 -->
<div id="roleAddDlg" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="myModalLabel">添加字典</h3>
            </div>
            <div class="container"  style="margin-top:10px;">
			<form class="form-horizontal" id="addDictForm"  method="post">
			
			<div class="form-group">
			<label class="col-md-2 control-label">*字典类别：</label>
			<div class="col-md-3 ">
			<input type="text" id="dictType"  name="dictType" class="form-control form-control-static" placeholder="请输入字典类别">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">字典类别名称：</label>
			<div class="col-md-3 ">
			<input type="text" id="dictTypeName"  name="dictTypeName" class="form-control form-control-static" placeholder="字典类别名称">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">*字典编码：</label>
			<div class="col-md-3">
			<input type="text" id="dictCode"  name="dictCode" class="form-control form-control-static" placeholder="请输入字典编码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">*字典名称：</label>
			<div class="col-md-3">
			<input type="text" id="dictName"  name="dictName" class="form-control form-control-static" placeholder="请输入字典名称">
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Dict.closeDlg()">关闭</button>
               <button id="saveDictButton" type="button" onclick="Dict.addDict()" class="btn btn-primary">保存</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<!-- 修改 -->
<div id="roleMydlg" class="modal fade"  
tabindex="-1" role="dialog" data-backdrop="static" 
data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title" id="myModalLabel">修改字典</h3>
                
            </div>
            <div class="container" style="margin-top:10px;">
				<form class="form-horizontal" id="updateDictForm"  method="post">
				<input type="hidden" id="dict_update_id" name="dictId" />
				<div class="form-group">
				<label class="col-md-2 control-label">*字典类别：</label>
				<div class="col-md-3 ">
				<input type="text" id="dict_update_dictType"  name="dictType" class="form-control form-control-static" placeholder="请输入字典类别">
				</div>
				</div>
				
				<div class="form-group">
				<label class="col-md-2 control-label">字典类别名称：</label>
				<div class="col-md-3 ">
				<input type="text" id="dict_update_dictTypeName"  name="dictTypeName" class="form-control form-control-static" placeholder="字典类别名称">
				</div>
				</div>
				
				<div class="form-group">
				<label class="col-md-2 control-label">*字典编码：</label>
				<div class="col-md-3">
				<input type="text" id="dict_update_dictCode"  name="dictCode" class="form-control form-control-static" placeholder="请输入字典编码">
				</div>
				</div>
				
				<div class="form-group">
				<label class="col-md-2 control-label">*字典名称：</label>
				<div class="col-md-3">
				<input type="text" id="dict_update_dictName"  name="dictName" class="form-control form-control-static" placeholder="请输入字典名称">
				</div>
				</div>
				
				
	            <div class="modal-footer col-md-6">
	            <!--用来清空表单数据-->
	            <input type="reset" name="reset" style="display: none;" />
	                <button type="button" class="btn btn-default" onclick="Dict.closeDlg()">关闭</button>
	               <button type="button" onclick="Dict.updateDict()" class="btn btn-primary">保存</button>
	            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>