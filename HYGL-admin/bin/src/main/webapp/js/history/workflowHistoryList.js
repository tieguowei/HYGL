
/**
 *流程运行历史
 */
var demoIframe;
var ProcessHistory = {
    seItem: null		//选中的条目
};

$(function (){
    ProcessHistory.init();
    $('.close').click(function(){
    	ProcessHistory.closeDlg();
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
            $("#search_process_type").append(h);//append 添加进去并展示  
            $("#search_process_type").on(  
	            "change"
	           )
        },
    });
});
//表格数据展示
var ProcessHistory = function (){
    return{
        init:function (){
            $('#ProcessHistory-table').bootstrapTable({
                url: "history/getProcessHistoryList",
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
                queryParams: ProcessHistory.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#ProcessHistory-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#ProcessHistory-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },
	             {
	                 field : "create_time",
	                 title : "运行日期",
	                 align : "center",
	                 valign : "middle",
	                 sortable : "true"
	                },{
                    field : "process_name",
                    title : "流程名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "process_type",
                    title : "流程类型",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "process_sketch",
                    title : "流程简述",
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
                         retStr= '<a href="javascript:void(0);" onclick="lookJobHistoryList(\''+row.process_id+'\',\''+row.version+'\');" ><span style="color:blue;">查看</span></a>';
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
                processName: $("#search_process_name").val(),
                processType:$("#search_process_type").val(),
                minCreateTime:$("#minCreateTime").val(),
                maxCreateTime:$("#maxCreateTime").val(),
            };
            return temp;
        },

        //搜索
        searchProcessHistory:function () {
            $("#ProcessHistory-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#search_process_name").val('');
            $("#search_process_type").val('');
            $("#minCreateTime").val('');
            $("#maxCreateTime").val('');
            $("#ProcessHistory-table").bootstrapTable('refresh');
        },
	}
}();

/**
 * 添加悬浮效果
 * @param value
 * @param row
 * @param index
 * @returns
 */
function paramsMatter(value,row,index) {
	var span=document.createElement('span');
	span.setAttribute('title',value);
	span.innerHTML = value; 
	return span.outerHTML; 
};
function formatTableUnit(value, row, index) { 
	return {
		css: { "white-space": 'nowrap', "text-overflow": 'ellipsis', "overflow": 'hidden' } 
	}
};

function lookJobHistoryList(processId,version){
	//先关闭作业运行历史和作业详情
	closeTab(666);
	closeTab(665);
	$(".active").removeClass("active");
	if ($("#content666").length){//如果当前tab已存在
		clickTab(666,"history/toJobPage?id="+processId+"&version="+version);
		$("#tab_666").addClass('active');
		$("#content666").addClass("active").addClass("in");;//iframe内容显示隐藏
		
	}else{
		 $('#myTab').append("<li id='tab_666'><a onclick=clickTab(666,'history/toJobPage?id="+processId+"&version="+version+"') href='#content666' data-toggle='pill'>作业运行历史<i onclick='closeTab(666)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content666'></div>");
		 clickTab(666,"history/toJobPage?id="+processId+"&version="+version);
		 $('#myTab a:last').tab('show');
	}
};
