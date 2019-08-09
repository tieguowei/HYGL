package com.resale.background.pojo;

import java.util.Date;

public class WbsIndexLog {
    private Integer id;

    private String operatorname;

    private String operatorimg;

    private String navigationid;

    private String navigationname;

    private String deptcode;

    private Date createtime;

    private String content;

    private Integer createdby;

    private String resourceid;

    private String messageid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    public String getOperatorimg() {
        return operatorimg;
    }

    public void setOperatorimg(String operatorimg) {
        this.operatorimg = operatorimg == null ? null : operatorimg.trim();
    }

    public String getNavigationid() {
        return navigationid;
    }

    public void setNavigationid(String navigationid) {
        this.navigationid = navigationid == null ? null : navigationid.trim();
    }

    public String getNavigationname() {
        return navigationname;
    }

    public void setNavigationname(String navigationname) {
        this.navigationname = navigationname == null ? null : navigationname.trim();
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public String getResourceid() {
        return resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid == null ? null : messageid.trim();
    }
}