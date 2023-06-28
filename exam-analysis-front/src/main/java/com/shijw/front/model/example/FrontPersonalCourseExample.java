package com.shijw.front.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrontPersonalCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FrontPersonalCourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesIsNull() {
            addCriterion("course_objectives is null");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesIsNotNull() {
            addCriterion("course_objectives is not null");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesEqualTo(String value) {
            addCriterion("course_objectives =", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesNotEqualTo(String value) {
            addCriterion("course_objectives <>", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesGreaterThan(String value) {
            addCriterion("course_objectives >", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesGreaterThanOrEqualTo(String value) {
            addCriterion("course_objectives >=", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesLessThan(String value) {
            addCriterion("course_objectives <", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesLessThanOrEqualTo(String value) {
            addCriterion("course_objectives <=", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesLike(String value) {
            addCriterion("course_objectives like", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesNotLike(String value) {
            addCriterion("course_objectives not like", value, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesIn(List<String> values) {
            addCriterion("course_objectives in", values, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesNotIn(List<String> values) {
            addCriterion("course_objectives not in", values, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesBetween(String value1, String value2) {
            addCriterion("course_objectives between", value1, value2, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesNotBetween(String value1, String value2) {
            addCriterion("course_objectives not between", value1, value2, "courseObjectives");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoIsNull() {
            addCriterion("course_objectives_info is null");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoIsNotNull() {
            addCriterion("course_objectives_info is not null");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoEqualTo(String value) {
            addCriterion("course_objectives_info =", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoNotEqualTo(String value) {
            addCriterion("course_objectives_info <>", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoGreaterThan(String value) {
            addCriterion("course_objectives_info >", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoGreaterThanOrEqualTo(String value) {
            addCriterion("course_objectives_info >=", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoLessThan(String value) {
            addCriterion("course_objectives_info <", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoLessThanOrEqualTo(String value) {
            addCriterion("course_objectives_info <=", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoLike(String value) {
            addCriterion("course_objectives_info like", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoNotLike(String value) {
            addCriterion("course_objectives_info not like", value, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoIn(List<String> values) {
            addCriterion("course_objectives_info in", values, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoNotIn(List<String> values) {
            addCriterion("course_objectives_info not in", values, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoBetween(String value1, String value2) {
            addCriterion("course_objectives_info between", value1, value2, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCourseObjectivesInfoNotBetween(String value1, String value2) {
            addCriterion("course_objectives_info not between", value1, value2, "courseObjectivesInfo");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNull() {
            addCriterion("credits is null");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNotNull() {
            addCriterion("credits is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsEqualTo(Double value) {
            addCriterion("credits =", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotEqualTo(Double value) {
            addCriterion("credits <>", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThan(Double value) {
            addCriterion("credits >", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThanOrEqualTo(Double value) {
            addCriterion("credits >=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThan(Double value) {
            addCriterion("credits <", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThanOrEqualTo(Double value) {
            addCriterion("credits <=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsIn(List<Double> values) {
            addCriterion("credits in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotIn(List<Double> values) {
            addCriterion("credits not in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsBetween(Double value1, Double value2) {
            addCriterion("credits between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotBetween(Double value1, Double value2) {
            addCriterion("credits not between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(String value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(String value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(String value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(String value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLike(String value) {
            addCriterion("course_code like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotLike(String value) {
            addCriterion("course_code not like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<String> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<String> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(String value1, String value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(String value1, String value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andExamWayIsNull() {
            addCriterion("exam_way is null");
            return (Criteria) this;
        }

        public Criteria andExamWayIsNotNull() {
            addCriterion("exam_way is not null");
            return (Criteria) this;
        }

        public Criteria andExamWayEqualTo(String value) {
            addCriterion("exam_way =", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayNotEqualTo(String value) {
            addCriterion("exam_way <>", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayGreaterThan(String value) {
            addCriterion("exam_way >", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayGreaterThanOrEqualTo(String value) {
            addCriterion("exam_way >=", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayLessThan(String value) {
            addCriterion("exam_way <", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayLessThanOrEqualTo(String value) {
            addCriterion("exam_way <=", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayLike(String value) {
            addCriterion("exam_way like", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayNotLike(String value) {
            addCriterion("exam_way not like", value, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayIn(List<String> values) {
            addCriterion("exam_way in", values, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayNotIn(List<String> values) {
            addCriterion("exam_way not in", values, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayBetween(String value1, String value2) {
            addCriterion("exam_way between", value1, value2, "examWay");
            return (Criteria) this;
        }

        public Criteria andExamWayNotBetween(String value1, String value2) {
            addCriterion("exam_way not between", value1, value2, "examWay");
            return (Criteria) this;
        }

        public Criteria andProportionIsNull() {
            addCriterion("proportion is null");
            return (Criteria) this;
        }

        public Criteria andProportionIsNotNull() {
            addCriterion("proportion is not null");
            return (Criteria) this;
        }

        public Criteria andProportionEqualTo(String value) {
            addCriterion("proportion =", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotEqualTo(String value) {
            addCriterion("proportion <>", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThan(String value) {
            addCriterion("proportion >", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionGreaterThanOrEqualTo(String value) {
            addCriterion("proportion >=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThan(String value) {
            addCriterion("proportion <", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLessThanOrEqualTo(String value) {
            addCriterion("proportion <=", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionLike(String value) {
            addCriterion("proportion like", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotLike(String value) {
            addCriterion("proportion not like", value, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionIn(List<String> values) {
            addCriterion("proportion in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotIn(List<String> values) {
            addCriterion("proportion not in", values, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionBetween(String value1, String value2) {
            addCriterion("proportion between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andProportionNotBetween(String value1, String value2) {
            addCriterion("proportion not between", value1, value2, "proportion");
            return (Criteria) this;
        }

        public Criteria andClassHourIsNull() {
            addCriterion("class_hour is null");
            return (Criteria) this;
        }

        public Criteria andClassHourIsNotNull() {
            addCriterion("class_hour is not null");
            return (Criteria) this;
        }

        public Criteria andClassHourEqualTo(String value) {
            addCriterion("class_hour =", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourNotEqualTo(String value) {
            addCriterion("class_hour <>", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourGreaterThan(String value) {
            addCriterion("class_hour >", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourGreaterThanOrEqualTo(String value) {
            addCriterion("class_hour >=", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourLessThan(String value) {
            addCriterion("class_hour <", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourLessThanOrEqualTo(String value) {
            addCriterion("class_hour <=", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourLike(String value) {
            addCriterion("class_hour like", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourNotLike(String value) {
            addCriterion("class_hour not like", value, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourIn(List<String> values) {
            addCriterion("class_hour in", values, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourNotIn(List<String> values) {
            addCriterion("class_hour not in", values, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourBetween(String value1, String value2) {
            addCriterion("class_hour between", value1, value2, "classHour");
            return (Criteria) this;
        }

        public Criteria andClassHourNotBetween(String value1, String value2) {
            addCriterion("class_hour not between", value1, value2, "classHour");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameIsNull() {
            addCriterion("create_username is null");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameIsNotNull() {
            addCriterion("create_username is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameEqualTo(String value) {
            addCriterion("create_username =", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotEqualTo(String value) {
            addCriterion("create_username <>", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameGreaterThan(String value) {
            addCriterion("create_username >", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("create_username >=", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameLessThan(String value) {
            addCriterion("create_username <", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameLessThanOrEqualTo(String value) {
            addCriterion("create_username <=", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameLike(String value) {
            addCriterion("create_username like", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotLike(String value) {
            addCriterion("create_username not like", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameIn(List<String> values) {
            addCriterion("create_username in", values, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotIn(List<String> values) {
            addCriterion("create_username not in", values, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameBetween(String value1, String value2) {
            addCriterion("create_username between", value1, value2, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotBetween(String value1, String value2) {
            addCriterion("create_username not between", value1, value2, "createUsername");
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