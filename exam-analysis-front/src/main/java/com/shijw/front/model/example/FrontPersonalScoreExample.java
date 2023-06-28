package com.shijw.front.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrontPersonalScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FrontPersonalScoreExample() {
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

        public Criteria andTeachInfoIdIsNull() {
            addCriterion("teach_info_id is null");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdIsNotNull() {
            addCriterion("teach_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdEqualTo(String value) {
            addCriterion("teach_info_id =", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdNotEqualTo(String value) {
            addCriterion("teach_info_id <>", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdGreaterThan(String value) {
            addCriterion("teach_info_id >", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("teach_info_id >=", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdLessThan(String value) {
            addCriterion("teach_info_id <", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdLessThanOrEqualTo(String value) {
            addCriterion("teach_info_id <=", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdLike(String value) {
            addCriterion("teach_info_id like", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdNotLike(String value) {
            addCriterion("teach_info_id not like", value, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdIn(List<String> values) {
            addCriterion("teach_info_id in", values, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdNotIn(List<String> values) {
            addCriterion("teach_info_id not in", values, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdBetween(String value1, String value2) {
            addCriterion("teach_info_id between", value1, value2, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andTeachInfoIdNotBetween(String value1, String value2) {
            addCriterion("teach_info_id not between", value1, value2, "teachInfoId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreIsNull() {
            addCriterion("homework_score is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreIsNotNull() {
            addCriterion("homework_score is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreEqualTo(Double value) {
            addCriterion("homework_score =", value, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreNotEqualTo(Double value) {
            addCriterion("homework_score <>", value, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreGreaterThan(Double value) {
            addCriterion("homework_score >", value, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("homework_score >=", value, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreLessThan(Double value) {
            addCriterion("homework_score <", value, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreLessThanOrEqualTo(Double value) {
            addCriterion("homework_score <=", value, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreIn(List<Double> values) {
            addCriterion("homework_score in", values, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreNotIn(List<Double> values) {
            addCriterion("homework_score not in", values, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreBetween(Double value1, Double value2) {
            addCriterion("homework_score between", value1, value2, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andHomeworkScoreNotBetween(Double value1, Double value2) {
            addCriterion("homework_score not between", value1, value2, "homeworkScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreIsNull() {
            addCriterion("experiment_score is null");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreIsNotNull() {
            addCriterion("experiment_score is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreEqualTo(Double value) {
            addCriterion("experiment_score =", value, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreNotEqualTo(Double value) {
            addCriterion("experiment_score <>", value, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreGreaterThan(Double value) {
            addCriterion("experiment_score >", value, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("experiment_score >=", value, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreLessThan(Double value) {
            addCriterion("experiment_score <", value, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreLessThanOrEqualTo(Double value) {
            addCriterion("experiment_score <=", value, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreIn(List<Double> values) {
            addCriterion("experiment_score in", values, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreNotIn(List<Double> values) {
            addCriterion("experiment_score not in", values, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreBetween(Double value1, Double value2) {
            addCriterion("experiment_score between", value1, value2, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andExperimentScoreNotBetween(Double value1, Double value2) {
            addCriterion("experiment_score not between", value1, value2, "experimentScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreIsNull() {
            addCriterion("practice_score is null");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreIsNotNull() {
            addCriterion("practice_score is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreEqualTo(Double value) {
            addCriterion("practice_score =", value, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreNotEqualTo(Double value) {
            addCriterion("practice_score <>", value, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreGreaterThan(Double value) {
            addCriterion("practice_score >", value, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("practice_score >=", value, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreLessThan(Double value) {
            addCriterion("practice_score <", value, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreLessThanOrEqualTo(Double value) {
            addCriterion("practice_score <=", value, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreIn(List<Double> values) {
            addCriterion("practice_score in", values, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreNotIn(List<Double> values) {
            addCriterion("practice_score not in", values, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreBetween(Double value1, Double value2) {
            addCriterion("practice_score between", value1, value2, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andPracticeScoreNotBetween(Double value1, Double value2) {
            addCriterion("practice_score not between", value1, value2, "practiceScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreIsNull() {
            addCriterion("case_score is null");
            return (Criteria) this;
        }

        public Criteria andCaseScoreIsNotNull() {
            addCriterion("case_score is not null");
            return (Criteria) this;
        }

        public Criteria andCaseScoreEqualTo(Double value) {
            addCriterion("case_score =", value, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreNotEqualTo(Double value) {
            addCriterion("case_score <>", value, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreGreaterThan(Double value) {
            addCriterion("case_score >", value, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("case_score >=", value, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreLessThan(Double value) {
            addCriterion("case_score <", value, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreLessThanOrEqualTo(Double value) {
            addCriterion("case_score <=", value, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreIn(List<Double> values) {
            addCriterion("case_score in", values, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreNotIn(List<Double> values) {
            addCriterion("case_score not in", values, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreBetween(Double value1, Double value2) {
            addCriterion("case_score between", value1, value2, "caseScore");
            return (Criteria) this;
        }

        public Criteria andCaseScoreNotBetween(Double value1, Double value2) {
            addCriterion("case_score not between", value1, value2, "caseScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreIsNull() {
            addCriterion("performance_score is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreIsNotNull() {
            addCriterion("performance_score is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreEqualTo(Double value) {
            addCriterion("performance_score =", value, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreNotEqualTo(Double value) {
            addCriterion("performance_score <>", value, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreGreaterThan(Double value) {
            addCriterion("performance_score >", value, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("performance_score >=", value, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreLessThan(Double value) {
            addCriterion("performance_score <", value, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreLessThanOrEqualTo(Double value) {
            addCriterion("performance_score <=", value, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreIn(List<Double> values) {
            addCriterion("performance_score in", values, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreNotIn(List<Double> values) {
            addCriterion("performance_score not in", values, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreBetween(Double value1, Double value2) {
            addCriterion("performance_score between", value1, value2, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andPerformanceScoreNotBetween(Double value1, Double value2) {
            addCriterion("performance_score not between", value1, value2, "performanceScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreIsNull() {
            addCriterion("process_evaluation_score is null");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreIsNotNull() {
            addCriterion("process_evaluation_score is not null");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreEqualTo(Double value) {
            addCriterion("process_evaluation_score =", value, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreNotEqualTo(Double value) {
            addCriterion("process_evaluation_score <>", value, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreGreaterThan(Double value) {
            addCriterion("process_evaluation_score >", value, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("process_evaluation_score >=", value, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreLessThan(Double value) {
            addCriterion("process_evaluation_score <", value, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreLessThanOrEqualTo(Double value) {
            addCriterion("process_evaluation_score <=", value, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreIn(List<Double> values) {
            addCriterion("process_evaluation_score in", values, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreNotIn(List<Double> values) {
            addCriterion("process_evaluation_score not in", values, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreBetween(Double value1, Double value2) {
            addCriterion("process_evaluation_score between", value1, value2, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andProcessEvaluationScoreNotBetween(Double value1, Double value2) {
            addCriterion("process_evaluation_score not between", value1, value2, "processEvaluationScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreIsNull() {
            addCriterion("usual_score is null");
            return (Criteria) this;
        }

        public Criteria andUsualScoreIsNotNull() {
            addCriterion("usual_score is not null");
            return (Criteria) this;
        }

        public Criteria andUsualScoreEqualTo(Double value) {
            addCriterion("usual_score =", value, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreNotEqualTo(Double value) {
            addCriterion("usual_score <>", value, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreGreaterThan(Double value) {
            addCriterion("usual_score >", value, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("usual_score >=", value, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreLessThan(Double value) {
            addCriterion("usual_score <", value, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreLessThanOrEqualTo(Double value) {
            addCriterion("usual_score <=", value, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreIn(List<Double> values) {
            addCriterion("usual_score in", values, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreNotIn(List<Double> values) {
            addCriterion("usual_score not in", values, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreBetween(Double value1, Double value2) {
            addCriterion("usual_score between", value1, value2, "usualScore");
            return (Criteria) this;
        }

        public Criteria andUsualScoreNotBetween(Double value1, Double value2) {
            addCriterion("usual_score not between", value1, value2, "usualScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreIsNull() {
            addCriterion("mid_term_score is null");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreIsNotNull() {
            addCriterion("mid_term_score is not null");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreEqualTo(Double value) {
            addCriterion("mid_term_score =", value, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreNotEqualTo(Double value) {
            addCriterion("mid_term_score <>", value, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreGreaterThan(Double value) {
            addCriterion("mid_term_score >", value, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("mid_term_score >=", value, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreLessThan(Double value) {
            addCriterion("mid_term_score <", value, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreLessThanOrEqualTo(Double value) {
            addCriterion("mid_term_score <=", value, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreIn(List<Double> values) {
            addCriterion("mid_term_score in", values, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreNotIn(List<Double> values) {
            addCriterion("mid_term_score not in", values, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreBetween(Double value1, Double value2) {
            addCriterion("mid_term_score between", value1, value2, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andMidTermScoreNotBetween(Double value1, Double value2) {
            addCriterion("mid_term_score not between", value1, value2, "midTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreIsNull() {
            addCriterion("end_term_score is null");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreIsNotNull() {
            addCriterion("end_term_score is not null");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreEqualTo(Double value) {
            addCriterion("end_term_score =", value, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreNotEqualTo(Double value) {
            addCriterion("end_term_score <>", value, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreGreaterThan(Double value) {
            addCriterion("end_term_score >", value, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("end_term_score >=", value, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreLessThan(Double value) {
            addCriterion("end_term_score <", value, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreLessThanOrEqualTo(Double value) {
            addCriterion("end_term_score <=", value, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreIn(List<Double> values) {
            addCriterion("end_term_score in", values, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreNotIn(List<Double> values) {
            addCriterion("end_term_score not in", values, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreBetween(Double value1, Double value2) {
            addCriterion("end_term_score between", value1, value2, "endTermScore");
            return (Criteria) this;
        }

        public Criteria andEndTermScoreNotBetween(Double value1, Double value2) {
            addCriterion("end_term_score not between", value1, value2, "endTermScore");
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