//系统管理--字典管理的单例对象
var Job = {
    seItem: null		//选中的条目
};
$(function(){
	Job.formValidator();
    Job.init();
    $('.close').click(function(){
    	Job.closeDlg();
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
            $("#search_job_type").append(h);//append 添加进去并展示  
            $("#search_job_type").on(  
	            "change"
	           )
        },
    });
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
    		$("#update_search_job_type").append(h);//append 添加进去并展示  
    		$("#update_search_job_type").on(  
    				"change"
    		)
    	},
    });
});

var Job = function () {
    return{
        init:function(){
            $('#job-table').bootstrapTable({
                url: "jobBasic/getJobBasicList",
                method:"post",
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                striped:true,//隔行变色
                cache:false,  //是否使用缓存
                showColumns:false,// 列
                toobar:'#toolbar',
                pagination: true, //分页
                sortable: false, //是否启用排序
                singleSelect: false,
                search:false, //显示搜索框
                buttonsAlign: "right", //按钮对齐方式
                showRefresh:false,//是否显示刷新按钮
                sidePagination: "server", //服务端处理分页
                pageSize : 20, //默认每页条数
                pageNumber : 1, //默认分页
                pageList : [5, 10, 20, 50 ],//分页数
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Job.queryParams,//传递参数（*）
                columns : [{
                    checkbox: true
            	},{
					title: '序号',//标题  可不加
					width : '50',
					align : "center",
					valign : "middle",
		            switchable:false,
		            formatter:function(value,row,index){
		                var pageSize=$('#job-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
		                var pageNumber=$('#job-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
		            }
	             },{
                    field : "id",
                    title : "作业id",
                    class : 'col-md-1',
                    align : "center",
                    valign : "middle",
                    visible:false
                },{
                    field : "job_number",
                    title : "作业id",
                    align : "center",
                    valign : "middle"
                }, {
                    field : "job_name",
                    title : "作业名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "job_type",
                    title : "作业类型",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "job_sketch",
                    title : "作业简述",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "job_url",
                    title : "作业地址",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "operator_time",
                    title : "操作时间",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
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
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        //得到查询的参数
        queryParams:function (params) {
        var temp = {
            pageSize: params.pageSize,  //页面大小
            pageNumber: params.pageNumber, //页码
        };
        return temp;
        },
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#job-table').bootstrapTable('getSelections');
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
            	Job.seItem = selected[0];
            	console.log(selected[0])
                return true;
            }
        },
        //打开添加模态框
        openAddModal:function () {
            $("#jobAddDlg").modal('show');
        },
        //添加
        addJob:function () {
        	document.getElementById("saveJobButton").setAttribute("disabled", true);
            if($("#addJobForm").data('bootstrapValidator').validate().isValid()){
            	flag = false;
    			//校验字典编码是否存在
            	var jobType = $("#update_search_job_type option:selected").val();
    			var jobName = $("#jobName").val();
    			var jobUrl = $("#jobUrl").val();
    			$.ajax({
    				url:'jobBasic/checkJobBasic',
    				dataType:'json',
    				data:{"jobType":jobType,"jobName":jobName,"jobUrl":jobUrl},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '该作业信息已存在！',
    					        type: 'red'
    					    });
    					}else{
    						flag  = true;
    					}
    				}
    			})
    			if(flag){
	            	$.ajax({
	                    url:'jobBasic/saveJobBasic',
	                    dataType:'json',
	                    type:'post',
	                    data:$("#addJobForm").serialize(),
	                    success:function(data){
	                        if(data){
	                        	 $.alert({
	                                 title: '提示信息！',
	                                 content: '添加成功!',
	                                 type: 'blue'
	                             });
	                 		    document.getElementById("saveJobButton").removeAttribute("disabled");
	                            $("#job-table").bootstrapTable("refresh");
	                            Job.closeDlg();
	                        }else{
	                            $.alert({
	                                title: '提示信息！',
	                                content: '添加失败！',
	                                type: 'red'
	                            });
	                		    document.getElementById("saveJobButton").removeAttribute("disabled");
	                        }
	                    },
	                    error:function(){
	                        $.alert({
	                            title: '提示信息！',
	                            content: '请求失败！',
	                            type: 'red'
	                        });
	                    }
	                });
	            }
            }else{
    		    document.getElementById("saveJobButton").removeAttribute("disabled");
            }
        },
        importJobModel:function(){
        	 $("#jobImportDlg").modal('show');
        },
      //上传作业
       importJob:function() {
			var multipart = $("#fileName").val();
	      	if(multipart==""||multipart==null){
	      		alert("请先选择文件!");
	      		return ;
	      	}
	        $("#importJobForm").ajaxSubmit({
		       type : 'POST',
		       dataType:"json",
               url:'jobBasic/uploadJob',
               success:function(data){
            	   if(data ){
             			$.alert({
                             title: '提示信息！',
                             content: '上传成功',
                             type: 'blue'
                         });
             	}else{
             		$.alert({
                         title: '提示信息！',
                         content: '上传失败',
                         type: 'red'
                     });
             	}
               }
           });
      },
        //打开修改模态框
        openUpdateModal:function () {
        	if(this.checkSingleData()) {
        		var id = Job.seItem.id;
        		$.ajax({
                    url:'jobBasic/getJobBasicById',
                    dataType:'json',
                    type:'post',
                    data:{"id":id},
                    success:function(data){
                        $("#job_update_id").val(id);
                        $("#job_update_jobNumber").val(data.jobBasic.jobNumber);
                        $("#job_update_jobStatus").val(data.jobBasic.jobStatus);
                        $("#job_update_jobName").val(data.jobBasic.jobName);
                        $("#update_search_job_type option[value='"+data.jobBasic.jobType+"']").attr("selected","selected"); 
                        $("#job_update_jobSketch").val(data.jobBasic.jobSketch);
                        $("#job_update_jobUrl").val(data.jobBasic.jobUrl);
                        //$("#job_update_remark").val(data.jobBasic.remark);
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                });
                $("#jobUpdateMydlg").modal('show');
        	}
        },
        
        updateJob:function () {
            if($("#updateJobForm").data('bootstrapValidator').validate().isValid()){
            	flag = false;
    			//校验字典编码是否存在
    			var jobType = $("#update_search_job_type option:selected").val();
    			var jobName = $("#job_update_jobName ").val();
    			var jobUrl = $("#job_update_jobUrl").val();
    			var id = $("#job_update_id").val();
    			$.ajax({
    				url:'jobBasic/checkJobBasic',
    				dataType:'json',
    				data:{"jobType":jobType,"jobName":jobName,"jobUrl":jobUrl,"id":id},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '该作业已经已存在！',
    					        type: 'red'
    					    });
    					}else{
    						flag = true;
    					}
    				}
    			})
    			if(flag){
	            	$.ajax({
	                    url:'jobBasic/updateJobBasic',
	                    dataType:'json',
	                    type:'post',
	                    data:$("#updateJobForm").serialize(),
	                    success:function(data){
	                    	if(data.result){
                                $.alert({
                                    title: '提示信息！',
                                    content: '修改成功!',
                                    type: 'blue'
                                });
	                            $("#job-table").bootstrapTable("refresh");
	                            Job.closeDlg();
                            }else{
                            	if($.trim(data.message)!=''){
                            		$.alert({
                                        title: '提示信息！',
                                        content: data.message,
                                        type: 'red'
                                    });
                            	}else{
                                    $.alert({
                                        title: '提示信息！',
                                        content: '修改失败!',
                                        type: 'red'
                                    });
                            	}
                            }
	                    },
	                    error:function(){
	                        $.alert({
	                            title: '提示信息！',
	                            content: '请求失败！',
	                            type: 'red'
	                        });
	                    }
	                });
	            }
            }
        },
        deleteJob:function () {
        	if(this.checkSingleData()) {
        		var id = Job.seItem.id;
        		$.confirm({
                    title: '提示信息!',
                    content: '您确定要删除这个作业信息吗？',
                    type: 'blue',
                    typeAnimated: true,
                    buttons: {
                        确定: {
                            action: function(){
                                $.ajax({
                                    url:'jobBasic/deleteJobBasic',
                                    dataType:'json',
                                    type:'post',
                                    data:{
                                    	"id":id
                                    },
                                    success:function(data){
                                        if(data.result){
                                            $.alert({
                                                title: '提示信息！',
                                                content: '删除成功!',
                                                type: 'blue'
                                            });
                                            $("#job-table").bootstrapTable("refresh");
            	                            Job.closeDlg();
                                        }else{
                                        	if($.trim(data.message)!=''){
                                        		$.alert({
                                                    title: '提示信息！',
                                                    content: data.message,
                                                    type: 'red'
                                                });
                                        	}else{
	                                            $.alert({
	                                                title: '提示信息！',
	                                                content: '删除失败!',
	                                                type: 'red'
	                                            });
                                        	}
                                        }
                                        $("#job-table").bootstrapTable('refresh');
                                    },
                                    error:function(){
                                        $.alert({
                                            title: '提示信息！',
                                            content: '请求失败！',
                                            type: 'red'
                                        });
                                    }
                                });
                            }
                        },
                        取消: function () {
                        }
                    }
                });
        	}
            
        },
        //打开查看模态框
        openJobDetailModel:function () {
        	if(this.checkSingleData()) {
        		var id = Job.seItem.id;
        		$.ajax({
                    url:'jobBasic/getJobBasicById',
                    dataType:'json',
                    type:'post',
                    data:{"id":id},
                    success:function(data){
                        $("#job_detail_id").val(id);
                        $("#job_detail_jobNumber").val(data.jobBasic.jobNumber);
                        $("#job_detail_jobStatus").val(data.jobBasic.jobStatus);
                        $("#job_detail_jobName").val(data.jobBasic.jobName);
                        $("#detail_search_job_type option[value='"+data.jobBasic.jobType+"']").attr("selected","selected"); 
                        $("#job_detail_jobSketch").val(data.jobBasic.jobSketch);
                        $("#job_detail_jobUrl").val(data.jobBasic.jobUrl);
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                });
        		
        		  $('#job--log-table').bootstrapTable({
                      url: "processJobUpdateHistory/getHistoryList",
                      method:"post",
                      dataType: "json",
                      contentType: "application/x-www-form-urlencoded",
                      striped:true,//隔行变色
                      cache:false,  //是否使用缓存
                      showColumns:false,// 列
                      toobar:'#toolbar',
                      pagination: true, //分页
                      sortable: false, //是否启用排序
                      singleSelect: false,
                      search:false, //显示搜索框
                      buttonsAlign: "right", //按钮对齐方式
                      showRefresh:false,//是否显示刷新按钮
                      sidePagination: "server", //服务端处理分页
                      pageSize : 5, //默认每页条数
                      pageNumber : 1, //默认分页
                      pageList : [5, 10, 20, 50 ],//分页数
                      toolbar:"#toolbar",
                      showColumns : false, //显示隐藏列
                      uniqueId: "id", //每一行的唯一标识，一般为主键列
                      queryParamsType:'',
                      queryParams: Job.queryParams,//传递参数（*）
                      columns : [{
                          checkbox: true
                  	},{
      					title: '序号',//标题  可不加
      					width : '50',
      					align : "center",
      					valign : "middle",
      		            switchable:false,
      		            formatter:function(value,row,index){
      		                var pageSize=$('#job-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
      		                var pageNumber=$('#job-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
      		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
      		            }
      	             },{
                          field : "update_content",
                          title : "操作内容",
                          class : 'col-md-1',
                          align : "center",
                          valign : "middle"
                      },{
                          field : "operator",
                          title : "操作人",
                          align : "center",
                          valign : "middle"
                      }, {
                          field : "update_time",
                          title : "操作时间",
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
                $("#jobDetailMydlg").modal('show');
                
        	}
        },
        //关闭模态框
        closeDlg:function () {
            $("#jobAddDlg").modal('hide');
            $('#addJobForm').data('bootstrapValidator', null);
            $("#jobUpdateMydlg").modal('hide');
            $('#updateJobForm').data('bootstrapValidator', null);
            $("#jobImportDlg").modal('hide');
            $('#importJobForm').data('bootstrapValidator', null);
		    document.getElementById("saveJobButton").removeAttribute("disabled");
            Job.formValidator();
        },
        //表单验证
        formValidator:function () {
            $("#addJobForm").bootstrapValidator({
                fields:{
                    jobType:{
                        validators:{
                            notEmpty:{
                                message:"作业类型不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:'不能超过20个字符长度'
                            },
                        }
                    },
                    jobName:{
                        validators:{
                            notEmpty:{
                                message:'作业名称不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过20'
                            }
                        }
                    },
                    jobUrl:{
                        validators:{
                            notEmpty:{
                                message:'作业路径不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过200'
                            }
                        }
                    },
                    jobSketch:{
                        validators:{
                            notEmpty:{
                                message:'作业简述不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过200'
                            }
                        }
                    }
                }
            });


            $("#updateJobForm").bootstrapValidator({
                fields:{
                	jobType:{
                        validators:{
                            notEmpty:{
                                message:"作业类型不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:'不能超过20个字符长度'
                            },
                        }
                    },
                    jobName:{
                        validators:{
                            notEmpty:{
                                message:'作业名称不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过20'
                            }
                        }
                    },
                    jobUrl:{
                        validators:{
                            notEmpty:{
                                message:'作业地址不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过200'
                            }
                        }
                    },
                    jobSketch:{
                        validators:{
                            notEmpty:{
                                message:'作业简介不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过200'
                            }
                        }
                    },
                    remark:{
                        validators:{
                            notEmpty:{
                                message:'修改备注不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过200'
                            }
                        }
                    }
                }
            });
        }
    }
}();
