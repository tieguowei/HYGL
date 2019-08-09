
/**
 *流程管理
 */
var demoIframe;
//系统管理--员工管理的单例对象
var ProcessConfig = {
    seItem: null		//选中的条目
};

$(function (){
    ProcessConfig.init();
    $('.close').click(function(){
    	ProcessConfig.closeDlg();
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
var ProcessConfig = function (){
    return{
        init:function (){
            $('#ProcessConfig-table').bootstrapTable({
                url: "workflow/getWorkflowList",
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
                toolbar:"#workflowToolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: ProcessConfig.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
               },{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#ProcessConfig-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#ProcessConfig-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },{
                    field : "process_name",
                    title : "流程名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
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
                    field : "operator_time",
                    title : "操作时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "operator",
                    title : "操作人",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "remark",
                    title : "操作内容",
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
                         retStr= "<a href='javascript:void(0);' onclick='lookDetail(" + row.id + ");' ><span style='color:blue;'>查看</span></a>";
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
            };
            return temp;
        },

        //搜索
        searchProcessConfig:function () {
            $("#ProcessConfig-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#search_process_name").val('');
            $("#search_process_type").val('');
            $("#ProcessConfig-table").bootstrapTable('refresh');
        },
        //创建修改tab
        createUpdateProcessTab:function(){
        	if(this.checkSingleData()) {
        		//关闭 新建和查看流程 tab。解决传参问题
        		closeTab(999);
            	closeTab(777);
        		var id = ProcessConfig.seItem.id;
        		$(".active").removeClass("active");
            	if ($("#content888").length){//如果当前tab已存在
    				clickTab(888,"workflow/toUpdateProcess?id="+id);
    				$("#tab_888").addClass('active');
    				$("#content888").addClass("active").addClass("in");;//iframe内容显示隐藏
    				
    			}else{
    				 $('#myTab').append("<li id='tab_888'><a onclick=clickTab(888,'workflow/toUpdateProcess?id="+id+"') href='#content888' data-toggle='pill'>修改流程<i onclick='closeTab(888)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
    				 $('#myTabContent').append("<div class='tab-pane fade' id='content888'></div>");
    				 clickTab(888,"workflow/toUpdateProcess?id="+id);
    				 $('#myTab a:last').tab('show');
    			}
        	}
        	
        },
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#ProcessConfig-table').bootstrapTable('getSelections');
            if (selected.length == 0) {
            	 $.alert({
                     title: '提示信息！',
                     content: '至少选择一条记录！',
                     type: 'red'
                 });
                return false;
            }else if (selected.length > 1){
            	 $.alert({
                     title: '提示信息！',
                     content: '该操作只能选择一条记录!',
                     type: 'blue'
                 });
            }else {
            	ProcessConfig.seItem = selected[0];
                return true;
            }
        },
        //创建新增流程tab
        createAddProcessTab:function(){
        	//关闭 修改和查看流程 tab。解决传参问题
        	closeTab(888);
        	closeTab(777);
        	$(".active").removeClass("active");
        	if ($("#content999").length){//如果当前tab已存在
				clickTab(999,"workflow/toAddProcess");
				$("#tab_999").addClass('active');
				$("#content999").addClass("active").addClass("in");//iframe内容显示隐藏
			}else{
				 $('#myTab').append("<li id='tab_999'><a onclick=clickTab(999,'workflow/toAddProcess') href='#content999' data-toggle='pill'>新增流程<i onclick='closeTab(999)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
				 $('#myTabContent').append("<div class='tab-pane fade' id='content999'></div>");
				 clickTab(999,"workflow/toAddProcess");
				 $('#myTab a:last').tab('show');
			}
        	
        },
    /**
     * 删除流程
     */
    deleteProcess:function(){
      	if(this.checkSingleData()) {
      		var id =ProcessConfig.seItem.id;
      		$.confirm({
                title: '提示信息!',
                content: '您确定要删除此流程吗？',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action: function(){
                        	$.ajax({
              	                url:'workflow/deleteProcess',
              	                dataType:'json',
              	                type:'post',
              	                traditional:true,
              	                data:{
              	                	id:id
              	                },
              	                success:function(data){
              	                	if(data){
              	                		 $.alert({
              	                             title: '提示信息！',
              	                             content: '删除成功！',
              	                             type: 'blue'
              	                         });
            	                         $("#ProcessConfig-table").bootstrapTable('refresh');
              	                	}else{
              	                		 $.alert({
              	                             title: '提示信息！',
              	                             content: '删除失败！',
              	                             type: 'red'
              	                         });
              	                	}
              	                },
              	                error:function(){
              	                    $.alert({
              	                        title: '提示信息！',
              	                        content: '删除失败！',
              	                        type: 'red'
              	                    });
              	                }
                      		})
                        }
                    },
                    取消: function () {
                    }
                }
            });
      	}
      },
	}
}();

function lookDetail(id){
	//关闭新建和修改tab 解决传参问题
	closeTab(888);
	closeTab(999);
	$(".active").removeClass("active");
	if ($("#content777").length){//如果当前tab已存在
		clickTab(777,"workflow/toLookProcess?id="+id);
		$("#tab_777").addClass('active');
		$("#content777").addClass("active").addClass("in");;//iframe内容显示隐藏
		
	}else{
		 $('#myTab').append("<li id='tab_777'><a onclick=clickTab(777,'workflow/toLookProcess?id="+id+"') href='#content777' data-toggle='pill'>查看流程<i onclick='closeTab(777)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content777'></div>");
		 clickTab(777,"workflow/toLookProcess?id="+id);
		 $('#myTab a:last').tab('show');
	}
};


