//系统管理--字典管理的单例对象
var CRMExportLog = {
    seItem: null		//选中的条目
};
$(function(){
	/*Job.formValidator();*/
//	var a = '<%=request.getAttribute("aaa");%>' ;
//	alert(path);
//	alert(pathVarDate);
	CRMExportLog.initJobTable();
	CRMExportLog.initSqlLogTable();
	CRMExportLog.initCount();
    /*$('.close').click(function(){
    	Job.closeDlg();
	 });*/
    
   
});

var CRMExportLog = function () {
    return{
        initJobTable:function(){
            $('#job-table').bootstrapTable({
                url: "crmExport/getLogList",
                method:"post",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                striped:true,//隔行变色
                cache:false,  //是否使用缓存
                showColumns:false,// 列
//                toobar:'#toolbar',
//                pagination: true, //分页
//                sortable: false, //是否启用排序
//                singleSelect: false,
//                search:false, //显示搜索框
                buttonsAlign: "right", //按钮对齐方式
                showRefresh:false,//是否显示刷新按钮
//                sidePagination: "server", //服务端处理分页
//                pageSize : 20, //默认每页条数
//                pageNumber : 1, //默认分页
//                pageList : [5, 10, 20, 50 ],//分页数
//                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
//                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: CRMExportLog.queryParams,//传递参数（*）
                columns : [
            	{
                    field : "content",
                    title : "CRM操作内容",
                    width : "280px",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                },
                {
                    field : "createTime",
                    title : "CRM操作时间",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                }
            	],
                formatLoadingMessage : function() {
                   // return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        initSqlLogTable:function(){
            $('#sql-log-table').bootstrapTable({
                url: "crmExport/getSqlLogList",
                method:"post",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                striped:true,//隔行变色
                cache:false,  //是否使用缓存
                showColumns:false,// 列
//                toobar:'#toolbar',
//                pagination: true, //分页
//                sortable: false, //是否启用排序
//                singleSelect: false,
//                search:false, //显示搜索框
                buttonsAlign: "right", //按钮对齐方式
                showRefresh:false,//是否显示刷新按钮
//                sidePagination: "server", //服务端处理分页
//                pageSize : 20, //默认每页条数
//                pageNumber : 1, //默认分页
//                pageList : [5, 10, 20, 50 ],//分页数
//                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
//                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: CRMExportLog.queryParams,//传递参数（*）
                columns : [
            	{
                    field : "sql",
                    title : "SQL执行",
                    width : "80px",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                },
                {
                    field : "user",
                    title : "SQL账户",
                    width : "70px",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                },
                {
                    field : "userIp",
                    title : "访问IP",
                    width : "90px",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                },
                {
                    field : "checkRows",
                    title : "扫描行数",
                    width : "80px",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                },{
                    field : "ts",
                    title : "执行时间",
                    width : "150px",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    sortable : "true"
                }
            	],
                formatLoadingMessage : function() {
                   // return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        
        //得到查询的参数
        queryParams:function () {
	        var temp = {
        		date:$("#create_time").val(),
        		type:$("#search_log_type").val()
	        };
	        return temp;
        },
        searchJob:function () {
        	$("#sql-log-table").bootstrapTable('refresh');
            $("#job-table").bootstrapTable('refresh');
        	/*CRMExportLog.initJobTable();
        	CRMExportLog.initSqlLogTable();*/
            CRMExportLog.initCount();
        },
        //清空
        empty:function () {
            $("#create_time").val('');
            $("#search_log_type").val('');
            $("#sql-log-table").bootstrapTable('refresh');
            $("#job-table").bootstrapTable('refresh');
            CRMExportLog.initCount();
        },
        initCount:function(){
//        	alert("刷新")
        	$.ajax({
                url:'crmExport/countLogs',
                type:'post',
                data:{
                	 date: $("#create_time").val(),
                     type:$("#search_log_type").val(),
                	},
                success:function(data){
//                	alert($("#log-times-num").html())
//                	alert(data.sqlLogCount);
                	$("#log-times-num").html(data.indesLogCount);
                	$("#sql-times-num").html(data.sqlLogCount);
                },
            });
        	
        }
       
    }
}();

