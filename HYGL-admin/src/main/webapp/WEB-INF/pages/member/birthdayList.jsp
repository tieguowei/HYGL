<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/include/core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>生日提醒</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${path}/css/system/employee/employeePage.css">
   	<script src="${path}/js/member/birthdayPage.js" charset="UTF-8" type="text/javascript"></script>
    <script src="${path}/static/js/bootstrap.js"></script>
</head>
<body>
<div class="panel panel-default">
	<div class="panel-body">
		<form id="memberSearchForm" class=" form-inline" style="margin-bottom: 0;">
		  <div class="form-group">
		    <div class="col-md-2 ">
		   		 <input type="text" value="5" class="form-control" id="set_day_param" name="param" placeholder="设置生日提醒天数">
		    </div>
		  </div>
  		<button type="button" onclick="MemberBirthday.setDayParam()" class="btn btn-info ">
   			<span class="glyphicon glyphicon-search" aria-hidden="true" >确定</span>
   		</button>
   		<button type="button" onclick="MemberBirthday.empty()" class="btn btn-danger ">
   			<span class="glyphicon glyphicon-remove" aria-hidden="true" > 清空</span>
   		</button>
</form>
	</div>
<!--列表 -->
<table id="member-birthday-table" class="table table-hover table-striped table-condensed table-bordered"></table>
</body>
</html>