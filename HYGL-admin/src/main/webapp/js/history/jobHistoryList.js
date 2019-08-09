
/**
 *作业运行历史
 */
var demoIframe;
var JobHistory = {
    seItem: null		//选中的条目
};
var processId = $("#job_history_process_id").val();
var version = $("#job_history_version").val();
var menuId = $("#job_history_menu_id").val();
var status = $("#job_history_status").val();
$(function (){
    JobHistory.init();
    $('.close').click(function(){
    	JobHistory.closeDlg();
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
            $("#search_job_history_type").append(h);//append 添加进去并展示  
            $("#search_job_history_type").on(  
	            "change"
	           )
        },
    });
});
//表格数据展示
var JobHistory = function (){
    return{
        init:function (){
            $('#JobHistory-table').bootstrapTable({
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
                queryParams: JobHistory.queryParams,//传递参数（*）
                columns : [{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#JobHistory-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#JobHistory-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },
	             {
	                 field : "job_number",
	                 title : "作业ID",
	                 align : "center",
	                 valign : "middle",
	                 sortable : "true",
	                 cellStyle:formatTableUnit,
	                 formatter:paramsMatter
	                },{
                    field : "job_name",
                    title : "作业名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter,
                    formatter: function (value, row, index) {
                        var retStr = "";
                         retStr= '<a href="javascript:void(0);" onclick="lookJobHistoryDetail(\''+row.historyId+'\');" ><span style="color:blue;">'+row.job_name+'</span></a>';
                        return retStr;
                    }
                }, {
                    field : "job_type",
                    title : "作业类型",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "run_status_zh",
                    title : "运行状态",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "jobNames",
                    title : "上一作业名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "start_run_time",
                    title : "起始运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "end_run_time",
                    title : "结束运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "run_duration",
                    title : "运行时长",
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
            
            
            /**
             * 作业错误及操作日志列表
             */
            $('#JobErrorOrLog-table').bootstrapTable({
                url: "history/getJobErrorOrLogList",
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
                queryParams: JobHistory.queryParams,//传递参数（*）
                columns : [{
    				title: '序号',//标题  可不加
    				width : '50',
    				align : "center",
    				valign : "middle",
    	            switchable:false,
    	            formatter:function(value,row,index){
    	                var pageSize=$('#JobHistory-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
    	                var pageNumber=$('#JobHistory-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
    	                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
    	            }
                 },
                 {
                     field : "job_type",
                     title : "类型",
                     align : "center",
                     valign : "middle",
                     sortable : "true",
                     cellStyle:formatTableUnit,
                     formatter:paramsMatter
                    },{
                    field : "job_content",
                    title : "错误/操作内容",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "job_number",
                    title : "作业ID",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "job_name",
                    title : "作业名称",
                    align : "center",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "operator_time",
                    title : "报错/操作时间",
                    align : "center",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "operator",
                    title : "操作人",
                    align : "center",
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
                processId :processId,
                version:version,
                status:status,
                jobName:$("#search_job_history_name").val(),
                jobType: $("#search_job_history_type").val(),
                
            };
            return temp;
        },

        //搜索
        searchJobHistory:function () {
            $("#JobHistory-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#search_job_history_name").val('');
            $("#search_job_history_type").val('');
            $("#JobHistory-table").bootstrapTable('refresh');
        },
        // 返回流程运行历史
        returnWorkflowHistoryList:function(menuId){
        	closeTab(666);
        	createWorlflowHistoryListTab(menuId) 
       },
	}
}();
/**
 * 查看作业历史详情
 * @param id
 */
function lookJobHistoryDetail(id){
	//关闭新建和修改tab 解决传参问题
	$(".active").removeClass("active");
	if ($("#content665").length){//如果当前tab已存在
		clickTab(665,"history/toJobDetailPage?id="+id);
		$("#tab_665").addClass('active');
		$("#content665").addClass("active").addClass("in");;//iframe内容显示隐藏
	}else{
		 $('#myTab').append("<li id='tab_665'><a onclick=clickTab(665,'history/toJobDetailPage?id="+id+"') href='#content665' data-toggle='pill'>作业历史详情<i onclick='closeTab(665)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content665'></div>");
		 clickTab(665,"history/toJobDetailPage?id="+id);
		 $('#myTab a:last').tab('show');
	}
}
//打开流程运行历史
function createWorlflowHistoryListTab(menuId){
	$(".active").removeClass("active");
	clickTab(menuId,"history/goProcessPage");
	$("#tab_"+menuId).addClass('active');
	$("#content"+menuId).addClass("active");//iframe内容显示隐藏
};
