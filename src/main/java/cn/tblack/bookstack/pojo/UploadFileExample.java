package cn.tblack.bookstack.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UploadFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UploadFileExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("FILE_ID =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("FILE_ID <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("FILE_ID >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FILE_ID >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("FILE_ID <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("FILE_ID <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("FILE_ID in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("FILE_ID not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("FILE_ID between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FILE_ID not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andOldNameIsNull() {
            addCriterion("OLD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOldNameIsNotNull() {
            addCriterion("OLD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOldNameEqualTo(String value) {
            addCriterion("OLD_NAME =", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameNotEqualTo(String value) {
            addCriterion("OLD_NAME <>", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameGreaterThan(String value) {
            addCriterion("OLD_NAME >", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_NAME >=", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameLessThan(String value) {
            addCriterion("OLD_NAME <", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameLessThanOrEqualTo(String value) {
            addCriterion("OLD_NAME <=", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameLike(String value) {
            addCriterion("OLD_NAME like", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameNotLike(String value) {
            addCriterion("OLD_NAME not like", value, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameIn(List<String> values) {
            addCriterion("OLD_NAME in", values, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameNotIn(List<String> values) {
            addCriterion("OLD_NAME not in", values, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameBetween(String value1, String value2) {
            addCriterion("OLD_NAME between", value1, value2, "oldName");
            return (Criteria) this;
        }

        public Criteria andOldNameNotBetween(String value1, String value2) {
            addCriterion("OLD_NAME not between", value1, value2, "oldName");
            return (Criteria) this;
        }

        public Criteria andSavePathIsNull() {
            addCriterion("SAVE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSavePathIsNotNull() {
            addCriterion("SAVE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSavePathEqualTo(String value) {
            addCriterion("SAVE_PATH =", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotEqualTo(String value) {
            addCriterion("SAVE_PATH <>", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathGreaterThan(String value) {
            addCriterion("SAVE_PATH >", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathGreaterThanOrEqualTo(String value) {
            addCriterion("SAVE_PATH >=", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLessThan(String value) {
            addCriterion("SAVE_PATH <", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLessThanOrEqualTo(String value) {
            addCriterion("SAVE_PATH <=", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLike(String value) {
            addCriterion("SAVE_PATH like", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotLike(String value) {
            addCriterion("SAVE_PATH not like", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathIn(List<String> values) {
            addCriterion("SAVE_PATH in", values, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotIn(List<String> values) {
            addCriterion("SAVE_PATH not in", values, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathBetween(String value1, String value2) {
            addCriterion("SAVE_PATH between", value1, value2, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotBetween(String value1, String value2) {
            addCriterion("SAVE_PATH not between", value1, value2, "savePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathIsNull() {
            addCriterion("RELATIVE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andRelativePathIsNotNull() {
            addCriterion("RELATIVE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andRelativePathEqualTo(String value) {
            addCriterion("RELATIVE_PATH =", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotEqualTo(String value) {
            addCriterion("RELATIVE_PATH <>", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathGreaterThan(String value) {
            addCriterion("RELATIVE_PATH >", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIVE_PATH >=", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathLessThan(String value) {
            addCriterion("RELATIVE_PATH <", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathLessThanOrEqualTo(String value) {
            addCriterion("RELATIVE_PATH <=", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathLike(String value) {
            addCriterion("RELATIVE_PATH like", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotLike(String value) {
            addCriterion("RELATIVE_PATH not like", value, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathIn(List<String> values) {
            addCriterion("RELATIVE_PATH in", values, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotIn(List<String> values) {
            addCriterion("RELATIVE_PATH not in", values, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathBetween(String value1, String value2) {
            addCriterion("RELATIVE_PATH between", value1, value2, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRelativePathNotBetween(String value1, String value2) {
            addCriterion("RELATIVE_PATH not between", value1, value2, "relativePath");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("REAL_NAME =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("REAL_NAME <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("REAL_NAME >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_NAME >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("REAL_NAME <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("REAL_NAME <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("REAL_NAME like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("REAL_NAME not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("REAL_NAME in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("REAL_NAME not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("REAL_NAME between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("REAL_NAME not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("FILE_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("FILE_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("FILE_SIZE =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("FILE_SIZE <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("FILE_SIZE >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("FILE_SIZE >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("FILE_SIZE <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("FILE_SIZE <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("FILE_SIZE in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("FILE_SIZE not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("FILE_SIZE between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("FILE_SIZE not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("FILE_TYPE =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("FILE_TYPE <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("FILE_TYPE >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("FILE_TYPE <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("FILE_TYPE like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("FILE_TYPE not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("FILE_TYPE in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("FILE_TYPE not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("FILE_TYPE between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("FILE_TYPE not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileDescIsNull() {
            addCriterion("FILE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFileDescIsNotNull() {
            addCriterion("FILE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFileDescEqualTo(String value) {
            addCriterion("FILE_DESC =", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotEqualTo(String value) {
            addCriterion("FILE_DESC <>", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescGreaterThan(String value) {
            addCriterion("FILE_DESC >", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_DESC >=", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescLessThan(String value) {
            addCriterion("FILE_DESC <", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescLessThanOrEqualTo(String value) {
            addCriterion("FILE_DESC <=", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescLike(String value) {
            addCriterion("FILE_DESC like", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotLike(String value) {
            addCriterion("FILE_DESC not like", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescIn(List<String> values) {
            addCriterion("FILE_DESC in", values, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotIn(List<String> values) {
            addCriterion("FILE_DESC not in", values, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescBetween(String value1, String value2) {
            addCriterion("FILE_DESC between", value1, value2, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotBetween(String value1, String value2) {
            addCriterion("FILE_DESC not between", value1, value2, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andUploadUserIsNull() {
            addCriterion("UPLOAD_USER is null");
            return (Criteria) this;
        }

        public Criteria andUploadUserIsNotNull() {
            addCriterion("UPLOAD_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUploadUserEqualTo(String value) {
            addCriterion("UPLOAD_USER =", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserNotEqualTo(String value) {
            addCriterion("UPLOAD_USER <>", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserGreaterThan(String value) {
            addCriterion("UPLOAD_USER >", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPLOAD_USER >=", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserLessThan(String value) {
            addCriterion("UPLOAD_USER <", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserLessThanOrEqualTo(String value) {
            addCriterion("UPLOAD_USER <=", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserLike(String value) {
            addCriterion("UPLOAD_USER like", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserNotLike(String value) {
            addCriterion("UPLOAD_USER not like", value, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserIn(List<String> values) {
            addCriterion("UPLOAD_USER in", values, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserNotIn(List<String> values) {
            addCriterion("UPLOAD_USER not in", values, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserBetween(String value1, String value2) {
            addCriterion("UPLOAD_USER between", value1, value2, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadUserNotBetween(String value1, String value2) {
            addCriterion("UPLOAD_USER not between", value1, value2, "uploadUser");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("UPLOAD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("UPLOAD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("UPLOAD_DATE =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("UPLOAD_DATE <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("UPLOAD_DATE >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPLOAD_DATE >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("UPLOAD_DATE <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("UPLOAD_DATE <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("UPLOAD_DATE in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("UPLOAD_DATE not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("UPLOAD_DATE between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("UPLOAD_DATE not between", value1, value2, "uploadDate");
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