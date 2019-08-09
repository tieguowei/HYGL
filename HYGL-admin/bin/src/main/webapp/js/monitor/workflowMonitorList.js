
/**
 *流程运行监控
 */
var demoIframe;
//系统管理--员工管理的单例对象
var ProcessConfigMonitor = {
    seItem: null		//选中的条目
};

$(function (){
    ProcessConfigMonitor.init();
    $('.close').click(function(){
    	ProcessConfigMonitor.closeDlg();
	 });
    
    
    //初始化运行状态筛选条件
    $.ajax({
        url:'systemDict/findDictNameByDictType',
        type:'post',
        data:{
        	"dictType":"PROCESS_RUN_STATUS"
        	},
        success:function(data){
        	var h = "";  
            $.each(data, function(key, value) {
                h += "<option value='" + value.dict_code + "'>" + value.dict_name //下拉框序言的循环数据
                + "</option>";  
            });  
            $("#monitor_search_run_status").append(h);//append 添加进去并展示  
            $("#monitor_search_run_status").on(  
	            "change"
	           )
        },
    });
    
    //初始化流程类型筛选条件
    $.ajax({
        url:'systemDict/findDictNameByDictType',
        type:'post',
        data:{
        	"dictType":"PROCESS_TYPE"
        	},
        success:function(data){
        	var h = "";  
            $.each(data, function(key, value) {
                h += "<option value='" + value.dict_code + "'>" + value.dict_name //下拉框序言的循环数据
                + "</option>";  
            });  
            $("#monitor_search_process_type").append(h);//append 添加进去并展示  
            $("#monitor_search_process_type").on(  
	            "change"
	           )
        },
    });
});
//表格数据展示
var ProcessConfigMonitor = function (){
    return{
        init:function (){
            $('#ProcessConfigMonitor-table').bootstrapTable({
                url: "monitor/getProcessMonitorList",
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
                toolbar:"#monitorWorkflowToolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: ProcessConfigMonitor.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#ProcessConfigMonitor-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#ProcessConfigMonitor-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },{
                    field : "process_name",
                    title : "流程名称",
                    align : "center",
                    valign : "middle",
                }, {
                    field : "process_type",
                    title : "流程类型",
                    align : "center",
                    valign : "middle",
                }, {
                    field : "process_sketch",
                    title : "流程简述",
                    align : "center",
                    valign : "middle",
                }, {
                    field : "run_status",
                    title : "运行状态",
                    align : "center",
                    valign : "middle",
                }, {
                    field : "run_time",
                    title : "本次运行时间",
                    align : "center",
                    width: '200px',
                    valign : "middle",
                }, {
                    field : "start_run_time",
                    title : "起始运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "run_duration",
                    title : "运行时长",
                    align : "center",
                    valign : "middle",
                },{
                    field: 'operate',
                    align: 'center',
                    width: 150,
                    title: '作业运行详情',
                    formatter: function (value, row, index) {
                        var retStr = "";
                        retStr= '<a href="javascript:void(0);" onclick="lookJobMonitorList(\''+row.id+'\',\''+row.version+'\');" ><span style="color:blue;">查看</span></a>';
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
                processName: $("#monitor_search_process_name").val(),
                processType:$("#monitor_search_process_type").val(),
                runStatus:$("#monitor_search_run_status").val(),
            };
            return temp;
        },
        //搜索
        searchProcessConfigMonitor:function () {
            $("#ProcessConfigMonitor-table").bootstrapTable('refresh');
        },
       
	}
}();

function lookJobMonitorList(processId,version){
	//关闭新建和修改tab 解决传参问题
	$(".active").removeClass("active");
	if ($("#content555").length){//如果当前tab已存在
		clickTab(555,"monitor/toJobMonitorPage?id="+processId+"&version="+version);
		$("#tab_555").addClass('active');
		$("#content555").addClass("active").addClass("in");;//iframe内容显示隐藏
		
	}else{
		 $('#myTab').append("<li id='tab_555'><a onclick=clickTab(555,'monitor/toJobMonitorPage?id="+processId+"&version="+version+"') href='#content555' data-toggle='pill'>作业运行监控<i onclick='closeTab(555)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content555'></div>");
		 clickTab(555,"monitor/toJobMonitorPage?id="+processId+"&version="+version);
		 $('#myTab a:last').tab('show');
	}
};

