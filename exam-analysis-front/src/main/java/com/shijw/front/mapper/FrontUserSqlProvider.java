package com.shijw.front.mapper;

import com.shijw.front.model.FrontUser;
import com.shijw.front.model.example.FrontUserExample.Criteria;
import com.shijw.front.model.example.FrontUserExample.Criterion;

import java.util.List;
import java.util.Map;

import com.shijw.front.model.example.FrontUserExample;
import org.apache.ibatis.jdbc.SQL;

public class FrontUserSqlProvider {

    public String countByExample(FrontUserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("front_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FrontUserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("front_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FrontUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("front_user");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatetime() != null) {
            sql.VALUES("updatetime", "#{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }

        if (record.getTeacherId() != null) {
            sql.VALUES("teacher_id", "#{teacherId,jdbcType=VARCHAR}");
        }

        if (record.getTeacherName() != null) {
            sql.VALUES("teacher_name", "#{teacherName,jdbcType=VARCHAR}");
        }

        if (record.getTeacherRank() != null) {
            sql.VALUES("teacher_rank", "#{teacherRank,jdbcType=VARCHAR}");
        }

        if (record.getCollegeName() != null) {
            sql.VALUES("college_name", "#{collegeName,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String selectByExample(FrontUserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("updatetime");
        sql.SELECT("username");
        sql.SELECT("password");
        sql.SELECT("teacher_id");
        sql.SELECT("teacher_name");
        sql.SELECT("teacher_rank");
        sql.SELECT("college_name");
        sql.FROM("front_user");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FrontUser record = (FrontUser) parameter.get("record");
        FrontUserExample example = (FrontUserExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("front_user");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatetime() != null) {
            sql.SET("updatetime = #{record.updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.getUsername() != null) {
            sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        }

        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{record.teacherId,jdbcType=VARCHAR}");
        }

        if (record.getTeacherName() != null) {
            sql.SET("teacher_name = #{record.teacherName,jdbcType=VARCHAR}");
        }

        if (record.getTeacherRank() != null) {
            sql.SET("teacher_rank = #{record.teacherRank,jdbcType=VARCHAR}");
        }

        if (record.getCollegeName() != null) {
            sql.SET("college_name = #{record.collegeName,jdbcType=VARCHAR}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("front_user");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("updatetime = #{record.updatetime,jdbcType=TIMESTAMP}");
        sql.SET("username = #{record.username,jdbcType=VARCHAR}");
        sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        sql.SET("teacher_id = #{record.teacherId,jdbcType=VARCHAR}");
        sql.SET("teacher_name = #{record.teacherName,jdbcType=VARCHAR}");
        sql.SET("teacher_rank = #{record.teacherRank,jdbcType=VARCHAR}");
        sql.SET("college_name = #{record.collegeName,jdbcType=VARCHAR}");

        FrontUserExample example = (FrontUserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FrontUser record) {
        SQL sql = new SQL();
        sql.UPDATE("front_user");

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatetime() != null) {
            sql.SET("updatetime = #{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getTeacherId() != null) {
            sql.SET("teacher_id = #{teacherId,jdbcType=VARCHAR}");
        }

        if (record.getTeacherName() != null) {
            sql.SET("teacher_name = #{teacherName,jdbcType=VARCHAR}");
        }

        if (record.getTeacherRank() != null) {
            sql.SET("teacher_rank = #{teacherRank,jdbcType=VARCHAR}");
        }

        if (record.getCollegeName() != null) {
            sql.SET("college_name = #{collegeName,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, FrontUserExample example, boolean includeExamplePhrase) {
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