package com.shijw.front.mapper;

import com.shijw.front.model.BackClass;
import com.shijw.front.model.example.BackClassExample;
import org.apache.ibatis.jdbc.SQL;


import java.util.List;
import java.util.Map;

public class BackClassSqlProvider {

    public String countByExample(BackClassExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("back_class");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BackClassExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("back_class");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BackClass record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("back_class");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=VARCHAR}");
        }
        
        if (record.getUniversityCode() != null) {
            sql.VALUES("university_code", "#{universityCode,jdbcType=CHAR}");
        }
        
        if (record.getCollegeId() != null) {
            sql.VALUES("college_id", "#{collegeId,jdbcType=VARCHAR}");
        }
        
        if (record.getMajor() != null) {
            sql.VALUES("major", "#{major,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.VALUES("grade", "#{grade,jdbcType=INTEGER}");
        }
        
        if (record.getClassNumber() != null) {
            sql.VALUES("class_number", "#{classNumber,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BackClassExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("class_id");
        sql.SELECT("university_code");
        sql.SELECT("college_id");
        sql.SELECT("major");
        sql.SELECT("grade");
        sql.SELECT("class_number");
        sql.FROM("back_class");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BackClass record = (BackClass) parameter.get("record");
        BackClassExample example = (BackClassExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("back_class");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{record.classId,jdbcType=VARCHAR}");
        }
        
        if (record.getUniversityCode() != null) {
            sql.SET("university_code = #{record.universityCode,jdbcType=CHAR}");
        }
        
        if (record.getCollegeId() != null) {
            sql.SET("college_id = #{record.collegeId,jdbcType=VARCHAR}");
        }
        
        if (record.getMajor() != null) {
            sql.SET("major = #{record.major,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{record.grade,jdbcType=INTEGER}");
        }
        
        if (record.getClassNumber() != null) {
            sql.SET("class_number = #{record.classNumber,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("back_class");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("class_id = #{record.classId,jdbcType=VARCHAR}");
        sql.SET("university_code = #{record.universityCode,jdbcType=CHAR}");
        sql.SET("college_id = #{record.collegeId,jdbcType=VARCHAR}");
        sql.SET("major = #{record.major,jdbcType=VARCHAR}");
        sql.SET("grade = #{record.grade,jdbcType=INTEGER}");
        sql.SET("class_number = #{record.classNumber,jdbcType=INTEGER}");
        
        BackClassExample example = (BackClassExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BackClass record) {
        SQL sql = new SQL();
        sql.UPDATE("back_class");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=VARCHAR}");
        }
        
        if (record.getUniversityCode() != null) {
            sql.SET("university_code = #{universityCode,jdbcType=CHAR}");
        }
        
        if (record.getCollegeId() != null) {
            sql.SET("college_id = #{collegeId,jdbcType=VARCHAR}");
        }
        
        if (record.getMajor() != null) {
            sql.SET("major = #{major,jdbcType=VARCHAR}");
        }
        
        if (record.getGrade() != null) {
            sql.SET("grade = #{grade,jdbcType=INTEGER}");
        }
        
        if (record.getClassNumber() != null) {
            sql.SET("class_number = #{classNumber,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BackClassExample example, boolean includeExamplePhrase) {
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
        List<BackClassExample.Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            BackClassExample.Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<BackClassExample.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    BackClassExample.Criterion criterion = criterions.get(j);
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
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
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