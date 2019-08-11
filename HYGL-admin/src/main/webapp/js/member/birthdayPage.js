/**
 * 生日提醒
 */
var MemberBirthday = {
    seItem: null		//选中的条目
};

$(function (){
	MemberBirthday.init();
});
//表格数据展示
var MemberBirthday = function (){
    return{
        init:function (){
            $('#member-birthday-table').bootstrapTable({
                url: "member/getBirthdayList",
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
                showColumns : false, //显示隐藏列
                uniqueId: "member_id", //每一行的唯一标识，一般为主键列
                queryParamsType:'',
                queryParams: MemberBirthday.queryBirthParams,//传递参数（*）
                clickToSelect: true,
                columns : [{
    					title: '序号',//标题  可不加
    					width : '40',
    					align : "center",
    					valign : "middle",
    		            switchable:false,
    		            formatter:function(value,row,index){
    		                var pageSize=$('#member-birthday-table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
    		                var pageNumber=$('#member-birthday-table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
    		                return pageSize * (pageNumber - 1) + index + 1;    //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
    		            }
    	       },{
                    field : "member_name",
                    title : "会员姓名",
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
                },{
                    field : "member_birthday",
                    title : "会员出生日期",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "next_birthday",
                    title : "下次生日时间",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "sub_day",
                    title : "距离生日（天）",
                    width:50,
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }],
               
            });
        },
        queryBirthParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                param: $("#set_day_param").val(),
            };
            return temp;
        },
        //设置生日提醒天数
        setDayParam:function(){
            $("#member-birthday-table").bootstrapTable('refresh');

        }
    }
}();