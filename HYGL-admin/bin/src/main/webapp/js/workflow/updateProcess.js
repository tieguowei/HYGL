
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
	ProcessJobRelation.formValidator();
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
                    sortable : "true"
                }, {
                    field : "job_sketch",
                    title : "作业简述",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "starting_work",
                    title : "起止作业",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "jobNames",
                    title : "关联上一作业名",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "operating_frequency",
                    title : "运行频率",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "run_date",
                    title : "运行日期",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "run_time",
                    title : "运行时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
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
                    sortable : "true"
                }, {
                    field : "update_content",
                    title : "修改内容",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "operator",
                    title : "操作人",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
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
        //修改流程信息
        updateProcess:function(menuId){
            if($("#updateProcessConfigForm").data('bootstrapValidator').validate().isValid()){
            	var remark = $("#update_content").val();
            	$("#remark").val(remark);
            	var content = $("#update_content").val();
            	if (content != "" && content!= "undefined") {
            		$.ajax({
    	                url:'workflow/updateProcess',
    	                dataType:'json',
    	                type:'post',
    	                data:$("#updateProcessConfigForm").serialize(),
    	                success:function(data){
    	                	if(data){
    	                		closeTab(888);
    	                	}
    	                },
    	                error:function(){
    	                    $.alert({
    	                        title: '提示信息！',
    	                        content: '修改失败!',
    	                        type: 'red'
    	                    });
    	                }
    	            });
            	}else{
            		 $.alert({
	                        title: '提示信息！',
	                        content: '修改内容不能为空!',
	                        type: 'red'
	                    });
            	}
	        	
            }
        },
        //打开添加节点model
        openRelationAddDlg:function(){
        	$("#relationAddDlg").modal('show');
        	var processId = $("#global_process_id").val();
        	if (processId != "" && processId != null) {
        		loadCombobox(processId,'');
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
          	        	$("#job_sketch").val('');
          	        	$("#job_sketch").val(data.jobSketch);
          	        	//再次初始化 上一关联作业
          	        	var jobBasicId = $("#add_job_name").val();
          	        	var processId = $("#global_process_id").val();
          	        	loadCombobox(processId,jobBasicId);
          	        },	
          	    });
          	
          },
          //添加 --》 点击简述 弹框显示内容
          tips:function(){
          	var jobSketch =  $("#job_sketch").val();
          	if('' != jobSketch){
          		alert(jobSketch);
          	}
          },
          //修改--》 点击简述 弹框显示内容
          updateTips:function(){
          	var jobSketch =  $("#update_job_sketch").val();
          	if('' != jobSketch){
          		alert(jobSketch);
          	}
          },
         //添加 --》 初始起止作业：展示上一关联作业
          selectStartWorking:function(){
          	var status = $("#add_starting_work").val();
          	if("1" == status || "2" == status){
          		document.getElementById("isShow").style.display = "block";
          	}
          	if("0" == status){
          		document.getElementById("isShow").style.display = "none";
          	}
          },
        // 修改 --》 初始起止作业：展示上一关联作业
          updateSelectStartWorking:function(){
          	var status = $("#update_starting_work").val();
          	if("1" == status || "2" == status){
          		 var processId = $("#global_process_id").val();
          		 var jobBasicId = $("#update_job_basic_id").val();
          		 updateLoadCombobox(processId,jobBasicId);
          		document.getElementById("update_isShow").style.display = "block";
          	}
          	if("0" == status){
          		document.getElementById("update_isShow").style.display = "none";
          	}
          },
          //关闭节点的dialog
          closeRelationDlg:function(){
            $("#ProcessJobRelation-table").bootstrapTable('refresh');
      	   $("#relationAddDlg").modal('hide');
      	   $("#relationUpdateDlg").modal('hide');
            $("input[type=reset]").trigger("click");
            $('#addRelationForm').data('bootstrapValidator', null);
            $('#updateRelationForm').data('bootstrapValidator', null);
    		 document.getElementById("isShow").style.display = "none";
    		ProcessJobRelation.formValidator();
          },
          //保存节点
          saveRelation:function(){
            if($("#addRelationForm").data('bootstrapValidator').validate().isValid()){
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
              }
          },
          //取消修改
          cancelUpdateProcess:function(menuId){
        	 closeTab(888);
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
                      	//清除select 选中状态
                      	$("#update_starting_work").find("option:selected").attr("selected", false);
                      	$("#update_operating_frequency").find("option:selected").attr("selected", false);

                      	
                      	$("#update_job_name").val(data.job_name);//作业名称
                      	$("#update_job_sketch").val(data.job_sketch);//作业简述
                      	if("0" != data.starting_work){
                       		 document.getElementById("update_isShow").style.display = "block";
                       		 var processId = $("#global_process_id").val();
                       		 updateLoadCombobox(processId,data.job_basic_id);
                      	}else{
                      		 document.getElementById("update_isShow").style.display = "none";
                      	}
                      	$("#update_run_time").val(data.run_date);//运行时间
                      	var group = data.last_job_name;
  						if (group != "" && typeof (group)!= "undefined") {
  							$('#updateLastJobName').combobox('setValues',group.split(","));
                      	}
  						$("#update_starting_work option[value='"+data.starting_work+"']").attr("selected","selected");//起始作业
  						$("#update_operating_frequency option[value='"+data.operating_frequency+"']").attr("selected","selected");//运行频率
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
          /**
           * 规则校验
           */
          //修改流程 规则校验
          formValidator:function () {
              $("#updateProcessConfigForm").bootstrapValidator({
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
                      remark:{
                          validators:{
                              notEmpty:{
                                  message:"流程简介不能为空"
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
                valueField:'level',
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
function closeTab (id) {
		//如果关闭的是当前激活的TAB，激活他的前一个TAB
		 if ($("li.active").attr('id') =="tab_"+ id) {
		 $("#tab_"+ id).prev().addClass('active').addClass("in");;
		 $("#content"+ id).prev().addClass('active').addClass("in");;
		}
		//关闭TAB
		 $("#tab_"+ id).remove();
		 $("#content"+ id).remove();
 		 createUpdateProcessTab(menuId);
	};
 function createUpdateProcessTab(menuId){
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

