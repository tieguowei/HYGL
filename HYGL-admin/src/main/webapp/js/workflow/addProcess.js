
/**
 *新增流程
 */
var menuId =$("#add_process_menu_id").val();
//系统管理--流程 作业的单例对象
var ProcessJobRelation = {
    seItem: null		//选中的条目
};

$(function (){
	ProcessJobRelation.formValidator();
	ProcessJobRelation.init();
    $('.close').click(function(){
    	ProcessJobRelation.closeRelationDlg();
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
            $("#add_process_type").append(h);//append 添加进去并展示  
            $("#add_process_type").on(  
	            "change"
	           )
        },
    });
    
    
  //初始化作业名称
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
                    title : "作业名称",
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
                    title : "起始作业",
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
                },{
                    field : "jobNames",
                    title : "上一作业名称",
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
        },
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                jobName: $("#add_search_job_name").val(),
                //流程id 初始进入页面 无此参数。只有添加完流程后 才有
            	processId: $("#add_process_id").val(),
            };
            return temp;
        },

        //搜索作业名称
        searchJobName:function () {
            $("#ProcessJobRelation-table").bootstrapTable('refresh');
        },
        //打开添加节点model
        openRelationAddDlg:function(){
            if($("#addProcessConfigForm").data('bootstrapValidator').validate().isValid()){
        		//新增流程信息入库
            	$.ajax({
                    url:'workflow/saveProcessConfig',
                    dataType:'json',
                    type:'post',
                    data:$("#addProcessConfigForm").serialize(),
                    success:function(data){
                    	if("0" != data){
                    		$("#add_process_id").val(data);
                    		$("#add_global_process_id").val(data);
                    		//加载上一作业
                        	loadCombobox(data,'');
                    	}
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '流程信息添加失败，请重新录入数据!',
                            type: 'red'
                        });
                    }
                });
            	$("#relationAddDlg").modal('show');
            	var processId = $("#add_process_id").val();
            	if(!isEmpty(processId)){
            		loadCombobox(processId,'');
            	}
        	}
        },
      //选择作业 追加作业简述
        selectJob:function(){
        	var jobId = $("#add_job_name").val();
        	 $.ajax({
        	        url:'workflow/findJobBasicById',
        	        type:'post',
        	        data:{
        	        	"jobId":jobId
        	        	},
        	        success:function(data){
        	        	$("#add_job_sketch").val('');
        	        	$("#add_job_sketch").val(data.jobSketch);
        	        	//再次初始化 上一关联作业
        	        	var jobBasicId = $("#add_job_name").val();
        	        	var processId = $("#add_process_id").val();
        	        	loadCombobox(processId,jobBasicId);
        	        },	
        	    });
        	
        },
       //添加 --》 点击简述 弹框显示内容
        tips:function(){
        	var jobSketch =  $("#add_job_sketch").val();
        	
        	if(!isEmpty(jobSketch)){
        		alert(jobSketch);
        	}
        },
        //修改--》 点击简述 弹框显示内容
        updateTips:function(){
        	var jobSketch =  $("#update_job_sketch").val();
        	if(!isEmpty(jobSketch)){
        		alert(jobSketch);
        	}
        },
       //添加 --》 初始作业 否：展示上一关联作业 [0：起点 1：终点 2:普通节点]
        selectStartWorking:function(){
        	var status = $("#add_starting_work").val();
        	if("1" == status || "2" == status){
        		//展示上一关联作业
        		document.getElementById("isShow").style.display = "block";
        		//隐藏运行【频率 日期 时间】
        		document.getElementById("dateIsShow").style.display = "none";
        	}
        	if("0" == status){
        		//隐藏上一关联作业
        		document.getElementById("isShow").style.display = "none";
        		//展示运行【频率 日期 时间】
        		document.getElementById("dateIsShow").style.display = "block";

        	}
        },
     // 修改 --》 初始作业 否()：展示上一关联作业
        updateSelectStartWorking:function(){
        	var status = $("#update_starting_work").val();
        	if("1" == status || "2" == status){
        		 var processId = $("#add_global_process_id").val();
        		 var jobBasicId = $("#update_job_basic_id").val();
        		 updateLoadCombobox(processId,jobBasicId);
        		//展示上一关联作业
        		 document.getElementById("update_isShow").style.display = "block";
        		//隐藏运行【频率 日期 时间】
        		 document.getElementById("update_date_isShow").style.display = "none";
        	}
        	if("0" == status){
        		//隐藏上一关联作业
        		document.getElementById("update_isShow").style.display = "none";
        		//展示运行【频率 日期 时间】
        		document.getElementById("update_date_isShow").style.display = "block";
        	}
        },
        //关闭节点的dialog
        closeRelationDlg:function(){
          $("#ProcessJobRelation-table").bootstrapTable('refresh');
    	  $("#relationAddDlg").modal('hide');
    	  $("#relationUpdateDlg").modal('hide');
          $("input[type=reset]").trigger("click");
          $("#update_run_date").empty();
          $("#add_run_date").empty(); 
          $('#addRelationForm').data('bootstrapValidator', null);
          $('#updateRelationForm').data('bootstrapValidator', null);
  		  document.getElementById("isShow").style.display = "none";
  		  ProcessJobRelation.formValidator();
        },
        //保存节点
        saveRelation:function(){
          if($("#addRelationForm").data('bootstrapValidator').validate().isValid()){
            var lastJobName = $('#lastJobName').combobox('getValue');
            var startWork =$("#add_starting_work").val();
            var result = true;
            if(startWork != 0 && startWork != ''){
            	if(lastJobName == '' || lastJobName== undefined){
            		result = false
            	}
            }
            if(result){
            	$.ajax({
	                url:'workflow/saveRelation',
	                dataType:'json',
	                type:'post',
	                data:$("#addRelationForm").serialize(),
	                success:function(data){
	                	 if("0" != data){
	                         $.alert({
	                             title: '提示信息！',
	                             content: '节点添加成功!',
	                             type: 'blue'
	                         });
	                		 $("#process_job_relation_id").val(data);
	                         $("#ProcessJobRelation-table").bootstrapTable('refresh');
	                         ProcessJobRelation.closeRelationDlg();
	                  		 document.getElementById("isShow").style.display = "none";
	                     }else{
	                         $.alert({
	                             title: '提示信息！',
	                             content: '节点添加失败！',
	                             type: 'red'
	                         });
	                     }
	                },
	                error:function(){
	                	 $.alert({
	                         title: '提示信息！',
	                         content: '节点添加失败！',
	                         type: 'red'
	                     });
	                }
              });
            }else{
            	 $.alert({
                     title: '提示信息！',
                     content: '上一关联作业不能为空！',
                     type: 'red'
                 });
            }
            }
        },
        //新增流程和节点
        saveProcessAndRelation:function(menuId){
            if($("#addProcessConfigForm").data('bootstrapValidator').validate().isValid()){
        	 closeTab(999);
        	 createAddProcessTab(menuId);
        	 $.alert({
        		 title: '提示信息！',
        		 content: '流程添加成功！',
        		 type: 'blue'
        	 });
            }
        },
        //删除流程和中间表关系
        deleteProcessAndRelation:function(menuId){
        	var processId = $("#add_global_process_id").val();
        	var id= $("#process_job_relation_id").val();
				$.ajax({
	                url:'workflow/deleteProcessAndRelation',
	                dataType:'json',
	                data:{
	                	  "processId":processId,
	                	  "id":id
	                	  },
	                type:'post',
	                success:function(data){
	                	 if(data){
	                         closeTab(999);
	                         createAddProcessTab(menuId);
	                     }else{
	                         $.alert({
	                             title: '提示信息！',
	                             content: '取消失败！',
	                             type: 'red'
	                         });
	                     }
	                }
	            });
        },
        //修改子节点
        openRelationUpdateDlg:function(){
        	if(this.checkSingleData()) {
            	var id = ProcessJobRelation.seItem.id;
                $.ajax({
                    url:'workflow/findRelationById',
                    dataType:'json',
                    type:'post',
                    traditional:true,
                    data:{
                    	id:id
                    },
                    success:function(data){
                    	//设置修改记录 的主键id
                    	$("#update_id").val(id);
                    	//设置修改节点的basicJobId
                    	$("#update_job_basic_id").val(data.job_basic_id);
                    	//流程id
                    	$("#update_process_id").val(data.process_id);

                    	//根据运行频率加载作业运行日期
                    	checkOperatingFrequency(data.operating_frequency,"update_run_date");
                    	//清除select 选中状态
                    	$("#update_starting_work").find("option:selected").attr("selected", false);
                    	$("#update_operating_frequency").find("option:selected").attr("selected", false);
                    	$("#update_run_date").find("option:selected").attr("selected", false);

                    	
                    	$("#update_job_name").val(data.job_name);//作业名称
                    	$("#update_job_sketch").val(data.job_sketch);//作业简述
                    	
                    	//不是起点
                    	if("0" != data.starting_work){
                    		//展示上一关联作业
                     		 document.getElementById("update_isShow").style.display = "block";
                     		//隐藏运行【频率 日期 时间】
                    		 document.getElementById("update_date_isShow").style.display = "none";
                     		 var processId = $("#add_global_process_id").val();
                     		 updateLoadCombobox(processId,data.job_basic_id);
                    	}else{
                    		//隐藏上一关联作业
                    		 document.getElementById("update_isShow").style.display = "none";
                    		 //展示运行【频率 日期 时间】
                    		 document.getElementById("update_date_isShow").style.display = "block";
                			 var value= data.operating_frequency;
                	         if(value != '' &&  value != '1'){
                	        	document.getElementById("updateRunDateIsShow").style.display = "block";
                	         }else{
                	        	document.getElementById("updateRunDateIsShow").style.display = "none";
                	         }
                    	}
                    	
                    	$("#update_run_time").val(data.run_time);//运行时间
                    	var group = data.last_job_name;
						if (group != "" && typeof (group)!= "undefined") {
							$('#updateLastJobName').combobox('setValues',group.split(","));
                    	}
						$("#update_starting_work option[value='"+data.starting_work+"']").attr("selected","selected");//起始作业
						$("#update_operating_frequency option[value='"+data.operating_frequency+"']").attr("selected","selected");//运行频率
						$("#update_run_date option[value='"+data.run_date+"']").attr("selected","selected");//运行日期
						$("#relationUpdateDlg").modal('show');
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                })
        	}
        },
        /**
         * 删除子节点
         * 
         */
        deleteRelation:function(){
          	if(this.checkSingleData()) {
          		var id = ProcessJobRelation.seItem.id;
          		$.confirm({
                    title: '提示信息!',
                    content: '您确定要删除吗？',
                    type: 'blue',
                    typeAnimated: true,
                    buttons: {
                        确定: {
                            action: function(){
                            	$.ajax({
                  	                url:'workflow/deleteRelation',
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
                	                         $("#ProcessJobRelation-table").bootstrapTable('refresh');
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
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#ProcessJobRelation-table').bootstrapTable('getSelections');
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
            	ProcessJobRelation.seItem = selected[0];
                return true;
            }
        },
        //修改节点
        updateRelation:function(){
            if($("#updateRelationForm").data('bootstrapValidator').validate().isValid()){
        	$.ajax({
                url:'workflow/updateRelation',
                dataType:'json',
                type:'post',
                data:$("#updateRelationForm").serialize(),
                success:function(data){
                	 if(data){
                         $.alert({
                             title: '提示信息！',
                             content: '节点修改成功!',
                             type: 'blue'
                         });
                         $("#ProcessJobRelation-table").bootstrapTable('refresh');
                         ProcessJobRelation.closeRelationDlg();
                  		 document.getElementById("isShow").style.display = "none";
                     }else{
                         $.alert({
                             title: '提示信息！',
                             content: '节点修改失败！',
                             type: 'red'
                         });
                     }
                },
                error:function(){
                	 $.alert({
                         title: '提示信息！',
                         content: '节点添加失败！',
                         type: 'red'
                     });
                }
            });
            }
        },
        //新增流程 规则校验
        formValidator:function () {
            $("#addProcessConfigForm").bootstrapValidator({
                fields:{
                	processName:{
                        validators:{
                            notEmpty:{
                                message:"流程名称不能为空"
                            },
                            stringLength:{
                                max:30,
                                message:"字符长度不能超过30"
                            }
                        }
                    },
                    processSketch:{
                        validators:{
                            notEmpty:{
                                message:"流程简介不能为空"
                            }
                        }
                    },
                    processType:{
                        validators:{
                            notEmpty:{
                                message:"流程类型不能为空"
                            }
                        }
                    }
                }
            });
          //添加子节点 规则校验
            $("#addRelationForm").bootstrapValidator({
                fields:{
             	   jobBasicId:{
                        validators:{
                            notEmpty:{
                                message:"作业名称不能为空"
                            }
                        }
                    },
                    startingWork:{
                        validators:{
                            notEmpty:{
                                message:"起始作业不能为空"
                            }
                        }
                    },
                    operatingFrequency:{
                        validators:{
                            notEmpty:{
                                message:"运行频率不能为空"
                            }
                        }
                    }
                }
            });
            //修改子节点 规则校验
            $("#updateRelationForm").bootstrapValidator({
                fields:{
                    startingWork:{
                        validators:{
                            notEmpty:{
                                message:"起始作业不能为空"
                            }
                        }
                    },
                    operatingFrequency:{
                        validators:{
                            notEmpty:{
                                message:"运行频率不能为空"
                            }
                        }
                    }
                }
            });
       },
       //添加选择运行频率
       selectRunDate:function(){
    	   //清空下拉框内容
    	   $("#add_run_date").empty(); 
	       	var value= $("#add_operating_frequency").val();
	        if(value != '' &&  value != '1'){
	        	document.getElementById("runDateIsShow").style.display = "block";
	        }else{
	        	document.getElementById("runDateIsShow").style.display = "none";
	        }
	       checkOperatingFrequency(value,"add_run_date");
       },
       //修改选择运行频率
       updateSelectRunDate:function(){
    	   $("#update_run_date").empty();
	       	var value= $("#update_operating_frequency").val();
	        if(value != '' &&  value != '1'){
	        	//展示运行日期
	        	document.getElementById("updateRunDateIsShow").style.display = "block";
	        }else{
	        	document.getElementById("updateRunDateIsShow").style.display = "none";
	        }
	       checkOperatingFrequency(value,"update_run_date");
       }
    }
}();
/**
 * 添加加载上一关联作业
 * @param processId
 */
function loadCombobox(processId,jobBasicId){
            $('#lastJobName').combobox({  
            	url:"workflow/findLastJobByProcessId?processId="+processId+"&jobBasicId="+jobBasicId,
            	method:'post',  
                panelHeight:200,//设置为固定高度，combobox出现竖直滚动条  
                valueField:'id',
				textField:'job_name',  
                multiple:true
            });  
        }
/**
 * 修改加载上一关联作业
 * @param processId
 */
function updateLoadCombobox(processId,jobBasicId){
    $('#updateLastJobName').combobox({  
    	url:"workflow/findLastJobByProcessId?processId="+processId+"&jobBasicId="+jobBasicId,
        method:'post',  
        panelHeight:200,//设置为固定高度，combobox出现竖直滚动条  
        valueField:'id',
		textField:'job_name',  
        multiple:true,  
        onSelect: function (row) { //选中一个选项时调用  
         
        }
    });  
}
 function createAddProcessTab(menuId){
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
function checkOperatingFrequency(value,id){
	var dictType = "";
	if("2" == value){
 	   dictType = "JOB_RUN_DATE_WEEK" 
    }
    if("3" == value){
 	   dictType = "JOB_RUN_DATE_MONTH" 
    }
    if(dictType != ''){
 	    loadRunDate(dictType,id);
    }
}    
function loadRunDate(dictType,id){
	$.ajax({
        url:'systemDict/findDictNameByDictType',
        type:'post',
        async:false,
        data:{
        	"dictType":dictType
        	},
        success:function(data){
        	var h = "";  
            $.each(data, function(key, value) {
                h += "<option value='" + value.dict_code + "'>" + value.dict_name
                + "</option>";  
            });  
            $("#"+id).append(h);
            $("#"+id).on(  
	            "change"
	           )
        },
    });
}