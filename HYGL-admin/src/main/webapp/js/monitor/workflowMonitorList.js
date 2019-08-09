
/**
 *流程运行监控
 */
var demoIframe;
var ProcessConfigMonitor = {
    seItem: null		//选中的条目
};

$(function (){
    ProcessConfigMonitor.init();
    $('.close').click(function(){
    	ProcessConfigMonitor.closeDlg();
	 });
    
   //setInterval("updateStatusAndTime();",5000);
    
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
                pageSize : 10, //默认每页条数
                pageNumber : 1, //默认分页
                pageList : [ 5, 10, 20, 50],//分页数
                toolbar:"#monitorWorkflowToolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: ProcessConfigMonitor.queryParams,//传递参数（*）
                clickToSelect: true,
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
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "process_type",
                    title : "流程类型",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "process_sketch",
                    title : "流程简述",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "run_status_zh",
                    title : "运行状态",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                }, {
                    field : "run_time",
                    title : "本次运行时间",
                    width: '100px',
                    align : "center",
                    valign : "middle",
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
                    field : "run_duration",
                    title : "运行时长",
                    align : "center",
                    valign : "middle",
                    cellStyle:formatTableUnit,
                    formatter:paramsMatter
                },{
                    field: 'operate',
                    align: 'center',
                    width: 150,
                    title: '作业运行详情',
                    formatter: function (value, row, index) {
                        var retStr = "";
                        retStr= '<a href="javascript:void(0);" onclick="lookJobMonitorList(\''+row.id+'\',\''+row.version+'\',\''+row.run_status+'\');" ><span style="color:blue;">查看</span></a>';
                        return retStr;
                    }
                }],
                formatLoadingMessage : function() {
                    //return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                },
                onLoadSuccess:function(){
                	setInterval(function () {
                		var allTableData =  $('#ProcessConfigMonitor-table').bootstrapTable('getData');//获取表格的所有内容行
                		var ids  = ""
                		for( i=0;i<allTableData.length;i++){
                			 var id = allTableData[i].id;
                			 ids += id+",";
                		}
                		$.ajax({
                			url: "monitor/getLastProcessMonitorList",
                	        type:'post',
                	        data:{
                	        	"ids":ids
                	        },
                	        async: false,
                	        success:function(data){
                	        	if($.trim(data)!=null){
                	        		for(var j=0;j<data.length;j++){
                	        			var obj = data[j];
                	        			updateRow(getRowIndex(obj.id),obj);
                	        		}
                	        	}
                	        }
                	    });
                	}, 5000);
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
        checkMultipleData:function(){
        	var getSelectRows = $("#ProcessConfigMonitor-table").bootstrapTable('getSelections', function (row) {
    	          return row;
  	  		});
      		if(getSelectRows.length==0){
                  return "";
      		}
      		var ids ="";
      		for(var i=0;i<getSelectRows.length;i++){
      			var row = getSelectRows[i];
      			ids+=row.id+",";
      		}
      		return ids;
        },
        //多个流程启动
        manualMultipleStart:function(){ 
        	var processIds = this.checkMultipleData();
        	if($.trim(processIds)==''){
        		 $.alert({
                     title: '提示信息！',
                     content: '至少选择一条记录！',
                     type: 'red'
                 });
                return false;
        	}
        	$.ajax({
       	        url:'monitor/manualMultipleStart',
       	        type:'post',
       	        data:{
       	        	"processIds":processIds
       	        	},
       	        success:function(data){
       	        	$("#ProcessConfigMonitor-table").bootstrapTable('refresh');
       	        	if(data.result){
       	        		$.alert({
                            title: '提示信息！',
                            content: '启动成功！',
                            type: 'red'
                        });
       	        	}else{
       	        		var msg = data.names;
       	        		if($.trim(msg)==''){
	       	        		$.alert({
	                            title: '提示信息！',
	                            content: '启动运行失败！',
	                            type: 'red'
	                        });
       	        		}else{
       	        			$.alert({
	                            title: '提示信息！',
	                            content: msg,
	                            type: 'red'
	                        });
       	        		}
       	        	}
       	        },
       	    });
        },
        /**
         * 流程手动启动
         */
        manualStart:function(){
         	if(this.checkSingleData()) {
          		var processId =ProcessConfigMonitor.seItem.id;
          		var result = checkRunStatus(processId);
          		if("1" == result){
          			$.ajax({
               	        url:'monitor/manualStart',
               	        type:'post',
               	        data:{
               	        	"processId":processId
               	        	},
               	        success:function(data){
               	        	if(data){
               	        		$("#ProcessConfigMonitor-table").bootstrapTable('refresh');
               	        	}else{
               	        		$.alert({
                                    title: '提示信息！',
                                    content: '启动运行失败！',
                                    type: 'red'
                                });
               	        	}
               	        },
               	    });
          		}else{
          			$.alert({
                        title: '提示信息！',
                        content: '不符合手动启动条件！',
                        type: 'blue'
                    });
          		}
         	}
         },
         /**
          * 手动停止
          */
         manualMultipleStop:function(){
        	 var processIds = this.checkMultipleData();
          	 if($.trim(processIds)==''){
          		 $.alert({
                       title: '提示信息！',
                       content: '至少选择一条记录！',
                       type: 'red'
                   });
                  return false;
          	 }
          	 
          	$.confirm({
                title: '提示信息!',
                content: '您确定要停止么，该操作可能会造成数据不完整！',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action:function (){
                        	$.ajax({
					     	        url:'monitor/manualMultipleStop',
					     	        type:'post',
					     	        data:{
					     	        	"processIds":processIds
					     	        	},
					     	        success:function(data){
					     	        	$("#ProcessConfigMonitor-table").bootstrapTable('refresh');
					     	        	if(data.result){
					     	        		$.alert({
					                            title: '提示信息！',
					                            content: '停止成功！',
					                            type: 'red'
					                        });
					     	        	}else{
					     	        		var msg = data.names;
					       	        		if($.trim(msg)==''){
						       	        		$.alert({
						                            title: '提示信息！',
						                            content: '停止失败！',
						                            type: 'red'
						                        });
					       	        		}else{
					       	        			$.alert({
						                            title: '提示信息！',
						                            content: msg,
						                            type: 'red'
						                        });
					       	        		}
					     	        	}
					     	        },
                        	 });
                        }
                    },
                    取消: function () {
                    }
                }
            });
    	},
         /**
          * 手动停止
          */
         manualStop:function(){
        	 if(this.checkSingleData()) {
           		var processId =ProcessConfigMonitor.seItem.id;
           		var result = checkRunStatus(processId);
          		if("2" == result){
          			$.ajax({
             	        url:'monitor/manualStop',
             	        type:'post',
             	        data:{
             	        	"processId":processId
             	        	},
             	        success:function(data){
             	        	if(data){
             	        		$("#ProcessConfigMonitor-table").bootstrapTable('refresh');
             	        	}else{
             	        		$.alert({
                                    title: '提示信息！',
                                    content: '停止失败！',
                                    type: 'red'
                                });
             	        	}
             	        },
             	    });
          		}else{
          			$.alert({
                        title: '提示信息！',
                        content: '不符合手动关闭条件！',
                        type: 'blue'
                    });
          		}
          	}
         },
        //搜索
        searchProcessConfigMonitor:function () {
            $("#ProcessConfigMonitor-table").bootstrapTable('refresh');
        },
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#ProcessConfigMonitor-table').bootstrapTable('getSelections');
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
            	ProcessConfigMonitor.seItem = selected[0];
                return true;
            }
        },
	}
}();

