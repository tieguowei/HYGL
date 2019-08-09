package com.resale.background.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessHistoryExample() {
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

        public Criteria andProcessNameIsNull() {
            addCriterion("process_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIsNull() {
            addCriterion("process_type is null");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIsNotNull() {
            addCriterion("process_type is not null");
            return (Criteria) this;
        }

        public Criteria andProcessTypeEqualTo(String value) {
            addCriterion("process_type =", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotEqualTo(String value) {
            addCriterion("process_type <>", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeGreaterThan(String value) {
            addCriterion("process_type >", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("process_type >=", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLessThan(String value) {
            addCriterion("process_type <", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLessThanOrEqualTo(String value) {
            addCriterion("process_type <=", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLike(String value) {
            addCriterion("process_type like", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotLike(String value) {
            addCriterion("process_type not like", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIn(List<String> values) {
            addCriterion("process_type in", values, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotIn(List<String> values) {
            addCriterion("process_type not in", values, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeBetween(String value1, String value2) {
            addCriterion("process_type between", value1, value2, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotBetween(String value1, String value2) {
            addCriterion("process_type not between", value1, value2, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessSketchIsNull() {
            addCriterion("process_sketch is null");
            return (Criteria) this;
        }

        public Criteria andProcessSketchIsNotNull() {
            addCriterion("process_sketch is not null");
            return (Criteria) this;
        }

        public Criteria andProcessSketchEqualTo(String value) {
            addCriterion("process_sketch =", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchNotEqualTo(String value) {
            addCriterion("process_sketch <>", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchGreaterThan(String value) {
            addCriterion("process_sketch >", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchGreaterThanOrEqualTo(String value) {
            addCriterion("process_sketch >=", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchLessThan(String value) {
            addCriterion("process_sketch <", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchLessThanOrEqualTo(String value) {
            addCriterion("process_sketch <=", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchLike(String value) {
            addCriterion("process_sketch like", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchNotLike(String value) {
            addCriterion("process_sketch not like", value, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchIn(List<String> values) {
            addCriterion("process_sketch in", values, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchNotIn(List<String> values) {
            addCriterion("process_sketch not in", values, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchBetween(String value1, String value2) {
            addCriterion("process_sketch between", value1, value2, "processSketch");
            return (Criteria) this;
        }

        public Criteria andProcessSketchNotBetween(String value1, String value2) {
            addCriterion("process_sketch not between", value1, value2, "processSketch");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeIsNull() {
            addCriterion("start_run_time is null");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeIsNotNull() {
            addCriterion("start_run_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeEqualTo(Date value) {
            addCriterion("start_run_time =", value, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeNotEqualTo(Date value) {
            addCriterion("start_run_time <>", value, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeGreaterThan(Date value) {
            addCriterion("start_run_time >", value, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_run_time >=", value, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeLessThan(Date value) {
            addCriterion("start_run_time <", value, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_run_time <=", value, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeIn(List<Date> values) {
            addCriterion("start_run_time in", values, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeNotIn(List<Date> values) {
            addCriterion("start_run_time not in", values, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeBetween(Date value1, Date value2) {
            addCriterion("start_run_time between", value1, value2, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andStartRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_run_time not between", value1, value2, "startRunTime");
            return (Criteria) this;
        }

        public Criteria andRunDurationIsNull() {
            addCriterion("run_duration is null");
            return (Criteria) this;
        }

        public Criteria andRunDurationIsNotNull() {
            addCriterion("run_duration is not null");
            return (Criteria) this;
        }

        public Criteria andRunDurationEqualTo(String value) {
            addCriterion("run_duration =", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationNotEqualTo(String value) {
            addCriterion("run_duration <>", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationGreaterThan(String value) {
            addCriterion("run_duration >", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationGreaterThanOrEqualTo(String value) {
            addCriterion("run_duration >=", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationLessThan(String value) {
            addCriterion("run_duration <", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationLessThanOrEqualTo(String value) {
            addCriterion("run_duration <=", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationLike(String value) {
            addCriterion("run_duration like", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationNotLike(String value) {
            addCriterion("run_duration not like", value, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationIn(List<String> values) {
            addCriterion("run_duration in", values, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationNotIn(List<String> values) {
            addCriterion("run_duration not in", values, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationBetween(String value1, String value2) {
            addCriterion("run_duration between", value1, value2, "runDuration");
            return (Criteria) this;
        }

        public Criteria andRunDurationNotBetween(String value1, String value2) {
            addCriterion("run_duration not between", value1, value2, "runDuration");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeIsNull() {
            addCriterion("end_run_time is null");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeIsNotNull() {
            addCriterion("end_run_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeEqualTo(Date value) {
            addCriterion("end_run_time =", value, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeNotEqualTo(Date value) {
            addCriterion("end_run_time <>", value, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeGreaterThan(Date value) {
            addCriterion("end_run_time >", value, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_run_time >=", value, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeLessThan(Date value) {
            addCriterion("end_run_time <", value, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_run_time <=", value, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeIn(List<Date> values) {
            addCriterion("end_run_time in", values, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeNotIn(List<Date> values) {
            addCriterion("end_run_time not in", values, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeBetween(Date value1, Date value2) {
            addCriterion("end_run_time between", value1, value2, "endRunTime");
            return (Criteria) this;
        }

        public Criteria andEndRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_run_time not between", value1, value2, "endRunTime");
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