package com.resale.background.pojo;

public class WbsSqlLog {
    private String db;

    private String tid;

    private String user;

    private String userIp;

    private String sqlType;

    private String fail;

    private String checkRows;

    private String updateRows;

    private String latency;

    private String ts;

    private String log;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType == null ? null : sqlType.trim();
    }

    public String getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail = fail == null ? null : fail.trim();
    }

    public String getCheckRows() {
        return checkRows;
    }

    public void setCheckRows(String checkRows) {
        this.checkRows = checkRows == null ? null : checkRows.trim();
    }

    public String getUpdateRows() {
        return updateRows;
    }

    public void setUpdateRows(String updateRows) {
        this.updateRows = updateRows == null ? null : updateRows.trim();
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency == null ? null : latency.trim();
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log == null ? null : log.trim();
    }
}