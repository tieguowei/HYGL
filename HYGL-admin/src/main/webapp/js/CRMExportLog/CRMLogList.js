//系统管理--字典管理的单例对象
var CRMLogList = {
    seItem: null		//选中的条目
};
$(function(){
	CRMLogList.initJobTable();
});

var CRMLogList = function () {
    return{
        initJobTable:function(){
            $('#log-table').bootstrapTable({
                url: "crmExport/getLogCountList",
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
                queryParams: CRMLogList.queryParams,//传递参数（*）
                columns : [
	            	{
	                    field : "date",
	                    title : "日期",
	                    width : "200px",
	                    align : "center",
	                    valign : "middle",
	                    cellStyle:formatTableUnit,
	                    formatter:paramsMatter,
	                    sortable : "true"
	                },
	                {
	                    field : "logCount",
	                    title : "CRM导出日志数",
	                    width : "180px",
	                    align : "center",
	                    valign : "middle",
	                    cellStyle:formatTableUnit,
	                    formatter:paramsMatter,
	                    sortable : "true"
	                },
	                {
	                    field : "sqlCount",
	                    title : "SQL导出日志数",
	                    width : "180px",
	                    align : "center",
	                    valign : "middle",
	                    cellStyle:formatTableUnit,
	                    formatter:paramsMatter,
	                    sortable : "true"
	                },
	                {
	                    field : "result",
	                    title : "比对结果",
	                    width : "150px",
	                    align : "center",
	                    valign : "middle",
	                    cellStyle:formatTableUnit,
	                    formatter:paramsMatter,
	                    sortable : "true"
	                },
	                {
	                    field : "result",
	                    title : "详细信息",
	                    width : "150px",
	                    align : "center",
	                    valign : "middle",
	                    formatter: function (value, row, index) {
	                        var retStr = "";
	                        retStr= '<a href="javascript:void(0);" onclick="lookJobMonitorList(\''+row.date+'\');" ><span style="color:blue;">查看详情</span></a>';
	                        return retStr;
	                    }
	                }
            	],
                formatLoadingMessage : function() {
                   // return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        }
    }
}();

function lookJobMonitorList(date){
	//关闭新建和修改tab 解决传参问题
	$(".active").removeClass("active");
	if ($("#content575").length){//如果当前tab已存在
		//clickTab(575,"monitor/toJobMonitorPage?id="+processId+"&version="+version);
		clickTab(575,"crmExport/goJobBasicPage/"+date);
		$("#tab_575").addClass('active');
		$("#content575").addClass("active").addClass("in");;//iframe内容显示隐藏
		
	}else{
//		$('#myTab').append("<li id='tab_666'><a onclick=clickTab(666,'history/toJobPage?id="+processId+"&version="+version+"') href='#content666' data-toggle='pill'>作业运行历史<i onclick='closeTab(666)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		$('#myTab').append("<li id='tab_575'><a onclick=clickTab(575,'crmExport/goJobBasicPage/"+date+"') href='#content575' data-toggle='pill'>日志详情<i onclick='closeTab(575)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content575'></div>");
		 clickTab(575,"crmExport/goJobBasicPage/"+date);
		 $('#myTab a:last').tab('show');
	}
};

