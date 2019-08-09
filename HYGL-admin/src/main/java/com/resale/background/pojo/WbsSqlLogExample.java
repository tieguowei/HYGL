package com.resale.background.pojo;

import java.util.ArrayList;
import java.util.List;

public class WbsSqlLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WbsSqlLogExample() {
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

        public Criteria andDbIsNull() {
            addCriterion("db is null");
            return (Criteria) this;
        }

        public Criteria andDbIsNotNull() {
            addCriterion("db is not null");
            return (Criteria) this;
        }

        public Criteria andDbEqualTo(String value) {
            addCriterion("db =", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotEqualTo(String value) {
            addCriterion("db <>", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbGreaterThan(String value) {
            addCriterion("db >", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbGreaterThanOrEqualTo(String value) {
            addCriterion("db >=", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbLessThan(String value) {
            addCriterion("db <", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbLessThanOrEqualTo(String value) {
            addCriterion("db <=", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbLike(String value) {
            addCriterion("db like", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotLike(String value) {
            addCriterion("db not like", value, "db");
            return (Criteria) this;
        }

        public Criteria andDbIn(List<String> values) {
            addCriterion("db in", values, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotIn(List<String> values) {
            addCriterion("db not in", values, "db");
            return (Criteria) this;
        }

        public Criteria andDbBetween(String value1, String value2) {
            addCriterion("db between", value1, value2, "db");
            return (Criteria) this;
        }

        public Criteria andDbNotBetween(String value1, String value2) {
            addCriterion("db not between", value1, value2, "db");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNull() {
            addCriterion("user_ip is null");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNotNull() {
            addCriterion("user_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUserIpEqualTo(String value) {
            addCriterion("user_ip =", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotEqualTo(String value) {
            addCriterion("user_ip <>", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThan(String value) {
            addCriterion("user_ip >", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("user_ip >=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThan(String value) {
            addCriterion("user_ip <", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThanOrEqualTo(String value) {
            addCriterion("user_ip <=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLike(String value) {
            addCriterion("user_ip like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotLike(String value) {
            addCriterion("user_ip not like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpIn(List<String> values) {
            addCriterion("user_ip in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotIn(List<String> values) {
            addCriterion("user_ip not in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpBetween(String value1, String value2) {
            addCriterion("user_ip between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotBetween(String value1, String value2) {
            addCriterion("user_ip not between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andSqlTypeIsNull() {
            addCriterion("sql_type is null");
            return (Criteria) this;
        }

        public Criteria andSqlTypeIsNotNull() {
            addCriterion("sql_type is not null");
            return (Criteria) this;
        }

        public Criteria andSqlTypeEqualTo(String value) {
            addCriterion("sql_type =", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeNotEqualTo(String value) {
            addCriterion("sql_type <>", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeGreaterThan(String value) {
            addCriterion("sql_type >", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sql_type >=", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeLessThan(String value) {
            addCriterion("sql_type <", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeLessThanOrEqualTo(String value) {
            addCriterion("sql_type <=", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeLike(String value) {
            addCriterion("sql_type like", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeNotLike(String value) {
            addCriterion("sql_type not like", value, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeIn(List<String> values) {
            addCriterion("sql_type in", values, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeNotIn(List<String> values) {
            addCriterion("sql_type not in", values, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeBetween(String value1, String value2) {
            addCriterion("sql_type between", value1, value2, "sqlType");
            return (Criteria) this;
        }

        public Criteria andSqlTypeNotBetween(String value1, String value2) {
            addCriterion("sql_type not between", value1, value2, "sqlType");
            return (Criteria) this;
        }

        public Criteria andFailIsNull() {
            addCriterion("fail is null");
            return (Criteria) this;
        }

        public Criteria andFailIsNotNull() {
            addCriterion("fail is not null");
            return (Criteria) this;
        }

        public Criteria andFailEqualTo(String value) {
            addCriterion("fail =", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotEqualTo(String value) {
            addCriterion("fail <>", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailGreaterThan(String value) {
            addCriterion("fail >", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailGreaterThanOrEqualTo(String value) {
            addCriterion("fail >=", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLessThan(String value) {
            addCriterion("fail <", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLessThanOrEqualTo(String value) {
            addCriterion("fail <=", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLike(String value) {
            addCriterion("fail like", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotLike(String value) {
            addCriterion("fail not like", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailIn(List<String> values) {
            addCriterion("fail in", values, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotIn(List<String> values) {
            addCriterion("fail not in", values, "fail");
            return (Criteria) this;
        }

        public Criteria andFailBetween(String value1, String value2) {
            addCriterion("fail between", value1, value2, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotBetween(String value1, String value2) {
            addCriterion("fail not between", value1, value2, "fail");
            return (Criteria) this;
        }

        public Criteria andCheckRowsIsNull() {
            addCriterion("check_rows is null");
            return (Criteria) this;
        }

        public Criteria andCheckRowsIsNotNull() {
            addCriterion("check_rows is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRowsEqualTo(String value) {
            addCriterion("check_rows =", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsNotEqualTo(String value) {
            addCriterion("check_rows <>", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsGreaterThan(String value) {
            addCriterion("check_rows >", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsGreaterThanOrEqualTo(String value) {
            addCriterion("check_rows >=", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsLessThan(String value) {
            addCriterion("check_rows <", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsLessThanOrEqualTo(String value) {
            addCriterion("check_rows <=", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsLike(String value) {
            addCriterion("check_rows like", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsNotLike(String value) {
            addCriterion("check_rows not like", value, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsIn(List<String> values) {
            addCriterion("check_rows in", values, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsNotIn(List<String> values) {
            addCriterion("check_rows not in", values, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsBetween(String value1, String value2) {
            addCriterion("check_rows between", value1, value2, "checkRows");
            return (Criteria) this;
        }

        public Criteria andCheckRowsNotBetween(String value1, String value2) {
            addCriterion("check_rows not between", value1, value2, "checkRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsIsNull() {
            addCriterion("update_rows is null");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsIsNotNull() {
            addCriterion("update_rows is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsEqualTo(String value) {
            addCriterion("update_rows =", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsNotEqualTo(String value) {
            addCriterion("update_rows <>", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsGreaterThan(String value) {
            addCriterion("update_rows >", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsGreaterThanOrEqualTo(String value) {
            addCriterion("update_rows >=", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsLessThan(String value) {
            addCriterion("update_rows <", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsLessThanOrEqualTo(String value) {
            addCriterion("update_rows <=", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsLike(String value) {
            addCriterion("update_rows like", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsNotLike(String value) {
            addCriterion("update_rows not like", value, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsIn(List<String> values) {
            addCriterion("update_rows in", values, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsNotIn(List<String> values) {
            addCriterion("update_rows not in", values, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsBetween(String value1, String value2) {
            addCriterion("update_rows between", value1, value2, "updateRows");
            return (Criteria) this;
        }

        public Criteria andUpdateRowsNotBetween(String value1, String value2) {
            addCriterion("update_rows not between", value1, value2, "updateRows");
            return (Criteria) this;
        }

        public Criteria andLatencyIsNull() {
            addCriterion("latency is null");
            return (Criteria) this;
        }

        public Criteria andLatencyIsNotNull() {
            addCriterion("latency is not null");
            return (Criteria) this;
        }

        public Criteria andLatencyEqualTo(String value) {
            addCriterion("latency =", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotEqualTo(String value) {
            addCriterion("latency <>", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyGreaterThan(String value) {
            addCriterion("latency >", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyGreaterThanOrEqualTo(String value) {
            addCriterion("latency >=", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLessThan(String value) {
            addCriterion("latency <", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLessThanOrEqualTo(String value) {
            addCriterion("latency <=", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLike(String value) {
            addCriterion("latency like", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotLike(String value) {
            addCriterion("latency not like", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyIn(List<String> values) {
            addCriterion("latency in", values, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotIn(List<String> values) {
            addCriterion("latency not in", values, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyBetween(String value1, String value2) {
            addCriterion("latency between", value1, value2, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotBetween(String value1, String value2) {
            addCriterion("latency not between", value1, value2, "latency");
            return (Criteria) this;
        }

        public Criteria andTsIsNull() {
            addCriterion("ts is null");
            return (Criteria) this;
        }

        public Criteria andTsIsNotNull() {
            addCriterion("ts is not null");
            return (Criteria) this;
        }

        public Criteria andTsEqualTo(String value) {
            addCriterion("ts =", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotEqualTo(String value) {
            addCriterion("ts <>", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThan(String value) {
            addCriterion("ts >", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThanOrEqualTo(String value) {
            addCriterion("ts >=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThan(String value) {
            addCriterion("ts <", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThanOrEqualTo(String value) {
            addCriterion("ts <=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLike(String value) {
            addCriterion("ts like", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotLike(String value) {
            addCriterion("ts not like", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsIn(List<String> values) {
            addCriterion("ts in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotIn(List<String> values) {
            addCriterion("ts not in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsBetween(String value1, String value2) {
            addCriterion("ts between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotBetween(String value1, String value2) {
            addCriterion("ts not between", value1, value2, "ts");
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