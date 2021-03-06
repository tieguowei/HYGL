package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Member {
    private Integer memberId;

    private String memberNo;

    private String memberName;
    
    private String memberSex;

    private String memberPhone;
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date memberBirthday;

    private String memberPwd;

    private BigDecimal totalMoney;

    private BigDecimal residueMoney;

    private Integer aggregateScore;

    private Integer residueScore;

    private String memberStatus;
    
    //是否重置密码
    private String isResetPwd;
    //备注
    private String remark;
    //赠送金额
    private BigDecimal giveMoney;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private Integer operator;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    public Date getMemberBirthday() {
        return memberBirthday;
    }

    public BigDecimal getGiveMoney() {
		return giveMoney;
	}

	public void setGiveMoney(BigDecimal giveMoney) {
		this.giveMoney = giveMoney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMemberSex() {
		return memberSex;
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	public String getIsResetPwd() {
		return isResetPwd;
	}

	public void setIsResetPwd(String isResetPwd) {
		this.isResetPwd = isResetPwd;
	}

	public void setMemberBirthday(Date memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd == null ? null : memberPwd.trim();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getResidueMoney() {
        return residueMoney;
    }

    public void setResidueMoney(BigDecimal residueMoney) {
        this.residueMoney = residueMoney;
    }

    public Integer getAggregateScore() {
        return aggregateScore;
    }

    public void setAggregateScore(Integer aggregateScore) {
        this.aggregateScore = aggregateScore;
    }

    public Integer getResidueScore() {
        return residueScore;
    }

    public void setResidueScore(Integer residueScore) {
        this.residueScore = residueScore;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus == null ? null : memberStatus.trim();
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