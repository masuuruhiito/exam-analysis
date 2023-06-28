package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalCourse;
import com.shijw.front.model.example.FrontPersonalCourseExample.Criteria;
import com.shijw.front.model.example.FrontPersonalCourseExample.Criterion;

import java.util.List;
import java.util.Map;

import com.shijw.front.model.example.FrontPersonalCourseExample;
import org.apache.ibatis.jdbc.SQL;

public class FrontPersonalCourseSqlProvider {

    public String countByExample(FrontPersonalCourseExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("front_personal_course");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FrontPersonalCourseExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("front_personal_course");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FrontPersonalCourse record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("front_personal_course");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCourseId() != null) {
            sql.VALUES("course_id", "#{courseId,jdbcType=VARCHAR}");
        }

        if (record.getCourseName() != null) {
            sql.VALUES("course_name", "#{courseName,jdbcType=VARCHAR}");
        }

        if (record.getCourseObjectives() != null) {
            sql.VALUES("course_objectives", "#{courseObjectives,jdbcType=VARCHAR}");
        }

        if (record.getCourseObjectivesInfo() != null) {
            sql.VALUES("course_objectives_info", "#{courseObjectivesInfo,jdbcType=VARCHAR}");
        }

        if (record.getCredits() != null) {
            sql.VALUES("credits", "#{credits,jdbcType=DOUBLE}");
        }

        if (record.getCourseCode() != null) {
            sql.VALUES("course_code", "#{courseCode,jdbcType=VARCHAR}");
        }

        if (record.getExamWay() != null) {
            sql.VALUES("exam_way", "#{examWay,jdbcType=VARCHAR}");
        }

        if (record.getProportion() != null) {
            sql.VALUES("proportion", "#{proportion,jdbcType=VARCHAR}");
        }

        if (record.getClassHour() != null) {
            sql.VALUES("class_hour", "#{classHour,jdbcType=VARCHAR}");
        }

        if (record.getCreateUsername() != null) {
            sql.VALUES("create_username", "#{createUsername,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(FrontPersonalCourseExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("course_id");
        sql.SELECT("course_name");
        sql.SELECT("course_objectives");
        sql.SELECT("course_objectives_info");
        sql.SELECT("credits");
        sql.SELECT("course_code");
        sql.SELECT("exam_way");
        sql.SELECT("proportion");
        sql.SELECT("class_hour");
        sql.SELECT("create_username");
        sql.FROM("front_personal_course");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FrontPersonalCourse record = (FrontPersonalCourse) parameter.get("record");
        FrontPersonalCourseExample example = (FrontPersonalCourseExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("front_personal_course");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCourseId() != null) {
            sql.SET("course_id = #{record.courseId,jdbcType=VARCHAR}");
        }

        if (record.getCourseName() != null) {
            sql.SET("course_name = #{record.courseName,jdbcType=VARCHAR}");
        }

        if (record.getCourseObjectives() != null) {
            sql.SET("course_objectives = #{record.courseObjectives,jdbcType=VARCHAR}");
        }

        if (record.getCourseObjectivesInfo() != null) {
            sql.SET("course_objectives_info = #{record.courseObjectivesInfo,jdbcType=VARCHAR}");
        }

        if (record.getCredits() != null) {
            sql.SET("credits = #{record.credits,jdbcType=DOUBLE}");
        }

        if (record.getCourseCode() != null) {
            sql.SET("course_code = #{record.courseCode,jdbcType=VARCHAR}");
        }

        if (record.getExamWay() != null) {
            sql.SET("exam_way = #{record.examWay,jdbcType=VARCHAR}");
        }

        if (record.getProportion() != null) {
            sql.SET("proportion = #{record.proportion,jdbcType=VARCHAR}");
        }

        if (record.getClassHour() != null) {
            sql.SET("class_hour = #{record.classHour,jdbcType=VARCHAR}");
        }

        if (record.getCreateUsername() != null) {
            sql.SET("create_username = #{record.createUsername,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("front_personal_course");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("course_id = #{record.courseId,jdbcType=VARCHAR}");
        sql.SET("course_name = #{record.courseName,jdbcType=VARCHAR}");
        sql.SET("course_objectives = #{record.courseObjectives,jdbcType=VARCHAR}");
        sql.SET("course_objectives_info = #{record.courseObjectivesInfo,jdbcType=VARCHAR}");
        sql.SET("credits = #{record.credits,jdbcType=DOUBLE}");
        sql.SET("course_code = #{record.courseCode,jdbcType=VARCHAR}");
        sql.SET("exam_way = #{record.examWay,jdbcType=VARCHAR}");
        sql.SET("proportion = #{record.proportion,jdbcType=VARCHAR}");
        sql.SET("class_hour = #{record.classHour,jdbcType=VARCHAR}");
        sql.SET("create_username = #{record.createUsername,jdbcType=VARCHAR}");

        FrontPersonalCourseExample example = (FrontPersonalCourseExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FrontPersonalCourse record) {
        SQL sql = new SQL();
        sql.UPDATE("front_personal_course");

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCourseId() != null) {
            sql.SET("course_id = #{courseId,jdbcType=VARCHAR}");
        }

        if (record.getCourseName() != null) {
            sql.SET("course_name = #{courseName,jdbcType=VARCHAR}");
        }

        if (record.getCourseObjectives() != null) {
            sql.SET("course_objectives = #{courseObjectives,jdbcType=VARCHAR}");
        }

        if (record.getCourseObjectivesInfo() != null) {
            sql.SET("course_objectives_info = #{courseObjectivesInfo,jdbcType=VARCHAR}");
        }

        if (record.getCredits() != null) {
            sql.SET("credits = #{credits,jdbcType=DOUBLE}");
        }

        if (record.getCourseCode() != null) {
            sql.SET("course_code = #{courseCode,jdbcType=VARCHAR}");
        }

        if (record.getExamWay() != null) {
            sql.SET("exam_way = #{examWay,jdbcType=VARCHAR}");
        }

        if (record.getProportion() != null) {
            sql.SET("proportion = #{proportion,jdbcType=VARCHAR}");
        }

        if (record.getClassHour() != null) {
            sql.SET("class_hour = #{classHour,jdbcType=VARCHAR}");
        }

        if (record.getCreateUsername() != null) {
            sql.SET("create_username = #{createUsername,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, FrontPersonalCourseExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}