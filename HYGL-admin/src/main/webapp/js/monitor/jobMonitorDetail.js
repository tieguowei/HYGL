/**
 *作业运行历史详情
 */
var JobMonitorDetail = {
    seItem: null		//选中的条目
};
$(function (){
	JobMonitorDetail.init();
});
var id = $("#job_monitor_detail_process_id").val();
var version = $("#job_monitor_detail_version").val();
var processRunStatus = $("#job_monitor_process_runStatus").val();

//表格数据展示
var JobMonitorDetail = function (){
    return{
        init:function (){
            $('#JobMonitorDetail-table').bootstrapTable({
                url: "history/getJobUpdateHistory",
                method:"post",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                striped:true,//隔行变色
                cache:false,  //是否使用缓存
                showColumns:false,// 列
                pagination: true, //分页
                sortable: false, //是否启用排序
                singleSelect: false,
                search:false, //显示搜索框
                buttonsAlign: "right", //按钮对齐方式
                showRefresh:false,//是否显示刷新按钮
                sidePagination: "server", //服务端处理分页
                pageSize : 5, //默认每页条数
                pageNumber : 1, //默认分页
                pageList : [ 5, 10, 20, 50],//分页数
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: JobMonitorDetail.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#JobMonitorDetail-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#JobMonitorDetail-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },
	             {
	                 field : "update_time",
	                 title : "修改时间",
	                 align : "center",
	                 valign : "middle",
	                 sortable : "true",
	                 cellStyle:formatTableUnit,
	                 formatter:paramsMatter
	                },{
                    field : "update_content",
                    title : "修改内容",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "operator",
                    title : "操作人",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }],
                formatLoadingMessage : function() {
                   // return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                id:$("#job_monitor_jobBasicId").val(),
                
            };
            return temp;
        },
        //展示简述
        showJobHistorySketch:function(){
        	var jobHistorySketch  = $("#job_detail_history_sketch").val();
        	if(!isEmpty(jobHistorySketch)){
        		alert(jobHistorySketch)
        	}
        },
        //展示url
        showJobHistoryUrl:function(){
        	var jobHistoryUrl  = $("#job_detail_history_url").val();
        	if(!isEmpty(jobHistoryUrl)){
        		alert(jobHistoryUrl)
        	}
        },
        // 返回操作
        returnJobMonitorList:function(){
        	closeTab(554);
        	createJobMonitorListTab(555);
       },
	}
}();

//返回到作业运行监控列表页面
function createJobMonitorListTab(menuId){
	$(".active").removeClass("active");
	clickTab(555,"monitor/toJobMonitorPage?id="+processId+"&version="+version+"&runStatus="+processRunStatus);
	$("#tab_"+menuId).addClass('active');
	$("#content"+menuId).addClass("active");//iframe内容显示隐藏
};