function lookJobMonitorList(processId,version,runStatus){
	//关闭新建和修改tab 解决传参问题
	$(".active").removeClass("active");
	if ($("#content555").length){//如果当前tab已存在
		clickTab(555,"monitor/toJobMonitorPage?id="+processId+"&version="+version+"&runStatus="+runStatus);
		$("#tab_555").addClass('active');
		$("#content555").addClass("active").addClass("in");//iframe内容显示隐藏
	}else{
		 $('#myTab').append("<li id='tab_555'><a onclick=clickTab(555,'monitor/toJobMonitorPage?id="+processId+"&runStatus="+runStatus+"&version="+version+"') href='#content555' data-toggle='pill'>作业运行监控<i onclick='closeTab(555)' class='fa fa-remove tab-close' style='padding-left: 3px;'></i></a></li>");
		 $('#myTabContent').append("<div class='tab-pane fade' id='content555'></div>");
		 clickTab(555,"monitor/toJobMonitorPage?id="+processId+"&version="+version+"&runStatus="+runStatus);
		 $('#myTab a:last').tab('show');
	}
};

function checkRunStatus(processId){
	 var result;
	 $.ajax({
	        url:'monitor/checkRunStatus',
	        type:'post',
	        data:{
	        	"processId":processId
	        	},
	        async: false,
	        success:function(data){
	        	result = data;
	        }
	    });
	 return result;
};
function updateStatusAndTime(){
	var allTableData =  $('#ProcessConfigMonitor-table').bootstrapTable('getData');//获取表格的所有内容行
	var ids  = ""
	for( i=0;i<allTableData.length;i++)
	{
		 var id = allTableData[i].id;
		 ids += id+",";
	}
	$.ajax({
		url: "monitor/getLastProcessMonitorList",
        type:'post',
        data:{
        	"ids":ids
        },
        async: false,
        success:function(data){
        	if($.trim(data)!=null){
        		for(var j=0;j<data.length;j++){
        			var obj = data[j];
        			updateRow(getRowIndex(obj.id),obj);
        		}
        	}
        }
    });
};

function getRowIndex(id){
	var index ;
	var allTableData = $("#ProcessConfigMonitor-table").bootstrapTable('getData');
	for(var i=0;i<allTableData.length;i++){
		if(allTableData[i].id==id){
			index  = i;
			break;
		}
	}
	return index;
};
function updateRow(index,obj){
	 $('#ProcessConfigMonitor-table').bootstrapTable('updateRow', {
	       index: index,
	       row: {
	    	   run_status_zh: obj.run_status_zh,
	    	   run_time:obj.run_time,
	    	   start_run_time:obj.start_run_time,
	    	   run_duration:obj.run_duration,
	    	   operate:'cs'
	      }
	});
}