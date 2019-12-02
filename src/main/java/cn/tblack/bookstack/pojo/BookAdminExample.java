package cn.tblack.bookstack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookAdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookAdminExample() {
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

        public Criteria andAdminIdIsNull() {
            addCriterion("ADMIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("ADMIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("ADMIN_ID =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("ADMIN_ID <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("ADMIN_ID >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ADMIN_ID >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("ADMIN_ID <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("ADMIN_ID <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("ADMIN_ID in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("ADMIN_ID not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("ADMIN_ID between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ADMIN_ID not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("ADMIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("ADMIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("ADMIN_NAME =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("ADMIN_NAME <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("ADMIN_NAME >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIN_NAME >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("ADMIN_NAME <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("ADMIN_NAME <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("ADMIN_NAME like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("ADMIN_NAME not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("ADMIN_NAME in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("ADMIN_NAME not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("ADMIN_NAME between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("ADMIN_NAME not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIsNull() {
            addCriterion("AUTHORIZER is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIsNotNull() {
            addCriterion("AUTHORIZER is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerEqualTo(String value) {
            addCriterion("AUTHORIZER =", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerNotEqualTo(String value) {
            addCriterion("AUTHORIZER <>", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerGreaterThan(String value) {
            addCriterion("AUTHORIZER >", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerGreaterThanOrEqualTo(String value) {
            addCriterion("AUTHORIZER >=", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerLessThan(String value) {
            addCriterion("AUTHORIZER <", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerLessThanOrEqualTo(String value) {
            addCriterion("AUTHORIZER <=", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerLike(String value) {
            addCriterion("AUTHORIZER like", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerNotLike(String value) {
            addCriterion("AUTHORIZER not like", value, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIn(List<String> values) {
            addCriterion("AUTHORIZER in", values, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerNotIn(List<String> values) {
            addCriterion("AUTHORIZER not in", values, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerBetween(String value1, String value2) {
            addCriterion("AUTHORIZER between", value1, value2, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerNotBetween(String value1, String value2) {
            addCriterion("AUTHORIZER not between", value1, value2, "authorizer");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeIsNull() {
            addCriterion("AUTHORIZER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeIsNotNull() {
            addCriterion("AUTHORIZER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeEqualTo(Date value) {
            addCriterion("AUTHORIZER_TIME =", value, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeNotEqualTo(Date value) {
            addCriterion("AUTHORIZER_TIME <>", value, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeGreaterThan(Date value) {
            addCriterion("AUTHORIZER_TIME >", value, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AUTHORIZER_TIME >=", value, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeLessThan(Date value) {
            addCriterion("AUTHORIZER_TIME <", value, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeLessThanOrEqualTo(Date value) {
            addCriterion("AUTHORIZER_TIME <=", value, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeIn(List<Date> values) {
            addCriterion("AUTHORIZER_TIME in", values, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeNotIn(List<Date> values) {
            addCriterion("AUTHORIZER_TIME not in", values, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeBetween(Date value1, Date value2) {
            addCriterion("AUTHORIZER_TIME between", value1, value2, "authorizerTime");
            return (Criteria) this;
        }

        public Criteria andAuthorizerTimeNotBetween(Date value1, Date value2) {
            addCriterion("AUTHORIZER_TIME not between", value1, value2, "authorizerTime");
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