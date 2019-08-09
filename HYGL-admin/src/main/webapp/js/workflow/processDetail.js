
/**
 *修改流程
 */
var menuId =$("#menu_id").val();
var processId = $("#global_process_id").val()
//系统管理--流程 作业的单例对象
var ProcessJobRelation = {
    seItem: null		//选中的条目
};

$(function (){
	ProcessJobRelation.init();
    $('.close').click(function(){
    	ProcessJobRelation.closeRelationDlg();
	 });
    //初始化作业名称  -- 添加节点页面使用
    $.ajax({
        url:'workflow/findJobBasicList',
        type:'post',
        success:function(data){
        	var h = "";  
            $.each(data, function(key, value) {
                h += "<option value='" + value.id + "'>" + value.job_name //下拉框序言的循环数据
                + "</option>";  
            });  
            $("#add_job_name").append(h);//append 添加进去并展示  
            $("#add_job_name").on(  
	            "change"
	           )
        },	
    });
});
//表格数据展示
var ProcessJobRelation = function (){
    return{
        init:function (){
        	/**
        	 * 加载节点信息列表
        	 */
            $('#ProcessJobRelation-table').bootstrapTable({
                url: "workflow/getRelationList",
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
                toolbar:"#jobBasicToolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: ProcessJobRelation.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#ProcessJobRelation-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#ProcessJobRelation-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },{
                    field : "job_name",
                    title : "作业名",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "job_sketch",
                    title : "作业简述",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "starting_work",
                    title : "起止作业",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "jobNames",
                    title : "关联上一作业名",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "operating_frequency",
                    title : "运行频率",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "run_date",
                    title : "运行日期",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field : "run_time",
                    title : "运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }],
                formatLoadingMessage : function() {
                    //return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
            /**
             * 加载流程修改信息列表
             */
            $('#updateProcessHistory-table').bootstrapTable({
                url: "workflow/updateProcessHistoryList",
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
                queryParams: ProcessJobRelation.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#ProcessJobRelation-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#ProcessJobRelation-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },{
                    field : "update_time",
                    title : "修改时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "update_content",
                    title : "修改内容",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "operator",
                    title : "操作人",
                    align : "center",
                    valign : "middle",
                    sortable : "true",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }],
                formatLoadingMessage : function() {
                    //return "请稍等，正在加载中...";
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
                jobName: $("#search_job_name").val(),
                //流程id 初始进入页面 无此参数。只有添加完流程后 才有
            	processId: processId,
            };
            return temp;
        },
       
        //搜索作业名称
        searchJobName:function () {
            $("#ProcessJobRelation-table").bootstrapTable('refresh');
        },
          //查看流程详情页面 返回操作
           returnProcessPageButton:function(menuId){
         	closeTab(777);
         	createDetailProcessTab(menuId);
          },
         
    }
}();
function createDetailProcessTab(menuId){
	$(".active").removeClass("active");
	if ($("#content"+menuId).length){//如果当前tab已存在
		clickTab(menuId,"workflow/goWorkflowPage");
		$("#tab_"+menuId).addClass('active');
		$("#content"+menuId).addClass("active");//iframe内容显示隐藏
		
	}else{
		 $('#myTab').append("<li id='tab_"+menuId+"'><a onclick=clickTab('"+menuId+"','workflow/toAddProcess') href='#content"+menuId+"' data-toggle='pill'>新增流程<i onclick='closeTab("+menuId+")' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content"+menuId+"'></div>");
		 clickTab(menuId,"workflow/goWorkflowPage");
		 $('#myTab a:last').tab('show');
	}
	
};
