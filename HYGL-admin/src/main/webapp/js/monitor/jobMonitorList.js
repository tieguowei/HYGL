
/**
 *作业运行监控
 */
var demoIframe;
var JobMonitor = {
    seItem: null		//选中的条目
};
var processId = $("#job_monitor_process_id").val();
var version = $("#job_monitor_version").val();
var status = $("#job_monitor_status").val();
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
                h += "<option value='" + value.dict_code + "'>" + value.dict_name
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
                uniqueId: "historyId", //每一行的唯一标识，一般为主键列
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
	                 sortable : "true",
	                 cellStyle:formatTableUnit,
	                 formatter:paramsMatter
	                },{
                    field : "job_name",
                    title : "作业名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    formatter: function (value, row, index) {
                        var retStr = "";
                        retStr += '<a href="javascript:void(0);" onclick="lookJobMonitorDetail(\''+row.historyId+'\',\''+row.job_basic_id+'\',\''+row.process_id+'\',\''+row.flag+'\');" ><span style="color:blue;">'+row.job_name+'</span></a>';
                        return retStr;
                    }
                }, {
                    field : "job_type",
                    title : "作业类型",
                    width: '80px',
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
                    width: '144px',
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "end_run_time",
                    title : "结束运行时间",
                    width: '144px',
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
                },{
                    field: 'operate',
                    align: 'center',
                    width: 150,
                    title: '操作',
                    formatter: function (value, row, index) {
                        var retStr = "";
                        var retStr1= "";
                        //未运行或者是中断，并且errorInfo不为空
                        if(!isEmpty(row.error_info) && (row.run_status == 4 ||row.run_status == 1)){
                        	retStr = '&nbsp;&nbsp;<a href="javascript:void(0);" onclick="lookErrorDetail(\''+row.historyId+'\');" ><span style="color:red;">错误信息</span></a>';
                        }
                        if(row.run_status == 2){
                        	retStr1 = '&nbsp;&nbsp;<a href="javascript:void(0);" onclick="jobStop(\''+row.historyId+'\',\''+row.process_id+'\');" > <span style="color:blue;">停止</span></a>';
                        }
                        if(row.run_status == 4 || row.run_status == 1){
                        	retStr1 = '&nbsp;&nbsp;<a href="javascript:void(0);" onclick="jobStart(\''+row.version+'\',\''+row.job_basic_id+'\',\''+row.process_id+'\',\''+row.flag+'\');" > <span style="color:blue;">启动</span></a>';
                        }
                        return retStr + retStr1;
                    }
                }],
                formatLoadingMessage : function() {
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }, 
                onLoadSuccess:function(){
                	setInterval(function () {
                		var allTableData =  $('#JobMonitor-table').bootstrapTable('getData');//获取表格的所有内容行
                		var ids  = ""
                		for( i=0;i<allTableData.length;i++){
                			 var id = allTableData[i].historyId;
                			 ids += id+",";
                		}
                		$.ajax({
                			url: "history/getLastJobHistoryList",
                	        type:'post',
                	        data:{
                	        	"ids":ids
                	        },
                	        async: false,
                	        success:function(data){
                	        	if($.trim(data)!=null){
                	        		for(var j=0;j<data.length;j++){
                	        			var obj = data[j];
                	        			updateRow(getRowIndex(obj.historyId),obj);
                	        		}
                	        	}
                	        }
                	    });
                	}, 2000);
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
       closeDlg:function(){
    	   $("#errorModel").modal('hide');
       }
	}
}();

/**
 * 查看错误信息
 * @param id
 */
function lookErrorDetail(id){
	$.ajax({
	    url:'monitor/findJobErrorById',
	    type:'post',
	    data:{
	    	"id":id
	    },
	    success:function(data){
	    	openErrorModel(data.errorInfo)
	    }
	 });
}

function openErrorModel(errorInfo){
	$("#errorInfoDiv").html(errorInfo);
	$("#errorModel").modal('show');
}

/**
 * 查看作业监控详情
 * @param id
 */
function lookJobMonitorDetail(historyId,jobBasicId,processId,flag){
	$(".active").removeClass("active");
	if ($("#content554").length){//如果当前tab已存在
		clickTab(554,"monitor/toJobMonitorDetailPage?historyId="+historyId+"&jobBasicId="+jobBasicId+"&processId="+processId+"&flag="+flag);
		$("#tab_554").addClass('active');
		$("#content554").addClass("active").addClass("in");;//iframe内容显示隐藏
	}else{
		 $('#myTab').append("<li id='tab_554'><a onclick=clickTab(554,'monitor/toJobMonitorDetailPage?historyId="+historyId+"&jobBasicId="+jobBasicId+"&processId="+processId+"&flag="+flag+"') href='#content554' data-toggle='pill'>作业监控详情<i onclick='closeTab(554)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content554'></div>");
		 clickTab(554,"monitor/toJobMonitorDetailPage?historyId="+historyId+"&jobBasicId="+jobBasicId+"&processId="+processId+"&flag="+flag);
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

/**
 * 作业手动启动
 * @param jobBasicId
 * @param jobUrl
 */
function jobStart(version,jobBasicId,processId,flag){
	
	$.ajax({
	        url:'monitor/jobStart',
	        type:'post',
	        data:{
	        	"version":version,
	        	"jobBasicId":jobBasicId,
	        	"processId":processId,
	        	"flag":flag
	        	},
	        success:function(data){
	        	console.log(data);
	        	if(data){
	        		$("#JobMonitor-table").bootstrapTable('refresh');
	        	}else{
	        		$.alert({
                        title: '提示信息！',
                        content: '运行失败！',
                        type: 'blue'
                    });
	        	}
	        },
	    });
}


/**
 * 作业停止
 */
function jobStop(historyId,processId){
	$.ajax({
	        url:'monitor/manualStop',
	        type:'post',
	        data:{
	        	"processId":processId,
	        	"id":historyId
	        	},
	        success:function(data){
	        	if(data){
	        		$("#JobMonitor-table").bootstrapTable('refresh');
	        	}else{
	        		$.alert({
                        title: '提示信息！',
                        content: '停止失败！',
                        type: 'blue'
                    });
	        	}
	        },
	    });
}

function getRowIndex(id){
	var index ;
	var allTableData = $("#JobMonitor-table").bootstrapTable('getData');
	for(var i=0;i<allTableData.length;i++){
		if(allTableData[i].historyId==id){
			index  = i;
			break;
		}
	}
	return index;
};

function updateRow(index,obj){
	 $('#JobMonitor-table').bootstrapTable('updateRow', {
	       index: index,
	       row: {
	    	   run_status_zh: obj.run_status_zh,
	    	   start_run_time:obj.start_run_time,
	    	   end_run_time:obj.end_run_time,
	    	   run_duration:obj.run_duration,
	    	   error_info:obj.error_info,
	    	   run_status:obj.run_status
	      }
	});
}
