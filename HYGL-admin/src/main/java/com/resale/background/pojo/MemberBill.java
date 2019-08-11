package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class MemberBill {
    private Integer billId;

    private Integer memberId;

    private String billType;

    private BigDecimal billMoney;

    private String billRemark;

    private Date createTime;

    private Date updateTime;
    
    private BigDecimal giveMoney;

    private Integer operator;

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public BigDecimal getBillMoney() {
        return billMoney;
    }

    public BigDecimal getGiveMoney() {
		return giveMoney;
	}

	public void setGiveMoney(BigDecimal giveMoney) {
		this.giveMoney = giveMoney;
	}

	public void setBillMoney(BigDecimal billMoney) {
        this.billMoney = billMoney;
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark == null ? null : billRemark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }
}