<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<%@ include file="/include/index_core.jsp" %>
<html>
<head>
    <title>会员管理系统</title>
</head>
<style>
 table td{
     overflow: hidden;
     text-overflow:ellipsis;
     white-space: nowrap;
     font-size:12px;
     font-family: "Microsoft YaHei";
     font-weight:400;
}
.table>thead th { font-size: 12px; background: #e2ebef!important;}
.btn .glyphicon{ top: 0;}
.btn .glyphicon { line-height: normal;}
.btn .glyphicon::before {
	font-size: 12px;
	margin-right: 3px;
}
.panel { border: none!important; border-radius: 0;}
#myTabContent { margin-top: 20px;}
.bootstrap-table {padding: 0 10px 10px; background: #fff; overflow: hidden;}
.fixed-table-container { margin-top: 10px;  }
.fixed-table-toolbar { overflow: hidden;}
.btn-toolbar {
    margin-left: 0!important;
    background: #fff;
    padding-top: 10px;
    padding-left: 5px;
}
.bootstrap-table>.fixed-table-toolbar .btn-toolbar {
    margin-left: -5px!important;
    background: #fff;
    padding-top: 0;
    padding-left: 0;
}

#treeview .node-selected,
#treeview .search-result  {     
	color: #fff!important;
    background-color: #3872FF!important;
}
/*输入框*/
.form-control, 
.single-line {
	border:1px solid #1653E6!important;
	border-radius: 2px!important;
}
@media (min-width: 768px) {
  .form-inline .form-group {
	 
  }
  .form-inline .form-control {
    display: inline-block;
    width: auto;
    vertical-align: middle;
    height: 34px;
  }
  .form-inline .control-label {
    margin-bottom: 0;
    vertical-align: middle;
    width: 80px;
    line-height: 34px;
    padding-left: 10px; padding-right: 0;
  }
  .form-inline .control-label+.col-md-2 { padding-left: 0;}
}
@media (max-width: 768px) {
	 .fixed-sidebar.body-small #page-wrapper {
        margin: 0;
     }
}

