
/**
 *作业运行监控
 */
var demoIframe;
var JobMonitor = {
    seItem: null		//选中的条目
};
var processId = $("#job_monitor_process_id").val();
var version = $("#job_monitor_version").val();
$(function (){
    JobMonitor.init();
    $('.close').click(function(){
    	JobMonitor.closeDlg();
	 });
    
    //初始化运行状态筛选条件
    $.ajax({
        url:'systemDict/findDictNameByDictType',
        type:'post',
        data:{
        	"dictType":"JOB_RUN_STATUS"
        	},
        success:function(data){
        	var h = "";  
            $.each(data, function(key, value) {
                h += "<option value='" + value.dict_code + "'>" + value.dict_name //下拉框序言的循环数据
                + "</option>";  
            });  
            $("#search_job_monitor_run_status").append(h);//append 添加进去并展示  
            $("#search_job_monitor_run_status").on(  
	            "change"
	           )
        },
    });
    
    //初始化流程类型筛选条件
    $.ajax({
        url:'systemDict/findDictNameByDictType',
        type:'post',
        data:{
        	"dictType":"JOB_TYPE"
        	},
        success:function(data){
        	var h = "";  
            $.each(data, function(key, value) {
                h += "<option value='" + value.dict_code + "'>" + value.dict_name //下拉框序言的循环数据
                + "</option>";  
            });  
            $("#search_job_monitor_type").append(h);//append 添加进去并展示  
            $("#search_job_monitor_type").on(  
	            "change"
	           )
        },
    });
});
//表格数据展示
var JobMonitor = function (){
    return{
        init:function (){
            $('#JobMonitor-table').bootstrapTable({
                url: "history/getJobHistoryList",
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
                queryParams: JobMonitor.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#JobMonitor-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#JobMonitor-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },
	             {
	                 field : "job_number",
	                 title : "作业ID",
	                 align : "center",
	                 valign : "middle",
	                 sortable : "true"
	                },{
                    field : "job_name",
                    title : "作业名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    formatter: function (value, row, index) {
                        var retStr = "";
                        retStr += '<a href="javascript:void(0);" onclick="lookJobMonitorDetail(\''+row.id+'\');" ><span style="color:blue;">'+row.job_name+'</span></a>';
                        return retStr;
                    }
                }, {
                    field : "job_type",
                    title : "作业类型",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "run_status",
                    title : "运行状态",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "jobNames",
                    title : "上一作业名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "start_run_time",
                    title : "起始运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "end_run_time",
                    title : "结束运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "run_duration",
                    title : "运行时长",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field: 'operate',
                    align: 'center',
                    width: 150,
                    title: '操作',
                    formatter: function (value, row, index) {
                        var retStr = "";
                        if(row.error_info != '' && row.error_info != 'undefined'){
                        	retStr = '&nbsp;&nbsp;<a href="javascript:void(0);" onclick="lookErrorDetail(\''+row.error_info+'\');" ><span style="color:red;">错误信息</span></a>';
                        }
                        return retStr;
                    }
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
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
                processId :processId,
                version:version,
                jobName:$("#search_job_monitor_name").val(),
                jobType: $("#search_job_monitor_type").val(),
                runStatus: $("#search_job_monitor_run_status").val(),
            };
            return temp;
        },
        //搜索
        searchJobMonitor:function () {
            $("#JobMonitor-table").bootstrapTable('refresh');
        },
        // 返回操作
        returnWorkflowMonitorList:function(menuId){
        	closeTab(555);
        	createWorkflowMonitorListTab(menuId);
       },
      
	}
}();

function lookErrorDetail(errorInfo){
	$.alert({
        title: '错误信息！',
        content: errorInfo,
        type: 'red'
    });
};

/**
 * 查看作业监控详情
 * @param id
 */
function lookJobMonitorDetail(id){
	$(".active").removeClass("active");
	if ($("#content554").length){//如果当前tab已存在
		clickTab(554,"monitor/toJobMonitorDetailPage?id="+id);
		$("#tab_554").addClass('active');
		$("#content554").addClass("active").addClass("in");;//iframe内容显示隐藏
	}else{
		 $('#myTab').append("<li id='tab_554'><a onclick=clickTab(554,'monitor/toJobMonitorDetailPage?id="+id+"') href='#content554' data-toggle='pill'>作业监控详情<i onclick='closeTab(554)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content554'></div>");
		 clickTab(554,"monitor/toJobMonitorDetailPage?id="+id);
		 $('#myTab a:last').tab('show');
	}
};

//打开流程监控运行历史
function createWorkflowMonitorListTab(menuId){
	$(".active").removeClass("active");
	clickTab(menuId,"monitor/goProcessMonitor");
	$("#tab_"+menuId).addClass('active');
	$("#content"+menuId).addClass("active");//iframe内容显示隐藏
};
