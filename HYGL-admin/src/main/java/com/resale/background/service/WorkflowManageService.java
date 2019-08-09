package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Employee;
import com.resale.background.pojo.JobBasic;
import com.resale.background.pojo.JobHistory;
import com.resale.background.pojo.ProcessConfig;
import com.resale.background.pojo.ProcessJobRelation;
import com.resale.background.util.PageModel;

public interface WorkflowManageService {
	/**
	 * 查询流程配置列表
	 * @param paramsCondition
	 * @return
	 */
	PageModel getWorkflowList(Map<String, Object> paramsCondition);

	/**
	 * 查询节点列表
	 * @return
	 */
	PageModel getJobBasicList(Map<String, Object> paramsCondition);
	/**
	 * 
	 * @param 查询t_job_basic中的作业
	 */
	List<Map<String, Object>> findJobBasicList();

	/**
	 * 通过id 查询jobBasic
	 * @param id
	 * @return
	 */
	JobBasic findJobBasicById(Integer id);

	/**
	 * 添加流程信息
	 * @param processConfig
	 * @param employee
	 * @return 
	 */
	int saveProcessConfig(ProcessConfig processConfig);

	/**
	 * 绑定流程作业关系
	 * @param relation
	 * @return 
	 */
	int saveRelation(ProcessJobRelation relation);

	/**
	 * 删除流程和依赖关系
	 * @param relation
	 */
	void deleteProcessAndRelation(ProcessJobRelation relation);

	Map<String, Object> selectProcessByNameAndType(ProcessConfig processConfig);

	/**
	 * 查询上一作业
	 * @return
	 */
	List<Map<String, Object>> findLastJobByProcessId(Map<String, Object> map);

	/**
	 * 通过id 查询中间表
	 * @param id
	 * @return
	 */
	Map<String, Object> findRelationById(Integer id);

	/**
	 * 修改流程节点信息
	 * @param relation
	 * @return
	 */
	int updateRelation(ProcessJobRelation relation);


	/**
	 * 删除子节点
	 * @param relation
	 */
	void deleteRelation(ProcessJobRelation relation);

	ProcessConfig findProcessById(Integer valueOf);

	/**
	 * 查询流程下面的修改信息列表
	 * @param paramsCondition
	 * @return
	 */
	PageModel updateProcessHistoryList(Map<String, Object> paramsCondition);

	/**
	 * 修改流程信息
	 * @param processConfig
	 * @return 
	 */
	void updateProcess(ProcessConfig processConfig);

	/**
	 * 删除流程
	 * @param relation
	 * @return
	 */

	void deleteProcess(ProcessConfig processConfig);


	List<Map<String,Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	/**
	 * 取消修改 ：删除新加的子节点
	 * @param map
	 */
	void deleteJobRelation(Map<String, Object> map);

	/**
	 * 校验启动/停止条件
	 * @param processId
	 * @return
	 */
	String checkStartRunStatus(String processId);

	/**
	 * 校验流程删除条件
	 * @param processId
	 * @return
	 */
	boolean checkProcessRunStatus(String processId);

	/**
	 * 通过作业id和流程id查询作业级别
	 * @param map
	 * @return
	 */
	String findNextLevel(Map<String, Object> map);
	/**
	 * 校验流程下的job是否能删除
	 */
	boolean checkDeleteJob(String id);

	JobHistory findJobHistoryById(String id);

	List<Map<String, Object>> findJobHistoryListByProcessId(String processId, String version);

	/**
	 * 根据条件查询list
	 * @param paramsCondition
	 * @return
	 */
	List<Map<String,Object>> findByParams(Map<String, Object> paramsCondition);
	/**
	 * 修改流程运行状态
	 * @param processId
	 */
	void updateRrocessRunStatus(String processId);
}
