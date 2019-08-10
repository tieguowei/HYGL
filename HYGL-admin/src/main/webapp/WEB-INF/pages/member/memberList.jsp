<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>会员管理</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/member/memberPage.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
</head>
<body>

<div class="panel panel-default">
	<div class="panel-body">
		<form id="memberSearchForm" class=" form-inline" style="margin-bottom: 0;">
		  <div class="form-group">
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_member_name" name="memberName" placeholder="请输入会员姓名">
		    </div>
		  </div>
		   <div class="form-group">
		    <div class="col-md-2 ">
		   		 <input type="text" class="form-control" id="search_member_phone" name="memberPhone" placeholder="请输入会员手机号">
		    </div>
		  </div>
  		<button type="button" onclick="Member.searchMember()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >搜索</span>
   		</button>
   		<button type="button" onclick="Member.empty()" class="btn btn-danger ">
   			<span class="glyphicon glyphicon-remove" aria-hidden="true" > 清空</span>
   		</button>
</form>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-body" style="height: 50px;">
		今日开卡数：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 10</span> 
		今日充值金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 1000元</span> 
		今日消费金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 300元 </span> 
		本月充值金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 5000元  </span> 
		本月消费金额：<span style="color:red;margin-left: 10px;margin-right: 10px;"> 2000元</span> 
	</div>
</div>
<!--toolbar  -->
<div id="memberToolbar" class="btn-toolbar" style="margin-top: 15px;">
   		<button type="button" class="btn btn-info" onclick="Member.openDlg()">
   			 <span class="glyphicon glyphicon-plus" >添加会员</span>
   		 </button>
  		<button type="button" class=" btn btn-info" onclick="Member.openUpdateModal()">
  				 <span class="glyphicon glyphicon-pencil" >修改会员</span>
  		</button>
  		<button class=" btn btn-danger" type="button" onclick="Member.deleteMember()">
  			<span class="glyphicon glyphicon-remove" >删除会员</span>
  		</button>
  		<button type="button" class=" btn btn-info" onclick="Member.openRecharge()">
  				 <span class="glyphicon glyphicon-pencil" >充值</span>
  		</button>
  		<button type="button" class=" btn btn-info" onclick="Member.openConsume()">
  				 <span class="glyphicon glyphicon-pencil" >消费</span>
  		</button>
  		<button type="button" class=" btn btn-info" onclick="Member.openDeduct()">
  				 <span class="glyphicon glyphicon-pencil" >扣减积分</span>
  		</button>
</div>
<!--列表 -->
<table id="member-table" class="table table-hover table-striped table-condensed table-bordered"></table>

<!-- 添加会员 -->
<div id="memberAddDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 600px;">
    <div class="modal-dialog" style="width: 100%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加会员</h4>
            </div>
            <div class="modal-body" style="height: 280px; overflow-y:scroll;">
				<form class="form-horizontal bv-form" id="addMemberForm"  method="post" style="margin-top: 5px;">
					<div class="form-group">
							<label class="col-md-4 control-label">会员姓名：</label>
							<div class="col-md-6 ">
								<input type="text"  id="member_name" name="memberName" class="form-control form-control-static">
							</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">性别：</label>
						<div class="col-md-6 ">
							<input type="radio" style="margin-left: 10px;" name="memberSex" value="0">男
		                   <input type="radio" style="margin-left: 10px;" name="memberSex" value="1" checked="checked">女
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">手机号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="member_phone" name="memberPhone" class="form-control form-control-static">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">生日：</label>
						<div class="col-md-6 ">
							<input type="text" id="entry_time" name="entryDate" onfocus="WdatePicker({lang:'zh-cn'})" class="form-control form-control-static"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">消费密码：</label>
						<div class="col-md-6 ">
							<input type="text"  id="member_pwd" name="memberPwd" value="000000" class="form-control form-control-static">
						</div>
					</div>
	            </form>
            </div>
            <div class="modal-footer">
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Member.closeDlg()">关闭</button>
                <button id="saveEmployeeButton"  type="button" onclick="Member.saveMember()" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div> 


