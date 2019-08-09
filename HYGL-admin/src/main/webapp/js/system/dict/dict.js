//系统管理--字典管理的单例对象
var Dict = {
    seItem: null		//选中的条目
};
$(function(){
	Dict.formValidator();
    Dict.init();
    $('.close').click(function(){
    	Dict.closeDlg();
	 });
});

var Dict = function () {
    return{
        init:function(){
            $('#dict-table').bootstrapTable({
                url: "systemDict/getSysDictList",
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
                pageSize : 7, //默认每页条数
                pageNumber : 1, //默认分页
                pageList : [7, 10, 20, 50 ],//分页数
                toolbar:"#toolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Dict.queryParams,//传递参数（*）
                clickToSelect: true,
                columns : [{
                    checkbox: true
            	},{
                    field : "dict_id",
                    title : "字典编号",
                    class : 'col-md-1',
                    align : "center",
                    valign : "middle",
                    visible:false
                },{
                    field : "dict_type",
                    title : "字典类别",
                    align : "center",
                    class : 'col-md-2',
                    valign : "middle"
                }, {
                    field : "dict_type_name",
                    title : "字典类别名称",
                    class : 'col-md-4',
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "dict_name",
                    title : "字典名称",
                    class : 'col-md-4',
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "dict_code",
                    title : "字典编码",
                    align : "center",
                    class : 'col-md-2',
                    valign : "middle",
                    sortable : "true"
                }],
                formatLoadingMessage : function() {
                    //return "请稍等，正在加载中...";
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
            dictName: $("#search_dict_name").val(),
            dictType:$("#search_dict_type").val(),
            
        };
        return temp;
        },
        searchDict:function(){
        	 $("#dict-table").bootstrapTable('refresh');
        },
        empty:function(){
        	  $("#search_dict_type").val('');
              $("#search_dict_name").val('');
              $("#dict-table").bootstrapTable('refresh');
        },
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#dict-table').bootstrapTable('getSelections');
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
            	Dict.seItem = selected[0];
            	console.log(selected[0])
                return true;
            }
        },
        //打开添加模态框
        openAddModal:function () {
            $("#dictAddDlg").modal('show');
        },
        //添加
        addDict:function () {
        	document.getElementById("saveDictButton").setAttribute("disabled", true);
            if($("#addDictForm").data('bootstrapValidator').validate().isValid()){
            	flag = false;
    			//校验字典编码是否存在
    			var dictType = $("#dictType").val();
    			var dictCode = $("#dictCode").val();
    			$.ajax({
    				url:'systemDict/checkSysDict',
    				dataType:'json',
    				data:{"dictType":dictType,"dictCode":dictCode},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '字典编码已存在！',
    					        type: 'red'
    					    });
    					}else{
    						flag  = true;
    					}
    				}
    			})
    			if(flag){
	            	$.ajax({
	                    url:'systemDict/saveSysDict',
	                    dataType:'json',
	                    type:'post',
	                    data:$("#addDictForm").serialize(),
	                    success:function(data){
	                        if(data){
	                        	 $.alert({
	                                 title: '提示信息！',
	                                 content: '添加成功!',
	                                 type: 'blue'
	                             });
	                 		    document.getElementById("saveDictButton").removeAttribute("disabled");
	                            $("#dict-table").bootstrapTable("refresh");
	                            Dict.closeDlg();
	                        }else{
	                            $.alert({
	                                title: '提示信息！',
	                                content: '添加失败！',
	                                type: 'red'
	                            });
	                		    document.getElementById("saveDictButton").removeAttribute("disabled");
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
    		    document.getElementById("saveDictButton").removeAttribute("disabled");
            }
        },
        //打开修改模态框
        openUpdateModal:function () {
        	if(this.checkSingleData()) {
        		var id = Dict.seItem.dict_id;
        		$.ajax({
                    url:'systemDict/getDictById',
                    dataType:'json',
                    type:'post',
                    data:{dictId:id},
                    success:function(data){
                        $("#dict_update_id").val(id);
                        $("#dict_update_dictType").val(data.sysDict.dictType);
                        $("#dict_update_dictTypeName").val(data.sysDict.dictTypeName);
                        $("#dict_update_dictCode").val(data.sysDict.dictCode);
                        $("#dict_update_dictName").val(data.sysDict.dictName);
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                });
                $("#dictMydlg").modal('show');
        	}
        },
        //修改字典
        updateDict:function () {
            if($("#updateDictForm").data('bootstrapValidator').validate().isValid()){
            	flag = false;
    			//校验字典编码是否存在
    			var dictType = $("#dict_update_dictType").val();
    			var dictCode = $("#dict_update_dictCode").val();
    			var id = $("#dict_update_id").val();
    			$.ajax({
    				url:'systemDict/checkSysDict',
    				dataType:'json',
    				data:{"dictType":dictType,"dictCode":dictCode,"dictId":id},
    				type:'post',
    				async:false, //同步 验证后再执行
    				success:function(data){
    					if(!data){
    						flag = false;
    						$.alert({
    					        title: '提示信息！',
    					        content: '编码已存在！',
    					        type: 'red'
    					    });
    					}else{
    						flag = true;
    					}
    				}
    			})
    			if(flag){
	            	$.ajax({
	                    url:'systemDict/updateSysDict',
	                    dataType:'json',
	                    type:'post',
	                    data:$("#updateDictForm").serialize(),
	                    success:function(data){
	                        if(data){
	                            $.alert({
	                                title: '提示信息！',
	                                content: '修改成功!',
	                                type: 'blue'
	                            });
	                            $("#dict-table").bootstrapTable("refresh");
	                            Dict.closeDlg();
	                        }else{
	                            $.alert({
	                                title: '提示信息！',
	                                content: '修改失败！',
	                                type: 'red'
	                            });
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
        deleteDict:function () {
        	if(this.checkSingleData()) {
        		var id = Dict.seItem.dict_id;
        		$.confirm({
                    title: '提示信息!',
                    content: '您确定要删除这个字典吗？',
                    type: 'blue',
                    typeAnimated: true,
                    buttons: {
                        确定: {
                            action: function(){
                                $.ajax({
                                    url:'systemDict/deleteSysDict',
                                    dataType:'json',
                                    type:'post',
                                    data:{
                                    	dictId:id
                                    },
                                    success:function(data){
                                        if(data){
                                            $.alert({
                                                title: '提示信息！',
                                                content: '删除成功!',
                                                type: 'blue'
                                            });
                                        }else{
                                            $.alert({
                                                title: '提示信息！',
                                                content: '删除失败!',
                                                type: 'red'
                                            });
                                        }
                                        $("#dict-table").bootstrapTable('refresh');
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
        //关闭模态框
        closeDlg:function () {
            $("#dictAuthDlg").modal('hide');
            $("#dictAddDlg").modal('hide');
            $("#dictMydlg").modal('hide');
            $("input[type=reset]").trigger("click");
            $('#updateDictForm').data('bootstrapValidator', null);
            $('#addDictForm').data('bootstrapValidator', null);
		    document.getElementById("saveDictButton").removeAttribute("disabled");
            Dict.formValidator();
            
        },
        //表单验证
        formValidator:function () {
            $("#addDictForm").bootstrapValidator({
                fields:{
                    dictType:{
                        validators:{
                            notEmpty:{
                                message:"字典类型不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:'不能超过20个字符长度'
                            },
                        }
                    },
                    dictCode:{
                        validators:{
                            notEmpty:{
                                message:'字典编码不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过20'
                            }
                        }
                    },
                    dictName:{
                        validators:{
                            notEmpty:{
                                message:'字典名称不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过200'
                            }
                        }
                    }
                }
            });


            $("#updateDictForm").bootstrapValidator({
                fields:{
                	dictType:{
                        validators:{
                            notEmpty:{
                                message:"字典类型不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:'不能超过20个字符长度'
                            },
                        }
                    },
                    dictCode:{
                        validators:{
                            notEmpty:{
                                message:'字典编码不能为空',
                            },
                            stringLength:{
                                max:200,
                                message:'字符长度不能超过20'
                            }
                        }
                    },
                    dictName:{
                        validators:{
                            notEmpty:{
                                message:'字典名称不能为空',
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
    function getChildNodeIdArr(node) {
    	   var ts = [];
    	   if (node.nodes) {
    	    for (x in node.nodes) {
	    	     ts.push(node.nodes[x].nodeId);
	    	     if (node.nodes[x].nodes) {
	    	      var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
	    	      for (j in getNodeDieDai) {
	    	       ts.push(getNodeDieDai[j]);
	    	      }
    	     }
    	    }
    	   }else {
    		   ts.push(node.nodeId);
    	   }
    	   return ts;
    	  }
    	 
    	  function setParentNodeCheck(node) {
    	   var parentNode = $("#treeview-checkable").treeview("getNode", node.parentId);
    	   if (parentNode.nodes) {
    	    var checkedCount = 0;
	    	    for (x in parentNode.nodes) {
		    	     if (parentNode.nodes[x].state.checked) {
		    	      checkedCount ++;
		    	     } else {
		    	      break;
		    	     }
	    	    }
    	    if (checkedCount === parentNode.nodes.length) {
	    	     $("#treeview-checkable").treeview("checkNode", parentNode.nodeId);
	    	     setParentNodeCheck(parentNode);
    	    	}
    	   	}
    	  }
}();