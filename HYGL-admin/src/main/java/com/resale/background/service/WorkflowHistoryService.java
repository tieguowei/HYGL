package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.JobHistory;
import com.resale.background.util.PageModel;

public interface WorkflowHistoryService {

	/**
	 * 查询流程运行历史列表
	 * @param paramsCondition
	 * @return
	 */
	PageModel getProcessHistoryList(Map<String, Object> paramsCondition);
	/**
	 * 查询流程下面的作业运行历史列表
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	PageModel getJobHistoryList(Map<String, Object> paramsCondition);
	/**
	 * 查询作业错误及操作日志列表
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	PageModel getJobErrorOrLogList(Map<String, Object> paramsCondition);
	/**
	 * 查看作业历史详情
	 * @param id
	 * @return
	 */
	JobHistory findJobDetail(String id);
	/**
	 * 根据条件查询数据
	 * @param paramsCondition
	 * @return
	 */
	List<Map<String, Object>> getLastJobHistoryList(Map<String, Object> paramsCondition);
	/**
	 * 修改job运行状态
	 * @param id
	 */
	void updateJobRunStatus(String id);


}
