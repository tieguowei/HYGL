package com.resale.background.constants;

import java.io.File;

public class Constants {

	public static final String CHECK_CODE ="check_code";//验证码key值
	
	public static final String MD5KEY="BBGL*)(bxdxa?a^%#)";
	
	//文件上传文件夹
	public static final String UPLOAD=File.separator+"upload";

	/*******************流程状态-与字典一致********************/
	//1:未运行  2：运行中 3：运行完成  4：中断
	public static final String PROCESS_RUN_STATUS_1 = "1";
	public static final String PROCESS_RUN_STATUS_2 = "2";
	public static final String PROCESS_RUN_STATUS_3 = "3";
	public static final String PROCESS_RUN_STATUS_4 = "4";
	
	//执行描述
	public static final String ERROR_PROCESS_RUN_STATUS_4_DESC = "job运行中断";
	
	//joblog 日志
	public static final String LOG_JOB_MUST_PARAM_NULL = "执行失败-作业运行缺少必要参数";
	public static final String LOG_ERROR_JOB_PARENT_FILES_FAIL = "执行失败-父级job缺失或者执行失败";
	public static final String LOG_ERROR_JOB_STOP= "执行失败-线程被中断停止运行";
	public static final String LOG_JOB_FILE_KJB_FAILE = "执行失败-kjb文件执行失败";
	public static final String SUCCESS_EXECT_JOB = "执行成功";
	
	
	//流程作业关联表中 0：起点 1：终点 2:普通节点
	public static final String STARTING_WORK_0="0";
	public static final String STARTING_WORK_1="1";
	public static final String STARTING_WORK_2="2";
	
	
	//执行job文件成功标志
	public static  final String EXECT_JOB_SUCCESS ="SUCCESS";
	//默认的失败之后，尝试的次数
	public static  final String EXECT_JOB_MAX_COUNT ="3";
	
	//job log 类型（0：启动 1：错误 2：成功
	public static final String JOB_LOG_TYPE_START_0 ="0";
	public static final String JOB_LOG_TYPE_ERROR_1 ="1";
	public static final String JOB_LOG_TYPE_OPERATE_2 ="2";

	//1:job启动标志 2:流程启动标志
	public static final String START_JOB_FLAG="job";
	public static final String START_PROCESS_FLAG="process";

	public static final String  JOB_STOP_THREAD="线程被中断-job-run-停止执行";
	
	public static final String THREADSUFFIX="BBGL";

}
