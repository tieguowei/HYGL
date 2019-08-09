package com.resale.background.pojo;

import java.util.Date;

public class JobHistory {
    private Integer id;

    private String jobNumber;

    private String jobType;

    private String jobName;

    private String jobSketch;

    private String jobUrl;

    private Integer processId;

    private Integer jobBasicId;

    private String runStatus;

    private String version;

    private String lastJobName;

    private String errorInfo;

    private Date startRunTime;

    private Date endRunTime;

    private Date createTime;
    
    private String level;
    
    private String startingWork;
    
    
    

    public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStartingWork() {
		return startingWork;
	}

	public void setStartingWork(String startingWork) {
		this.startingWork = startingWork;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobSketch() {
        return jobSketch;
    }

    public void setJobSketch(String jobSketch) {
        this.jobSketch = jobSketch == null ? null : jobSketch.trim();
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl == null ? null : jobUrl.trim();
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Integer getJobBasicId() {
        return jobBasicId;
    }

    public void setJobBasicId(Integer jobBasicId) {
        this.jobBasicId = jobBasicId;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getLastJobName() {
        return lastJobName;
    }

    public void setLastJobName(String lastJobName) {
        this.lastJobName = lastJobName == null ? null : lastJobName.trim();
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }

    public Date getStartRunTime() {
        return startRunTime;
    }

    public void setStartRunTime(Date startRunTime) {
        this.startRunTime = startRunTime;
    }

    public Date getEndRunTime() {
        return endRunTime;
    }

    public void setEndRunTime(Date endRunTime) {
        this.endRunTime = endRunTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}