package com.ai.paas.cpaas.mgmt.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class SysCodesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SysCodesCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andSysCodeIsNull() {
            addCriterion("sys_code is null");
            return (Criteria) this;
        }

        public Criteria andSysCodeIsNotNull() {
            addCriterion("sys_code is not null");
            return (Criteria) this;
        }

        public Criteria andSysCodeEqualTo(String value) {
            addCriterion("sys_code =", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotEqualTo(String value) {
            addCriterion("sys_code <>", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThan(String value) {
            addCriterion("sys_code >", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_code >=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThan(String value) {
            addCriterion("sys_code <", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLessThanOrEqualTo(String value) {
            addCriterion("sys_code <=", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeLike(String value) {
            addCriterion("sys_code like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotLike(String value) {
            addCriterion("sys_code not like", value, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeIn(List<String> values) {
            addCriterion("sys_code in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotIn(List<String> values) {
            addCriterion("sys_code not in", values, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeBetween(String value1, String value2) {
            addCriterion("sys_code between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andSysCodeNotBetween(String value1, String value2) {
            addCriterion("sys_code not between", value1, value2, "sysCode");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIsNull() {
            addCriterion("code_key is null");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIsNotNull() {
            addCriterion("code_key is not null");
            return (Criteria) this;
        }

        public Criteria andCodeKeyEqualTo(String value) {
            addCriterion("code_key =", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotEqualTo(String value) {
            addCriterion("code_key <>", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyGreaterThan(String value) {
            addCriterion("code_key >", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("code_key >=", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyLessThan(String value) {
            addCriterion("code_key <", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyLessThanOrEqualTo(String value) {
            addCriterion("code_key <=", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyLike(String value) {
            addCriterion("code_key like", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotLike(String value) {
            addCriterion("code_key not like", value, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyIn(List<String> values) {
            addCriterion("code_key in", values, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotIn(List<String> values) {
            addCriterion("code_key not in", values, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyBetween(String value1, String value2) {
            addCriterion("code_key between", value1, value2, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeKeyNotBetween(String value1, String value2) {
            addCriterion("code_key not between", value1, value2, "codeKey");
            return (Criteria) this;
        }

        public Criteria andCodeValueIsNull() {
            addCriterion("code_value is null");
            return (Criteria) this;
        }

        public Criteria andCodeValueIsNotNull() {
            addCriterion("code_value is not null");
            return (Criteria) this;
        }

        public Criteria andCodeValueEqualTo(String value) {
            addCriterion("code_value =", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotEqualTo(String value) {
            addCriterion("code_value <>", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueGreaterThan(String value) {
            addCriterion("code_value >", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueGreaterThanOrEqualTo(String value) {
            addCriterion("code_value >=", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLessThan(String value) {
            addCriterion("code_value <", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLessThanOrEqualTo(String value) {
            addCriterion("code_value <=", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueLike(String value) {
            addCriterion("code_value like", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotLike(String value) {
            addCriterion("code_value not like", value, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueIn(List<String> values) {
            addCriterion("code_value in", values, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotIn(List<String> values) {
            addCriterion("code_value not in", values, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueBetween(String value1, String value2) {
            addCriterion("code_value between", value1, value2, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeValueNotBetween(String value1, String value2) {
            addCriterion("code_value not between", value1, value2, "codeValue");
            return (Criteria) this;
        }

        public Criteria andCodeStateIsNull() {
            addCriterion("code_state is null");
            return (Criteria) this;
        }

        public Criteria andCodeStateIsNotNull() {
            addCriterion("code_state is not null");
            return (Criteria) this;
        }

        public Criteria andCodeStateEqualTo(Integer value) {
            addCriterion("code_state =", value, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateNotEqualTo(Integer value) {
            addCriterion("code_state <>", value, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateGreaterThan(Integer value) {
            addCriterion("code_state >", value, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_state >=", value, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateLessThan(Integer value) {
            addCriterion("code_state <", value, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateLessThanOrEqualTo(Integer value) {
            addCriterion("code_state <=", value, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateIn(List<Integer> values) {
            addCriterion("code_state in", values, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateNotIn(List<Integer> values) {
            addCriterion("code_state not in", values, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateBetween(Integer value1, Integer value2) {
            addCriterion("code_state between", value1, value2, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("code_state not between", value1, value2, "codeState");
            return (Criteria) this;
        }

        public Criteria andCodeOrderIsNull() {
            addCriterion("code_order is null");
            return (Criteria) this;
        }

        public Criteria andCodeOrderIsNotNull() {
            addCriterion("code_order is not null");
            return (Criteria) this;
        }

        public Criteria andCodeOrderEqualTo(Integer value) {
            addCriterion("code_order =", value, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderNotEqualTo(Integer value) {
            addCriterion("code_order <>", value, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderGreaterThan(Integer value) {
            addCriterion("code_order >", value, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_order >=", value, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderLessThan(Integer value) {
            addCriterion("code_order <", value, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderLessThanOrEqualTo(Integer value) {
            addCriterion("code_order <=", value, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderIn(List<Integer> values) {
            addCriterion("code_order in", values, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderNotIn(List<Integer> values) {
            addCriterion("code_order not in", values, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderBetween(Integer value1, Integer value2) {
            addCriterion("code_order between", value1, value2, "codeOrder");
            return (Criteria) this;
        }

        public Criteria andCodeOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("code_order not between", value1, value2, "codeOrder");
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