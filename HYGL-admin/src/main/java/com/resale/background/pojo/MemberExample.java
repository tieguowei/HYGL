package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNull() {
            addCriterion("member_no is null");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNotNull() {
            addCriterion("member_no is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNoEqualTo(String value) {
            addCriterion("member_no =", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotEqualTo(String value) {
            addCriterion("member_no <>", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThan(String value) {
            addCriterion("member_no >", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThanOrEqualTo(String value) {
            addCriterion("member_no >=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThan(String value) {
            addCriterion("member_no <", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThanOrEqualTo(String value) {
            addCriterion("member_no <=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLike(String value) {
            addCriterion("member_no like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotLike(String value) {
            addCriterion("member_no not like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoIn(List<String> values) {
            addCriterion("member_no in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotIn(List<String> values) {
            addCriterion("member_no not in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoBetween(String value1, String value2) {
            addCriterion("member_no between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotBetween(String value1, String value2) {
            addCriterion("member_no not between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIsNull() {
            addCriterion("member_phone is null");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIsNotNull() {
            addCriterion("member_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneEqualTo(String value) {
            addCriterion("member_phone =", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotEqualTo(String value) {
            addCriterion("member_phone <>", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneGreaterThan(String value) {
            addCriterion("member_phone >", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("member_phone >=", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLessThan(String value) {
            addCriterion("member_phone <", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLessThanOrEqualTo(String value) {
            addCriterion("member_phone <=", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLike(String value) {
            addCriterion("member_phone like", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotLike(String value) {
            addCriterion("member_phone not like", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIn(List<String> values) {
            addCriterion("member_phone in", values, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotIn(List<String> values) {
            addCriterion("member_phone not in", values, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneBetween(String value1, String value2) {
            addCriterion("member_phone between", value1, value2, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotBetween(String value1, String value2) {
            addCriterion("member_phone not between", value1, value2, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayIsNull() {
            addCriterion("member_birthday is null");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayIsNotNull() {
            addCriterion("member_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("member_birthday =", value, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("member_birthday <>", value, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("member_birthday >", value, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("member_birthday >=", value, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("member_birthday <", value, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("member_birthday <=", value, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("member_birthday in", values, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("member_birthday not in", values, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("member_birthday between", value1, value2, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("member_birthday not between", value1, value2, "memberBirthday");
            return (Criteria) this;
        }

        public Criteria andMemberPwdIsNull() {
            addCriterion("member_pwd is null");
            return (Criteria) this;
        }

        public Criteria andMemberPwdIsNotNull() {
            addCriterion("member_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPwdEqualTo(String value) {
            addCriterion("member_pwd =", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdNotEqualTo(String value) {
            addCriterion("member_pwd <>", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdGreaterThan(String value) {
            addCriterion("member_pwd >", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdGreaterThanOrEqualTo(String value) {
            addCriterion("member_pwd >=", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdLessThan(String value) {
            addCriterion("member_pwd <", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdLessThanOrEqualTo(String value) {
            addCriterion("member_pwd <=", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdLike(String value) {
            addCriterion("member_pwd like", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdNotLike(String value) {
            addCriterion("member_pwd not like", value, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdIn(List<String> values) {
            addCriterion("member_pwd in", values, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdNotIn(List<String> values) {
            addCriterion("member_pwd not in", values, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdBetween(String value1, String value2) {
            addCriterion("member_pwd between", value1, value2, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andMemberPwdNotBetween(String value1, String value2) {
            addCriterion("member_pwd not between", value1, value2, "memberPwd");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyIsNull() {
            addCriterion("residue_money is null");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyIsNotNull() {
            addCriterion("residue_money is not null");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyEqualTo(BigDecimal value) {
            addCriterion("residue_money =", value, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyNotEqualTo(BigDecimal value) {
            addCriterion("residue_money <>", value, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyGreaterThan(BigDecimal value) {
            addCriterion("residue_money >", value, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("residue_money >=", value, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyLessThan(BigDecimal value) {
            addCriterion("residue_money <", value, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("residue_money <=", value, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyIn(List<BigDecimal> values) {
            addCriterion("residue_money in", values, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyNotIn(List<BigDecimal> values) {
            addCriterion("residue_money not in", values, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("residue_money between", value1, value2, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andResidueMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("residue_money not between", value1, value2, "residueMoney");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreIsNull() {
            addCriterion("aggregate_score is null");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreIsNotNull() {
            addCriterion("aggregate_score is not null");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreEqualTo(Integer value) {
            addCriterion("aggregate_score =", value, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreNotEqualTo(Integer value) {
            addCriterion("aggregate_score <>", value, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreGreaterThan(Integer value) {
            addCriterion("aggregate_score >", value, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("aggregate_score >=", value, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreLessThan(Integer value) {
            addCriterion("aggregate_score <", value, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreLessThanOrEqualTo(Integer value) {
            addCriterion("aggregate_score <=", value, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreIn(List<Integer> values) {
            addCriterion("aggregate_score in", values, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreNotIn(List<Integer> values) {
            addCriterion("aggregate_score not in", values, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreBetween(Integer value1, Integer value2) {
            addCriterion("aggregate_score between", value1, value2, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andAggregateScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("aggregate_score not between", value1, value2, "aggregateScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreIsNull() {
            addCriterion("residue_score is null");
            return (Criteria) this;
        }

        public Criteria andResidueScoreIsNotNull() {
            addCriterion("residue_score is not null");
            return (Criteria) this;
        }

        public Criteria andResidueScoreEqualTo(Integer value) {
            addCriterion("residue_score =", value, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreNotEqualTo(Integer value) {
            addCriterion("residue_score <>", value, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreGreaterThan(Integer value) {
            addCriterion("residue_score >", value, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("residue_score >=", value, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreLessThan(Integer value) {
            addCriterion("residue_score <", value, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreLessThanOrEqualTo(Integer value) {
            addCriterion("residue_score <=", value, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreIn(List<Integer> values) {
            addCriterion("residue_score in", values, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreNotIn(List<Integer> values) {
            addCriterion("residue_score not in", values, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreBetween(Integer value1, Integer value2) {
            addCriterion("residue_score between", value1, value2, "residueScore");
            return (Criteria) this;
        }

        public Criteria andResidueScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("residue_score not between", value1, value2, "residueScore");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIsNull() {
            addCriterion("member_status is null");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIsNotNull() {
            addCriterion("member_status is not null");
            return (Criteria) this;
        }

        public Criteria andMemberStatusEqualTo(String value) {
            addCriterion("member_status =", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotEqualTo(String value) {
            addCriterion("member_status <>", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusGreaterThan(String value) {
            addCriterion("member_status >", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusGreaterThanOrEqualTo(String value) {
            addCriterion("member_status >=", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLessThan(String value) {
            addCriterion("member_status <", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLessThanOrEqualTo(String value) {
            addCriterion("member_status <=", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusLike(String value) {
            addCriterion("member_status like", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotLike(String value) {
            addCriterion("member_status not like", value, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusIn(List<String> values) {
            addCriterion("member_status in", values, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotIn(List<String> values) {
            addCriterion("member_status not in", values, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusBetween(String value1, String value2) {
            addCriterion("member_status between", value1, value2, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andMemberStatusNotBetween(String value1, String value2) {
            addCriterion("member_status not between", value1, value2, "memberStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(Integer value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(Integer value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(Integer value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(Integer value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(Integer value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<Integer> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<Integer> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(Integer value1, Integer value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(Integer value1, Integer value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}