package com.resale.background.pojo;

import java.util.Date;

public class ProcessJobRelation {
    private Integer id;

    private Integer processId;

    private Integer jobBasicId;

    private String level;

    private String operatingFrequency;

    private String runDate;

    private String runTime;

    private String startingWork;

    private String lastJobName;

    private Date createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getOperatingFrequency() {
        return operatingFrequency;
    }

    public void setOperatingFrequency(String operatingFrequency) {
        this.operatingFrequency = operatingFrequency == null ? null : operatingFrequency.trim();
    }

    public String getRunDate() {
        return runDate;
    }

    public void setRunDate(String runDate) {
        this.runDate = runDate == null ? null : runDate.trim();
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime == null ? null : runTime.trim();
    }

    public String getStartingWork() {
        return startingWork;
    }

    public void setStartingWork(String startingWork) {
        this.startingWork = startingWork == null ? null : startingWork.trim();
    }

    public String getLastJobName() {
        return lastJobName;
    }

    public void setLastJobName(String lastJobName) {
        this.lastJobName = lastJobName == null ? null : lastJobName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}