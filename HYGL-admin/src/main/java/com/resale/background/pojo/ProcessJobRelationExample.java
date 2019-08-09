package com.resale.background.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessJobRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessJobRelationExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(Integer value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Integer value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Integer value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Integer value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Integer value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Integer> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Integer> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Integer value1, Integer value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdIsNull() {
            addCriterion("job_basic_id is null");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdIsNotNull() {
            addCriterion("job_basic_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdEqualTo(Integer value) {
            addCriterion("job_basic_id =", value, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdNotEqualTo(Integer value) {
            addCriterion("job_basic_id <>", value, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdGreaterThan(Integer value) {
            addCriterion("job_basic_id >", value, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_basic_id >=", value, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdLessThan(Integer value) {
            addCriterion("job_basic_id <", value, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_basic_id <=", value, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdIn(List<Integer> values) {
            addCriterion("job_basic_id in", values, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdNotIn(List<Integer> values) {
            addCriterion("job_basic_id not in", values, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdBetween(Integer value1, Integer value2) {
            addCriterion("job_basic_id between", value1, value2, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andJobBasicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_basic_id not between", value1, value2, "jobBasicId");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyIsNull() {
            addCriterion("operating_frequency is null");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyIsNotNull() {
            addCriterion("operating_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyEqualTo(String value) {
            addCriterion("operating_frequency =", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyNotEqualTo(String value) {
            addCriterion("operating_frequency <>", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyGreaterThan(String value) {
            addCriterion("operating_frequency >", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("operating_frequency >=", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyLessThan(String value) {
            addCriterion("operating_frequency <", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyLessThanOrEqualTo(String value) {
            addCriterion("operating_frequency <=", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyLike(String value) {
            addCriterion("operating_frequency like", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyNotLike(String value) {
            addCriterion("operating_frequency not like", value, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyIn(List<String> values) {
            addCriterion("operating_frequency in", values, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyNotIn(List<String> values) {
            addCriterion("operating_frequency not in", values, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyBetween(String value1, String value2) {
            addCriterion("operating_frequency between", value1, value2, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andOperatingFrequencyNotBetween(String value1, String value2) {
            addCriterion("operating_frequency not between", value1, value2, "operatingFrequency");
            return (Criteria) this;
        }

        public Criteria andRunDateIsNull() {
            addCriterion("run_date is null");
            return (Criteria) this;
        }

        public Criteria andRunDateIsNotNull() {
            addCriterion("run_date is not null");
            return (Criteria) this;
        }

        public Criteria andRunDateEqualTo(Date value) {
            addCriterion("run_date =", value, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateNotEqualTo(Date value) {
            addCriterion("run_date <>", value, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateGreaterThan(Date value) {
            addCriterion("run_date >", value, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateGreaterThanOrEqualTo(Date value) {
            addCriterion("run_date >=", value, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateLessThan(Date value) {
            addCriterion("run_date <", value, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateLessThanOrEqualTo(Date value) {
            addCriterion("run_date <=", value, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateIn(List<Date> values) {
            addCriterion("run_date in", values, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateNotIn(List<Date> values) {
            addCriterion("run_date not in", values, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateBetween(Date value1, Date value2) {
            addCriterion("run_date between", value1, value2, "runDate");
            return (Criteria) this;
        }

        public Criteria andRunDateNotBetween(Date value1, Date value2) {
            addCriterion("run_date not between", value1, value2, "runDate");
            return (Criteria) this;
        }

        public Criteria andStartingWorkIsNull() {
            addCriterion("starting_work is null");
            return (Criteria) this;
        }

        public Criteria andStartingWorkIsNotNull() {
            addCriterion("starting_work is not null");
            return (Criteria) this;
        }

        public Criteria andStartingWorkEqualTo(String value) {
            addCriterion("starting_work =", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkNotEqualTo(String value) {
            addCriterion("starting_work <>", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkGreaterThan(String value) {
            addCriterion("starting_work >", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkGreaterThanOrEqualTo(String value) {
            addCriterion("starting_work >=", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkLessThan(String value) {
            addCriterion("starting_work <", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkLessThanOrEqualTo(String value) {
            addCriterion("starting_work <=", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkLike(String value) {
            addCriterion("starting_work like", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkNotLike(String value) {
            addCriterion("starting_work not like", value, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkIn(List<String> values) {
            addCriterion("starting_work in", values, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkNotIn(List<String> values) {
            addCriterion("starting_work not in", values, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkBetween(String value1, String value2) {
            addCriterion("starting_work between", value1, value2, "startingWork");
            return (Criteria) this;
        }

        public Criteria andStartingWorkNotBetween(String value1, String value2) {
            addCriterion("starting_work not between", value1, value2, "startingWork");
            return (Criteria) this;
        }

        public Criteria andLastJobNameIsNull() {
            addCriterion("last_job_name is null");
            return (Criteria) this;
        }

        public Criteria andLastJobNameIsNotNull() {
            addCriterion("last_job_name is not null");
            return (Criteria) this;
        }

        public Criteria andLastJobNameEqualTo(String value) {
            addCriterion("last_job_name =", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameNotEqualTo(String value) {
            addCriterion("last_job_name <>", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameGreaterThan(String value) {
            addCriterion("last_job_name >", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("last_job_name >=", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameLessThan(String value) {
            addCriterion("last_job_name <", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameLessThanOrEqualTo(String value) {
            addCriterion("last_job_name <=", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameLike(String value) {
            addCriterion("last_job_name like", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameNotLike(String value) {
            addCriterion("last_job_name not like", value, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameIn(List<String> values) {
            addCriterion("last_job_name in", values, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameNotIn(List<String> values) {
            addCriterion("last_job_name not in", values, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameBetween(String value1, String value2) {
            addCriterion("last_job_name between", value1, value2, "lastJobName");
            return (Criteria) this;
        }

        public Criteria andLastJobNameNotBetween(String value1, String value2) {
            addCriterion("last_job_name not between", value1, value2, "lastJobName");
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

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
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