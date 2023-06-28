package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalStudent;
import com.shijw.front.model.example.FrontPersonalStudentExample.Criteria;
import com.shijw.front.model.example.FrontPersonalStudentExample.Criterion;
import java.util.List;
import java.util.Map;

import com.shijw.front.model.example.FrontPersonalStudentExample;
import org.apache.ibatis.jdbc.SQL;

public class FrontPersonalStudentSqlProvider {

    public String countByExample(FrontPersonalStudentExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("front_personal_student");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FrontPersonalStudentExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("front_personal_student");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FrontPersonalStudent record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("front_personal_student");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStudentId() != null) {
            sql.VALUES("student_id", "#{studentId,jdbcType=VARCHAR}");
        }

        if (record.getUniversityCode() != null) {
            sql.VALUES("university_code", "#{universityCode,jdbcType=CHAR}");
        }

        if (record.getCollegeId() != null) {
            sql.VALUES("college_id", "#{collegeId,jdbcType=VARCHAR}");
        }

        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=VARCHAR}");
        }

        if (record.getStudentName() != null) {
            sql.VALUES("student_name", "#{studentName,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=VARCHAR}");
        }

        if (record.getPhoneNumber() != null) {
            sql.VALUES("phone_number", "#{phoneNumber,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(FrontPersonalStudentExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("student_id");
        sql.SELECT("university_code");
        sql.SELECT("college_id");
        sql.SELECT("class_id");
        sql.SELECT("student_name");
        sql.SELECT("sex");
        sql.SELECT("birthday");
        sql.SELECT("phone_number");
        sql.SELECT("email");
        sql.SELECT("address");
        sql.FROM("front_personal_student");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FrontPersonalStudent record = (FrontPersonalStudent) parameter.get("record");
        FrontPersonalStudentExample example = (FrontPersonalStudentExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("front_personal_student");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStudentId() != null) {
            sql.SET("student_id = #{record.studentId,jdbcType=VARCHAR}");
        }

        if (record.getUniversityCode() != null) {
            sql.SET("university_code = #{record.universityCode,jdbcType=CHAR}");
        }

        if (record.getCollegeId() != null) {
            sql.SET("college_id = #{record.collegeId,jdbcType=VARCHAR}");
        }

        if (record.getClassId() != null) {
            sql.SET("class_id = #{record.classId,jdbcType=VARCHAR}");
        }

        if (record.getStudentName() != null) {
            sql.SET("student_name = #{record.studentName,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            sql.SET("sex = #{record.sex,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            sql.SET("birthday = #{record.birthday,jdbcType=VARCHAR}");
        }

        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{record.phoneNumber,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.SET("address = #{record.address,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("front_personal_student");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("student_id = #{record.studentId,jdbcType=VARCHAR}");
        sql.SET("university_code = #{record.universityCode,jdbcType=CHAR}");
        sql.SET("college_id = #{record.collegeId,jdbcType=VARCHAR}");
        sql.SET("class_id = #{record.classId,jdbcType=VARCHAR}");
        sql.SET("student_name = #{record.studentName,jdbcType=VARCHAR}");
        sql.SET("sex = #{record.sex,jdbcType=VARCHAR}");
        sql.SET("birthday = #{record.birthday,jdbcType=VARCHAR}");
        sql.SET("phone_number = #{record.phoneNumber,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("address = #{record.address,jdbcType=VARCHAR}");

        FrontPersonalStudentExample example = (FrontPersonalStudentExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FrontPersonalStudent record) {
        SQL sql = new SQL();
        sql.UPDATE("front_personal_student");

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStudentId() != null) {
            sql.SET("student_id = #{studentId,jdbcType=VARCHAR}");
        }

        if (record.getUniversityCode() != null) {
            sql.SET("university_code = #{universityCode,jdbcType=CHAR}");
        }

        if (record.getCollegeId() != null) {
            sql.SET("college_id = #{collegeId,jdbcType=VARCHAR}");
        }

        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=VARCHAR}");
        }

        if (record.getStudentName() != null) {
            sql.SET("student_name = #{studentName,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            sql.SET("birthday = #{birthday,jdbcType=VARCHAR}");
        }

        if (record.getPhoneNumber() != null) {
            sql.SET("phone_number = #{phoneNumber,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, FrontPersonalStudentExample example, boolean includeExamplePhrase) {
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