.sysTitle {
	position:absolute; top:0; left:0; right:0; z-index:1;
	font-family: FZLTZHK--GBK1-0;
	font-size: 20px;
	color: #f2f2f2;
	letter-spacing: 0;
	line-height:70px;
	text-align: center;
	background: #2f4050;
}
#treeview {
	position: absolute; width: 240px; bottom: 0; top: 50px;
	overflow-y: scroll;
	padding-top: 15px;
}
.treeview .list-group-item{cursor:pointer}
.treeview span.indent{margin-left:10px;margin-right:10px}
.treeview span.icon{width:12px;margin-right:5px}
.treeview .node-disabled{color:#fff;cursor:not-allowed}
.node-treeview{color:#fff;}
.node-treeview:not(.node-disabled):hover{background-color:#3872FF;}
.treeview ul .list-group-item { border: none;}
.pagination {margin:0px;}
/* nav-tabs-top */
.myTabWrap { 
	position: absolute; top: 50px; left: 0; right: 0; 
	height: 40px; padding: 0 40px;overflow: hidden; background: #fff;
	transition: all .2s; 
	box-shadow: 0 1px 2px rgba(0,0,0,.1);
}
.myTabWrap .prev,
.myTabWrap .next {
	position: absolute; top: 0; z-index: 2;
	text-align: center; display: block; width: 40px; background: #fff;
	line-height: 40px; font-size: 20px; color: #999;
	cursor: pointer;
}
.myTabWrap .prev { left:0; border-right: 1px solid #f2f2f2; }
.myTabWrap .next { right:0; border-left: 1px solid #f2f2f2; }
.myTabWrap>.nav-pills {
	position: relative;	white-space:nowrap; font-size:0; 
}
.myTabWrap>.nav-pills > li { 
	display: inline-block; float: none; position: relative; border-right: 1px solid #f2f2f2;
}
.nav-pills > li + li { margin-left: 0; }
.myTabWrap>.nav-pills > li > a {
	border-radius: 0;
	padding: 0 15px;
	line-height: 44px;
	font-size: 13px;
	font-weight: normal;
}
.myTabWrap>.nav-pills > li:before {
	content:''; display:block; width:0; background:#19aa8d;	
	position: absolute; top: 0; left:0; height: 2px; z-index: 1;
	transition: all 0.2s;
}
.myTabWrap>.nav-pills > li.active:before { width:100%;}
.myTabWrap>.nav-pills > li.active {	border-left: none;}
.myTabWrap>.nav-pills > li.active > a, 
.myTabWrap>.nav-pills > li.active > a:hover, 
.myTabWrap>.nav-pills > li.active > a:focus {
	color: #999;
	background-color: #eee;
}
/* 顶部菜单 */
#page-wrapper .topNavbarWrap,
#page-wrapper #myTabContent {
	position:absolute; top: 0; left: 0; right: 0;
}
#page-wrapper #myTabContent { 
	top: 105px; bottom: 0; margin-top: 0; 
	overflow: auto; padding: 0 15px;
}

</style>
<script>


$(function(){ 
var myTabWrapWidth = $(".myTabWrap").width(),
	prevBtn = $(".myTabWrap .prev"),
	nextBtn = $(".myTabWrap .next"),
	mytabs = $("#myTab"); 
//上一页
prevBtn.click(function(){
	tabScroll.leftPage();
});

//下一页
nextBtn.click(function(){
	tabScroll.rightPage();
});
	
});
</script>

<body class="fixed-sidebar full-height-layout gray-bg">
<div>
    <nav class=" navbar-static-side" role="navigation" style="background:#324B7A; top: 0; ">
        <div class=""style="overflow-x: hidden;height: 100%; position:relative;">
             <div class="sysTitle" >会员管理系统</div>
              <!--展示左侧菜单 -->
             <div id="treeview" class=""></div>
             <input style="display: none" type="text" class="form-control" id="input-expand-node" placeholder="Identify node..." value=""/>              
        </div> 
</div>
    </nav>
    <div id="page-wrapper" class="gray-bg" style="height: 100%; position: relative;">
        <div class="row border-bottom topNavbarWrap">
            <nav class="navbar navbar-static-top  " role="navigation" style="margin-bottom: 0;background-color:#3872FF;">
                <ul class="nav metismenu pull-right" id="side-menu" >
                	<li class="nav-header" style="text-align: center;padding: 0;background:none;">
                		<div class="dropdown profile-element" style="width: 100px;margin-top: 10px; font-size: 14px;">
								<a data-toggle="dropdown" class="dropdown-toggle" href="#"> 
									<span class="clear">
							 			<span style="color:white;  margin-left:-30px;margin-top: 6px;" class="text-muted text-xs block" th:text="${employee.name}"><b class="caret"></b>
							 				${employee.name}
							 			</span>
									</span>
								</a>
							<ul class="dropdown-menu  m-t-xs">
								<li><a class="J_menuItem" onclick="openPassDlg()" href="#"><i class="fa fa-key"></i>&nbsp;修改密码</a></li>
								<li><a class="J_menuItem" onclick="quit()" href="#"><i class="fa fa-sign-out"></i>&nbsp;退出登陆</a></li>
							</ul>
						</div>
                </li>
              	</ul>
            </nav>
        </div>
		
		<div class="myTabWrap">
			<div class="prev">&laquo;</div>
			<div class="next">&raquo;</div>
			
			<ul id="myTab" class="nav nav-pills" style="left: 0;">
					<li class="active" style="width: 100px;">
						<a href="#home" data-toggle="tab" >
							 首页
						</a>
					</li>
			</ul>
		</div>

		<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					<h2 style="text-align: center; margin-top: 180px;">欢迎使用会员管理系统</h2>
				</div>
		</div>
    </div>
</div>


<!-- 修改密码modal -->
<div id="passDlg" class="modal fade"  tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="myform"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">旧密码：</label>
			<div class="col-md-3 ">
				<input type="password" id="oldPwd" name="oldPwd" class="form-control form-control-static"  placeholder="请输入原始密码">
				<input  type="hidden" id="employeeId" value="${employee.employeeId}" name="employeeId">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">新密码：</label>
			<div class="col-md-3 ">
				<input type="password" id="newPwd"  name="newPwd" class="form-control form-control-static" placeholder="请输入新密码">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">确认密码：</label>
			<div class="col-md-3">
				<input type="password" id="againPwd"  name="againPwd" class="form-control form-control-static" placeholder="请输入新密码">
			</div>
			</div>
            <div class="modal-footer col-md-6">
            <!--用来清空表单数据-->
            <input type="reset" name="reset" style="display: none;" />
                <button type="button" class="btn btn-default" onclick="closeDlgs()">关闭</button>
               <button type="button" onclick="updatePwd()" class="btn btn-primary">修改</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
