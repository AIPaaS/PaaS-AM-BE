package com.ai.paas.cpaas.be.am.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class ResClusterInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public ResClusterInfoCriteria() {
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

        public Criteria andClusterIdIsNull() {
            addCriterion("cluster_id is null");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNotNull() {
            addCriterion("cluster_id is not null");
            return (Criteria) this;
        }

        public Criteria andClusterIdEqualTo(String value) {
            addCriterion("cluster_id =", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotEqualTo(String value) {
            addCriterion("cluster_id <>", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThan(String value) {
            addCriterion("cluster_id >", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThanOrEqualTo(String value) {
            addCriterion("cluster_id >=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThan(String value) {
            addCriterion("cluster_id <", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThanOrEqualTo(String value) {
            addCriterion("cluster_id <=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLike(String value) {
            addCriterion("cluster_id like", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotLike(String value) {
            addCriterion("cluster_id not like", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdIn(List<String> values) {
            addCriterion("cluster_id in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotIn(List<String> values) {
            addCriterion("cluster_id not in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdBetween(String value1, String value2) {
            addCriterion("cluster_id between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotBetween(String value1, String value2) {
            addCriterion("cluster_id not between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterNameIsNull() {
            addCriterion("cluster_name is null");
            return (Criteria) this;
        }

        public Criteria andClusterNameIsNotNull() {
            addCriterion("cluster_name is not null");
            return (Criteria) this;
        }

        public Criteria andClusterNameEqualTo(String value) {
            addCriterion("cluster_name =", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotEqualTo(String value) {
            addCriterion("cluster_name <>", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameGreaterThan(String value) {
            addCriterion("cluster_name >", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameGreaterThanOrEqualTo(String value) {
            addCriterion("cluster_name >=", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameLessThan(String value) {
            addCriterion("cluster_name <", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameLessThanOrEqualTo(String value) {
            addCriterion("cluster_name <=", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameLike(String value) {
            addCriterion("cluster_name like", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotLike(String value) {
            addCriterion("cluster_name not like", value, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameIn(List<String> values) {
            addCriterion("cluster_name in", values, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotIn(List<String> values) {
            addCriterion("cluster_name not in", values, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameBetween(String value1, String value2) {
            addCriterion("cluster_name between", value1, value2, "clusterName");
            return (Criteria) this;
        }

        public Criteria andClusterNameNotBetween(String value1, String value2) {
            addCriterion("cluster_name not between", value1, value2, "clusterName");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrIsNull() {
            addCriterion("marathon_addr is null");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrIsNotNull() {
            addCriterion("marathon_addr is not null");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrEqualTo(String value) {
            addCriterion("marathon_addr =", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrNotEqualTo(String value) {
            addCriterion("marathon_addr <>", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrGreaterThan(String value) {
            addCriterion("marathon_addr >", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrGreaterThanOrEqualTo(String value) {
            addCriterion("marathon_addr >=", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrLessThan(String value) {
            addCriterion("marathon_addr <", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrLessThanOrEqualTo(String value) {
            addCriterion("marathon_addr <=", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrLike(String value) {
            addCriterion("marathon_addr like", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrNotLike(String value) {
            addCriterion("marathon_addr not like", value, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrIn(List<String> values) {
            addCriterion("marathon_addr in", values, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrNotIn(List<String> values) {
            addCriterion("marathon_addr not in", values, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrBetween(String value1, String value2) {
            addCriterion("marathon_addr between", value1, value2, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andMarathonAddrNotBetween(String value1, String value2) {
            addCriterion("marathon_addr not between", value1, value2, "marathonAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrIsNull() {
            addCriterion("consul_addr is null");
            return (Criteria) this;
        }

        public Criteria andConsulAddrIsNotNull() {
            addCriterion("consul_addr is not null");
            return (Criteria) this;
        }

        public Criteria andConsulAddrEqualTo(String value) {
            addCriterion("consul_addr =", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrNotEqualTo(String value) {
            addCriterion("consul_addr <>", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrGreaterThan(String value) {
            addCriterion("consul_addr >", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrGreaterThanOrEqualTo(String value) {
            addCriterion("consul_addr >=", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrLessThan(String value) {
            addCriterion("consul_addr <", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrLessThanOrEqualTo(String value) {
            addCriterion("consul_addr <=", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrLike(String value) {
            addCriterion("consul_addr like", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrNotLike(String value) {
            addCriterion("consul_addr not like", value, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrIn(List<String> values) {
            addCriterion("consul_addr in", values, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrNotIn(List<String> values) {
            addCriterion("consul_addr not in", values, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrBetween(String value1, String value2) {
            addCriterion("consul_addr between", value1, value2, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andConsulAddrNotBetween(String value1, String value2) {
            addCriterion("consul_addr not between", value1, value2, "consulAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrIsNull() {
            addCriterion("chronos_addr is null");
            return (Criteria) this;
        }

        public Criteria andChronosAddrIsNotNull() {
            addCriterion("chronos_addr is not null");
            return (Criteria) this;
        }

        public Criteria andChronosAddrEqualTo(String value) {
            addCriterion("chronos_addr =", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrNotEqualTo(String value) {
            addCriterion("chronos_addr <>", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrGreaterThan(String value) {
            addCriterion("chronos_addr >", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrGreaterThanOrEqualTo(String value) {
            addCriterion("chronos_addr >=", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrLessThan(String value) {
            addCriterion("chronos_addr <", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrLessThanOrEqualTo(String value) {
            addCriterion("chronos_addr <=", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrLike(String value) {
            addCriterion("chronos_addr like", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrNotLike(String value) {
            addCriterion("chronos_addr not like", value, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrIn(List<String> values) {
            addCriterion("chronos_addr in", values, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrNotIn(List<String> values) {
            addCriterion("chronos_addr not in", values, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrBetween(String value1, String value2) {
            addCriterion("chronos_addr between", value1, value2, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andChronosAddrNotBetween(String value1, String value2) {
            addCriterion("chronos_addr not between", value1, value2, "chronosAddr");
            return (Criteria) this;
        }

        public Criteria andMesosDomainIsNull() {
            addCriterion("mesos_domain is null");
            return (Criteria) this;
        }

        public Criteria andMesosDomainIsNotNull() {
            addCriterion("mesos_domain is not null");
            return (Criteria) this;
        }

        public Criteria andMesosDomainEqualTo(String value) {
            addCriterion("mesos_domain =", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainNotEqualTo(String value) {
            addCriterion("mesos_domain <>", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainGreaterThan(String value) {
            addCriterion("mesos_domain >", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainGreaterThanOrEqualTo(String value) {
            addCriterion("mesos_domain >=", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainLessThan(String value) {
            addCriterion("mesos_domain <", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainLessThanOrEqualTo(String value) {
            addCriterion("mesos_domain <=", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainLike(String value) {
            addCriterion("mesos_domain like", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainNotLike(String value) {
            addCriterion("mesos_domain not like", value, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainIn(List<String> values) {
            addCriterion("mesos_domain in", values, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainNotIn(List<String> values) {
            addCriterion("mesos_domain not in", values, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainBetween(String value1, String value2) {
            addCriterion("mesos_domain between", value1, value2, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andMesosDomainNotBetween(String value1, String value2) {
            addCriterion("mesos_domain not between", value1, value2, "mesosDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainIsNull() {
            addCriterion("external_domain is null");
            return (Criteria) this;
        }

        public Criteria andExternalDomainIsNotNull() {
            addCriterion("external_domain is not null");
            return (Criteria) this;
        }

        public Criteria andExternalDomainEqualTo(String value) {
            addCriterion("external_domain =", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainNotEqualTo(String value) {
            addCriterion("external_domain <>", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainGreaterThan(String value) {
            addCriterion("external_domain >", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainGreaterThanOrEqualTo(String value) {
            addCriterion("external_domain >=", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainLessThan(String value) {
            addCriterion("external_domain <", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainLessThanOrEqualTo(String value) {
            addCriterion("external_domain <=", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainLike(String value) {
            addCriterion("external_domain like", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainNotLike(String value) {
            addCriterion("external_domain not like", value, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainIn(List<String> values) {
            addCriterion("external_domain in", values, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainNotIn(List<String> values) {
            addCriterion("external_domain not in", values, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainBetween(String value1, String value2) {
            addCriterion("external_domain between", value1, value2, "externalDomain");
            return (Criteria) this;
        }

        public Criteria andExternalDomainNotBetween(String value1, String value2) {
            addCriterion("external_domain not between", value1, value2, "externalDomain");
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