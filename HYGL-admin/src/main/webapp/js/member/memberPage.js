
/**
 * 会员管理
 */

var Member = {
    seItem: null		//选中的条目
};

$(function (){
    Member.formValidator();
    Member.init();
    $('.close').click(function(){
    	Member.closeDlg();
	 });
});
//表格数据展示
var Member = function (){
    return{
        init:function (){
            $('#member-table').bootstrapTable({
                url: "member/getMemberList",
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
                pageList : [ 5, 10, 20, 50],//分页数
                toolbar:"#memberToolbar",
                showColumns : false, //显示隐藏列
                uniqueId: "member_id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: Member.queryParams,//传递参数（*）
                clickToSelect: true,
                columns : [{
                    checkbox: true
                	},{
    					title: '序号',//标题  可不加
    					width : '40',
    					align : "center",
    					valign : "middle",
    		            switchable:false,
    		            formatter:function(value,row,index){
    		                var pageSize=$('#member-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
    		                var pageNumber=$('#member-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
    		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
    		            }
    	             },{
                        field : "member_no",
                        title : "卡号",
                        width:30,
                        align : "center",
                        valign : "middle",
                        sortable : "true"
                },{
                    field : "member_name",
                    title : "姓名",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "member_phone",
                    title : "手机号",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "member_birthday",
                    title : "生日",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "total_money",
                    title : "总金额",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "residue_money",
                    title : "余额",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "aggregate_score",
                    title : "总积分",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "residue_score",
                    title : "可用积分",
                    width:60,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "create_time",
                    title : "开卡时间",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "name",
                    title : "操作人",
                    align : "center",
                    valign : "middle",
                    width:40,
                    sortable : "true"
                },{
                    field: 'operate',
                    title: '操作',
                    width: '80px',
                    formatter: operateBasicFormatter
                },],
                onLoadSuccess: function(data){  
                	
                	 $.ajax({
                         url:'member/getMemberSumData',
                         dataType:'json',
                         type:'post',
                         success:function(map){
                             $("#today_num").html(map.today_num);
                             $("#today_money").html(map.today_money);
                             $("#month_money").html(map.month_money);
                             $("#month_num").html(map.month_num);
                             $("#today_xf").html(map.today_xf);
                             $("#month_xf").html(map.month_xf);
                         },
                         error:function(){
                             $.alert({
                                 title: '提示信息！',
                                 content: '请求失败！',
                                 type: 'red'
                             });
                         }
                     });
                },
            });
        },
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                memberPhone: $("#search_member_phone").val(),
                memberName:$("#search_member_name").val(),
            };
            return temp;
        },
        /**
         * 检查是否选中单条记录
         */
        checkSingleData:function () {
            var selected = $('#member-table').bootstrapTable('getSelections');
            if (selected.length == 0) {
            	 $.alert({
                     title: '提示信息！',
                     content: '请选择会员！',
                     type: 'red'
                 });
                return false;
            }else if (selected.length > 1){
            	 $.alert({
                     title: '提示信息！',
                     content: '该操作只能选择一位会员!',
                     type: 'blue'
                 });
            }else {
            	Member.seItem = selected[0];
                return true;
            }
        },
        //修改前，打开模态框
        openUpdateModal:function(){
        	if (this.checkSingleData()) {
        		var memberId = Member.seItem.member_id;
        		 $.ajax({
                     url:'member/getMemberById',
                     dataType:'json',
                     type:'post',
                     data:{
                     	memberId:memberId
                     },
                     success:function(data){
                         $("#update_member_id").val(data.member.memberId);
                         $("#update_member_name").val(data.member.memberName);
                         $("#update_member_phone").val(data.member.memberPhone);
                         $("#update_email").val(data.member.email);
                         $("#update_telephone").val(data.member.telephone);
                         $("#update_card_no").val(data.member.cardNo);
                         $("#update_entry_time").val(data.member.memberBirthday);
                         $("#update_total_money").val(data.member.totalMoney);
                         $("#update_residue_money").val(data.member.residueMoney);
                         $("#update_aggregate_score").val(data.member.aggregateScore);
                         $("#update_member_pwd").val(data.member.memberPwd);
                         $("#update_residue_score").val(data.member.residueScore);
                         if(data.member.memberSex==0){
                         	  document.getElementById("update_member_sex0").checked = true;
                         	}
                         	if(data.member.memberSex ==1){
                         	  document.getElementById("update_member_sex1").checked = true;
                         	}
                         $("#memberUpdateDlg").modal('show');
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
        //修改会员
        updateMember:function(){
            if($("#memberUpdateForm").data("bootstrapValidator").validate().isValid()){
                $.ajax({
                    url:'member/updateMember',
                    dataType:'json',
                    type:'post',
                    data:$("#memberUpdateForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '修改成功！',
                                type: 'blue'
                            });
                            Member.closeDlg();
                            $("#member-table").bootstrapTable('refresh');
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                    }
                });
            }
        },
        //删除
        deleteMember:function(){
        	if (this.checkSingleData()) {
        		var memberId = Member.seItem.member_id;
        		$.confirm({
                    title: '提示信息!',
                    content: '您确定要删除吗？',
                    type: 'red',
                    typeAnimated: true,
                    buttons: {
                        确定: {
                            action: function(){
                               $.ajax({
                                    url:'member/deleteMember',
                                    dataType:'json',
                                    type:'post',
                                    data:{
                                    	memberId:memberId
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
                                        $("#member-table").bootstrapTable('refresh');
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
        //添加会员，打开模态框
        openDlg:function(){
            $("#memberAddDlg").modal('show');
        },
        //添加会员
        saveMember:function(){
           if($("#addMemberForm").data('bootstrapValidator').validate().isValid()){
              $.ajax({
                    url:'member/saveMember',
                    type:'post',
                    dataType:'json',
                    data:$("#addMemberForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '添加成功!',
                                type: 'blue'
                            });
                            $("#member-table").bootstrapTable('refresh');
                            Member.closeDlg();
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '添加失败！',
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
        },
        //关闭模态框
        closeDlg:function () {
            $("#memberUpdateDlg").modal('hide');//修改dlg
            $("#memberAddDlg").modal('hide');//新增dlg
            $("#rechargeDlg").modal('hide');//充值dlg
            $("#consumeDlg").modal('hide');//消费dlg
            $("#deductDlg").modal('hide');//扣分dlg
            $("#billListDlg").modal('hide');//账单列表dlg
            $("#scoreListDlg").modal('hide');//积分列表dlg
            $("input[type=reset]").trigger("click");
            $(':input','#memberUpdateForm').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('checked');
            $(':input','#addMemberForm').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('checked');
            $(':input','#rechargeForm').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('checked');
            $(':input','#consumeForm').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('checked');
            $(':input','#deductForm').not(':button,:submit,:reset').val('').removeAttr('checked').removeAttr('checked');
            $("#member-table").bootstrapTable('refresh');
        },
        //充值，打开模态框
        openRecharge:function(){
        	if (this.checkSingleData()) {
        		$("#rechargeDlg").modal('show');
        		var member = Member.seItem;
        		$("#recharge_member_id").val(member.member_id);
        		$("#recharge_member_name").val(member.member_name);
        		$("#recharge_member_phone").val(member.member_phone);
        	}
        },
        //充值
        recharge:function(){
           if($("#rechargeForm").data('bootstrapValidator').validate().isValid()){
              $.ajax({
                    url:'member/recharge',
                    type:'post',
                    dataType:'json',
                    data:$("#rechargeForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '充值成功!',
                                type: 'blue'
                            });
                            $("#member-table").bootstrapTable('refresh');
                            Member.closeDlg();
                        }else{
                        	 $.alert({
                                 title: '提示信息！',
                                 content: '充值失败！',
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
        },
      //消费，打开模态框
        openConsume:function(){
        	if (this.checkSingleData()) {
        		$("#consumeDlg").modal('show');
        		var member = Member.seItem;
        		$("#consume_member_id").val(member.member_id);
        		$("#consume_member_name").val(member.member_name);
        		$("#consume_member_phone").val(member.member_phone);
        		$("#consume_residue_money").val(member.residue_money);
        	}
        },
        //页面校验余额是否足够
        checkResidueMoney:function(){
        	var write_money = $("#write_money").val();
        	var residue_money = $("#consume_residue_money").val();
        	if(parseInt(write_money) > parseInt(residue_money)){
        		 $.alert({
                     title: '提示信息！',
                     content: '余额不足！',
                     type: 'red'
                 });
        	}
        },
        //消费
        consume:function(){
           if($("#consumeForm").data('bootstrapValidator').validate().isValid()){
              $.ajax({
                    url:'member/consume',
                    type:'post',
                    dataType:'json',
                    data:$("#consumeForm").serialize(),
                    success:function(data){
                        if(data == '1'){
                            $.alert({
                                title: '提示信息！',
                                content: '消费成功!',
                                type: 'blue'
                            });
                            $("#member-table").bootstrapTable('refresh');
                            Member.closeDlg();
                        }else if(data == '2'){
                            $.alert({
                                title: '提示信息！',
                                content: '密码错误！',
                                type: 'red'
                            });
                        }else if(data == '3'){
                            $.alert({
                                title: '提示信息！',
                                content: '余额不足！',
                                type: 'red'
                            });
                        }else{
                        	 $.alert({
                                 title: '提示信息！',
                                 content: '消费失败！',
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
        },
        //扣减积分 打开模态框
        openDeduct:function(){
        	if (this.checkSingleData()) {
        		$("#deductDlg").modal('show');
        		var member = Member.seItem;
        		$("#deduct_member_id").val(member.member_id);
        		$("#deduct_member_name").val(member.member_name);
        		$("#deduct_member_phone").val(member.member_phone);
        		$("#deduct_residue_score").val(member.residue_score);
        	}
        },
        //页面校验积分是否足够
        checkResidueScore:function(){
        	var write_score = $("#write_score").val();
        	var residue_score = $("#deduct_residue_score").val();
        	if(parseInt(write_score) > parseInt(residue_score) ){
        		 $.alert({
                     title: '提示信息！',
                     content: '可用积分不足！',
                     type: 'red'
                 });
        	}
        },
        //扣减积分
        deduct:function(){
           if($("#deductForm").data('bootstrapValidator').validate().isValid()){
        	   $.ajax({
                    url:'member/deduct',
                    type:'post',
                    dataType:'json',
                    data:$("#deductForm").serialize(),
                    success:function(data){
                        if(data == '1'){
                            $.alert({
                                title: '提示信息！',
                                content: '扣减成功!',
                                type: 'blue'
                            });
                            $("#member-table").bootstrapTable('refresh');
                            Member.closeDlg();
                        }else if(data == '2'){
                            $.alert({
                                title: '提示信息！',
                                content: '积分不足！',
                                type: 'red'
                            });
                        }else{
                        	 $.alert({
                                 title: '提示信息！',
                                 content: '扣减失败！',
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
        },
	tableExport : function() {
			$('#member-table').tableExport(
					{
						type : 'excel',// 导出excel
						escape : 'false',
						ignoreColumn : [ 0 ], // 忽略某一列的索引
						fileName : '会员记录', // 文件名称设置
						worksheetName : 'sheet1', // 表格工作区名称
						tableName : '会员记录',
						excelstyles : [ 'background-color', 'color',
								'font-size', 'font-weight' ]
					})
		},
  
        formValidator:function () {
            $("#addMemberForm").bootstrapValidator({
                fields:{
                	memberName:{
                        validators:{
                            notEmpty:{
                                message:"会员姓名不能为空"
                            }
                        }
                    },
                    memberPhone:{
                        validators:{
                            notEmpty:{
                                message:"会员手机号不能为空"
                            }
                        }
                    }
                }
            });


            $("#memberUpdateForm").bootstrapValidator({
                fields:{
                	memberName:{
                        validators:{
                            notEmpty:{
                                message:"姓名不能为空！"
                            }
                        }
                    },
                    memberPhone:{
                        validators:{
                            notEmpty:{
                                message:"手机号不能为空"
                            }
                        }
                    }
                }
            });
            
            $("#rechargeForm").bootstrapValidator({
                fields:{
                	totalMoney:{
                        validators:{
                            notEmpty:{
                                message:"充值金额不能为空"
                            }
                        }
                    }
                }
            });
            
            $("#consumeForm").bootstrapValidator({
                fields:{
                	totalMoney:{
                        validators:{
                            notEmpty:{
                                message:"消费金额不能为空"
                            }
                        }
                    },
                    memberPwd:{
                        validators:{
                            notEmpty:{
                                message:"消费密码不能为空"
                            }
                        }
                    }
                }
            });
            $("#deductForm").bootstrapValidator({
                fields:{
                	aggregateScore:{
                        validators:{
                            notEmpty:{
                                message:"扣减积分不能为空"
                            }
                        }
                    }
                }
            });
            
        },
        //搜索
        searchMember:function () {
            $("#member-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#search_member_phone").val('');
            $("#search_member_name").val('');
            $("#member-table").bootstrapTable('refresh');
        }
    }
}();
function operateBasicFormatter(value, row, index) {
	var memberId = row.member_id;
	return [
	    	'<input style="background:#23c6c8;  height: 30px;width: 60px;color: white; line-height:20px" type="button"  value="账单" onclick="openBill('+memberId+')" />',
	    	'<input style="background:#23c6c8;  height: 30px;width: 70px;color: white; line-height:20px" type="button"  value="积分详情" onclick="openScoreDetail('+memberId+')"/>'
        ].join('');
};


function openBill(memberId){
	$("#hidden_member_id").val(memberId);
	$('#member-bill-table').bootstrapTable('destroy');
 	$('#member-bill-table').bootstrapTable({
        url: "member/getMemberBillList",
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
        pageList : [5, 10, 20, 50 ],//分页数
        toolbar:"#memberBillButton",
        showColumns : false, //显示隐藏列
        uniqueId: "bill_id", //每一行的唯一标识，一般为主键列
        queryParamsType:'',
        queryParams: queryMemberBillParams,//传递参数（*）
        columns : [
            {
			title: '序列',
			width : '50',
			align : "center",
			valign : "middle",
            switchable:false,
            formatter:function(value,row,index){
                var pageSize=$('#member-bill-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
                var pageNumber=$('#member-bill-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
            }
         },{
            field : "create_time",
            title : "日期",
            align : "center",
            valign : "middle"
        },{
            field : "bill_money",
            title : "金额",
            align : "center",
            valign : "middle",
            formatter: function (value, row, index) {
                var retStr = "";
                retStr= '<input id="'+index+'bill_money" style="width:80px;" type="number" step="1" min="0" value="'+row.bill_money+'"/>';
                return retStr;
            }
        },{
            field : "give_money",
            title : "赠送金额",
            align : "center",
            valign : "middle",
        },{
            field : "bill_type",
            title : "类型",
            align : "center",
            valign : "middle",
            sortable : "true"
        },{
            field : "bill_remark",
            title : "备注",
            align : "center",
            valign : "middle",
            sortable : "true"
        }]
    });
	$("#billListDlg").modal('show');
};
function queryMemberBillParams(params){
	 var temp = {
             pageSize: params.pageSize,  //页面大小
             pageNumber: params.pageNumber, //页码
             memberId: $("#hidden_member_id").val(),
         };
         return temp;
};
function updateMemberBill(){
	 var rows  = $('#member-bill-table').bootstrapTable('getData');
	 for(var index=0;index <rows.length;index++){
		 var row = rows[index];
		 var billMoney = $("#"+index+"bill_money").val();
		 row["bill_money"]= billMoney;
    }
	$('#member-bill-table').bootstrapTable('updateRow', {rows: rows})
	$.ajax({
	    type: "POST",
	    url: "member/updateMemberBill",
	    dataType: "json",
	    traditional: true,
	    data:{
	        rows: JSON.stringify(rows),
	    },
	    success: function (data) {
	    	 if(data){
	    		 $.alert({
                     title: '提示信息！',
                     content: '修改成功！',
                     type: 'blue'
                 });
	    	     $("#member-bill-table").bootstrapTable('refresh');
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
function openScoreDetail(memberId){
	$("#hidden_member_id").val(memberId);
	$('#member-score-table').bootstrapTable('destroy');
 	$('#member-score-table').bootstrapTable({
        url: "member/getMemberScoreList",
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
        pageList : [5, 10, 20, 50 ],//分页数
        toolbar:"#memberScoreButton",
        showColumns : false, //显示隐藏列
        uniqueId: "bill_id", //每一行的唯一标识，一般为主键列
        queryParamsType:'',
        queryParams: queryMemberBillParams,//传递参数（*）
        columns : [
            {
			title: '序列',
			width : '50',
			align : "center",
			valign : "middle",
            switchable:false,
            formatter:function(value,row,index){
                var pageSize=$('#member-score-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
                var pageNumber=$('#member-score-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
            }
         },{
            field : "create_time",
            title : "日期",
            align : "center",
            valign : "middle"
        },{
            field : "score",
            title : "积分",
            align : "center",
            valign : "middle",
            formatter: function (value, row, index) {
                var retStr = "";
                retStr= '<input id="'+index+'score" style="width:80px;" type="number" step="1" min="0" value="'+row.score+'"/>';
                return retStr;
            }
        },{
            field : "score_type",
            title : "类型",
            align : "center",
            valign : "middle",
            sortable : "true"
        },{
            field : "score_remark",
            title : "备注",
            align : "center",
            valign : "middle",
            sortable : "true"
        }]
    });
	$("#scoreListDlg").modal('show');
};
function queryMemberBillParams(params){
	 var temp = {
             pageSize: params.pageSize,  //页面大小
             pageNumber: params.pageNumber, //页码
             memberId: $("#hidden_member_id").val(),
         };
         return temp;
};
function updateMemberScore(){
	 var rows  = $('#member-score-table').bootstrapTable('getData');
	 for(var index=0;index <rows.length;index++){
		 var row = rows[index];
		 var billMoney = $("#"+index+"score").val();
		 row["score"]= billMoney;
    }
	$('#member-score-table').bootstrapTable('updateRow', {rows: rows})
	$.ajax({
	    type: "POST",
	    url: "member/updateMemberScore",
	    dataType: "json",
	    traditional: true,
	    data:{
	        rows: JSON.stringify(rows),
	    },
	    success: function (data) {
	    	 if(data){
	    		 $.alert({
                     title: '提示信息！',
                     content: '修改成功！',
                     type: 'blue'
                 });
	    	     $("#member-score-table").bootstrapTable('refresh');
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
};
