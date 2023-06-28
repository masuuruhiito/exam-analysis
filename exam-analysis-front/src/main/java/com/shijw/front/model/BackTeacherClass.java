package com.shijw.front.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BackTeacherClass {
    private Integer id;

    private String teacherId;

    private String courseId;

    private String classId;

    private String semester;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester == null ? null : semester.trim();
    }

    public static class FrontScoreExample {
        protected String orderByClause;

        protected boolean distinct;

        protected List<Criteria> oredCriteria;

        public FrontScoreExample() {
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

            public Criteria andClassIdIsNull() {
                addCriterion("class_id is null");
                return (Criteria) this;
            }

            public Criteria andClassIdIsNotNull() {
                addCriterion("class_id is not null");
                return (Criteria) this;
            }

            public Criteria andClassIdEqualTo(String value) {
                addCriterion("class_id =", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdNotEqualTo(String value) {
                addCriterion("class_id <>", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdGreaterThan(String value) {
                addCriterion("class_id >", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdGreaterThanOrEqualTo(String value) {
                addCriterion("class_id >=", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdLessThan(String value) {
                addCriterion("class_id <", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdLessThanOrEqualTo(String value) {
                addCriterion("class_id <=", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdLike(String value) {
                addCriterion("class_id like", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdNotLike(String value) {
                addCriterion("class_id not like", value, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdIn(List<String> values) {
                addCriterion("class_id in", values, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdNotIn(List<String> values) {
                addCriterion("class_id not in", values, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdBetween(String value1, String value2) {
                addCriterion("class_id between", value1, value2, "classId");
                return (Criteria) this;
            }

            public Criteria andClassIdNotBetween(String value1, String value2) {
                addCriterion("class_id not between", value1, value2, "classId");
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

            public Criteria andExperimentScoreIsNull() {
                addCriterion("experiment_score is null");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreIsNotNull() {
                addCriterion("experiment_score is not null");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreEqualTo(Integer value) {
                addCriterion("experiment_score =", value, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreNotEqualTo(Integer value) {
                addCriterion("experiment_score <>", value, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreGreaterThan(Integer value) {
                addCriterion("experiment_score >", value, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreGreaterThanOrEqualTo(Integer value) {
                addCriterion("experiment_score >=", value, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreLessThan(Integer value) {
                addCriterion("experiment_score <", value, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreLessThanOrEqualTo(Integer value) {
                addCriterion("experiment_score <=", value, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreIn(List<Integer> values) {
                addCriterion("experiment_score in", values, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreNotIn(List<Integer> values) {
                addCriterion("experiment_score not in", values, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreBetween(Integer value1, Integer value2) {
                addCriterion("experiment_score between", value1, value2, "experimentScore");
                return (Criteria) this;
            }

            public Criteria andExperimentScoreNotBetween(Integer value1, Integer value2) {
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

            public Criteria andPracticeScoreEqualTo(Integer value) {
                addCriterion("practice_score =", value, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreNotEqualTo(Integer value) {
                addCriterion("practice_score <>", value, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreGreaterThan(Integer value) {
                addCriterion("practice_score >", value, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreGreaterThanOrEqualTo(Integer value) {
                addCriterion("practice_score >=", value, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreLessThan(Integer value) {
                addCriterion("practice_score <", value, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreLessThanOrEqualTo(Integer value) {
                addCriterion("practice_score <=", value, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreIn(List<Integer> values) {
                addCriterion("practice_score in", values, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreNotIn(List<Integer> values) {
                addCriterion("practice_score not in", values, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreBetween(Integer value1, Integer value2) {
                addCriterion("practice_score between", value1, value2, "practiceScore");
                return (Criteria) this;
            }

            public Criteria andPracticeScoreNotBetween(Integer value1, Integer value2) {
                addCriterion("practice_score not between", value1, value2, "practiceScore");
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

            public Criteria andUsualScoreEqualTo(Integer value) {
                addCriterion("usual_score =", value, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreNotEqualTo(Integer value) {
                addCriterion("usual_score <>", value, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreGreaterThan(Integer value) {
                addCriterion("usual_score >", value, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreGreaterThanOrEqualTo(Integer value) {
                addCriterion("usual_score >=", value, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreLessThan(Integer value) {
                addCriterion("usual_score <", value, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreLessThanOrEqualTo(Integer value) {
                addCriterion("usual_score <=", value, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreIn(List<Integer> values) {
                addCriterion("usual_score in", values, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreNotIn(List<Integer> values) {
                addCriterion("usual_score not in", values, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreBetween(Integer value1, Integer value2) {
                addCriterion("usual_score between", value1, value2, "usualScore");
                return (Criteria) this;
            }

            public Criteria andUsualScoreNotBetween(Integer value1, Integer value2) {
                addCriterion("usual_score not between", value1, value2, "usualScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreIsNull() {
                addCriterion("midterm_score is null");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreIsNotNull() {
                addCriterion("midterm_score is not null");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreEqualTo(Integer value) {
                addCriterion("midterm_score =", value, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreNotEqualTo(Integer value) {
                addCriterion("midterm_score <>", value, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreGreaterThan(Integer value) {
                addCriterion("midterm_score >", value, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreGreaterThanOrEqualTo(Integer value) {
                addCriterion("midterm_score >=", value, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreLessThan(Integer value) {
                addCriterion("midterm_score <", value, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreLessThanOrEqualTo(Integer value) {
                addCriterion("midterm_score <=", value, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreIn(List<Integer> values) {
                addCriterion("midterm_score in", values, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreNotIn(List<Integer> values) {
                addCriterion("midterm_score not in", values, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreBetween(Integer value1, Integer value2) {
                addCriterion("midterm_score between", value1, value2, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andMidtermScoreNotBetween(Integer value1, Integer value2) {
                addCriterion("midterm_score not between", value1, value2, "midtermScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreIsNull() {
                addCriterion("final_score is null");
                return (Criteria) this;
            }

            public Criteria andFinalScoreIsNotNull() {
                addCriterion("final_score is not null");
                return (Criteria) this;
            }

            public Criteria andFinalScoreEqualTo(Integer value) {
                addCriterion("final_score =", value, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreNotEqualTo(Integer value) {
                addCriterion("final_score <>", value, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreGreaterThan(Integer value) {
                addCriterion("final_score >", value, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreGreaterThanOrEqualTo(Integer value) {
                addCriterion("final_score >=", value, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreLessThan(Integer value) {
                addCriterion("final_score <", value, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreLessThanOrEqualTo(Integer value) {
                addCriterion("final_score <=", value, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreIn(List<Integer> values) {
                addCriterion("final_score in", values, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreNotIn(List<Integer> values) {
                addCriterion("final_score not in", values, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreBetween(Integer value1, Integer value2) {
                addCriterion("final_score between", value1, value2, "finalScore");
                return (Criteria) this;
            }

            public Criteria andFinalScoreNotBetween(Integer value1, Integer value2) {
                addCriterion("final_score not between", value1, value2, "finalScore");
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
}