<!-- 修改会员信息 -->
<div id="memberUpdateDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 605px;">
    <div class="modal-dialog" style="width: 100%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改会员信息</h4>
            </div>
            
            <div class="modal-body" style="height: 300px; overflow-y:scroll;">
				<form class="form-horizontal bv-form" id="memberUpdateForm"  method="post" style="margin-top: 15px;">
					<div class="form-group">
							<label class="col-md-4 control-label">姓名：</label>
							<div class="col-md-6 ">
								<input type="hidden"  id="update_member_id" name="memberId">
								<input type="text"  id="update_member_name" name="memberName" class="form-control form-control-static">
							</div>
					</div>
			
					<div class="form-group">
						<label class="col-md-4 control-label">性别：</label>
						<div class="col-md-6 ">
						   <input type="radio" style="margin-left: 10px;" id="update_member_sex0" name="memberSex" value="0">男
		                   <input type="radio" style="margin-left: 10px;" id="update_member_sex1" name="memberSex" value="1">女
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">手机号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="update_member_phone" name="memberPhone" class="form-control form-control-static">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">生日：</label>
						<div class="col-md-6 ">
							<input type="text" id="update_entry_time" name="entryDate" onfocus="WdatePicker({lang:'zh-cn'})" class="form-control form-control-static"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">总金额：</label>
						<div class="col-md-6 ">
							<input type="text"  id="update_total_money" name="totalMoney" class="form-control form-control-static">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-4 control-label">总积分：</label>
						<div class="col-md-6 ">
							<input type="text"  id="update_aggregate_score" name="aggregateScore" class="form-control form-control-static">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">密码还原：</label>
						<div class="col-md-6" class="form-control form-control-static">
							<input   type="radio"  style="margin-left: 10px;"  name="isResetPwd" value="1">是
							<input  type="radio"  style="margin-left: 10px;"  name="isResetPwd" value="2" checked="checked">否
						</div>
					</div>
	            </form>
            </div>
            <div class="modal-footer">
            	<!--用来清空表单数据-->
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Member.closeDlg()">关闭</button>
               <button type="button" onclick="Member.updateMember()" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 

<!--充值 -->
<div id="rechargeDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 600px;">
    <div class="modal-dialog" style="width: 100%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">账户充值</h4>
            </div>
            <div class="modal-body" style="height: 280px; overflow-y:scroll;">
				<form class="form-horizontal bv-form" id="rechargeForm"  method="post" style="margin-top: 5px;">
					<div class="form-group">
							<label class="col-md-4 control-label">会员姓名：</label>
							<div class="col-md-6 ">
								<input type="hidden"  id="recharge_member_id" name="memberId" class="form-control form-control-static" readonly="readonly">
								<input type="text"  id="recharge_member_name" name="memberName" class="form-control form-control-static" readonly="readonly">
							</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">手机号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="recharge_member_phone" name="memberPhone" class="form-control form-control-static" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">充值金额：</label>
						<div class="col-md-6 ">
							<input type="number"  name="totalMoney" class="form-control form-control-static"  step="1" min="0" >
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">备注：</label>
						<div class="col-md-6 ">
						<textarea  name="remark" rows="2" cols="27"></textarea>
						</div>
					</div>
	            </form>
            </div>
            <div class="modal-footer">
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Member.closeDlg()">关闭</button>
                <button id="saveEmployeeButton"  type="button" onclick="Member.recharge()" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div> 


<!--消费 -->
<div id="consumeDlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 600px;">
    <div class="modal-dialog" style="width: 100%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">账户消费</h4>
            </div>
            <div class="modal-body" style="height: 280px; overflow-y:scroll;">
				<form class="form-horizontal bv-form" id="consumeForm"  method="post" style="margin-top: 5px;">
					<div class="form-group">
							<label class="col-md-4 control-label">会员姓名：</label>
							<div class="col-md-6 ">
								<input type="hidden"  id="consume_member_id" name="memberId" class="form-control form-control-static" readonly="readonly">
								<input type="text"  id="consume_member_name" name="memberName" class="form-control form-control-static" readonly="readonly">
							</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">手机号：</label>
						<div class="col-md-6 ">
							<input type="text"  id="consume_member_phone" name="memberPhone" class="form-control form-control-static" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">可用余额：</label>
						<div class="col-md-6 ">
							<input type="text"  id="consume_residue_money"  class="form-control form-control-static" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">消费金额：</label>
						<div class="col-md-6 ">
							<input type="number"  name="totalMoney" class="form-control form-control-static"  step="1" min="0" >
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">消费密码：</label>
						<div class="col-md-6 ">
							<input type="text"  name="memberPwd"  class="form-control form-control-static">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label">备注：</label>
						<div class="col-md-6 ">
						<textarea  name="remark" rows="2" cols="27"></textarea>
						</div>
					</div>
	            </form>
            </div>
            <div class="modal-footer">
            	<input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="Member.closeDlg()">关闭</button>
                <button id="saveEmployeeButton"  type="button" onclick="Member.consume()" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div> 
</div>
</body>
</html>