package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalScore;

import java.util.List;
import java.util.Map;

import com.shijw.front.model.example.FrontPersonalScoreExample;
import com.shijw.front.model.example.FrontPersonalScoreExample.Criteria;
import com.shijw.front.model.example.FrontPersonalScoreExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

public class FrontPersonalScoreSqlProvider {

    public String countByExample(FrontPersonalScoreExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("front_personal_score");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FrontPersonalScoreExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("front_personal_score");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FrontPersonalScore record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("front_personal_score");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTeachInfoId() != null) {
            sql.VALUES("teach_info_id", "#{teachInfoId,jdbcType=VARCHAR}");
        }

        if (record.getStudentId() != null) {
            sql.VALUES("student_id", "#{studentId,jdbcType=VARCHAR}");
        }

        if (record.getStudentName() != null) {
            sql.VALUES("student_name", "#{studentName,jdbcType=VARCHAR}");
        }

        if (record.getScoreList() != null) {
            sql.VALUES("score_list", "#{scoreList,jdbcType=VARCHAR}");
        }

        if (record.getUsualScore() != null) {
            sql.VALUES("usual_score", "#{usualScore,jdbcType=DOUBLE}");
        }

        if (record.getMidTermScore() != null) {
            sql.VALUES("mid_term_score", "#{midTermScore,jdbcType=DOUBLE}");
        }

        if (record.getEndTermScore() != null) {
            sql.VALUES("end_term_score", "#{endTermScore,jdbcType=DOUBLE}");
        }

        return sql.toString();
    }

    public String selectByExample(FrontPersonalScoreExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("teach_info_id");
        sql.SELECT("student_id");
        sql.SELECT("student_name");
        sql.SELECT("score_list");
        sql.SELECT("usual_score");
        sql.SELECT("mid_term_score");
        sql.SELECT("end_term_score");
        sql.FROM("front_personal_score");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FrontPersonalScore record = (FrontPersonalScore) parameter.get("record");
        FrontPersonalScoreExample example = (FrontPersonalScoreExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("front_personal_score");

        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTeachInfoId() != null) {
            sql.SET("teach_info_id = #{record.teachInfoId,jdbcType=VARCHAR}");
        }

        if (record.getStudentId() != null) {
            sql.SET("student_id = #{record.studentId,jdbcType=VARCHAR}");
        }

        if (record.getStudentName() != null) {
            sql.SET("student_name = #{record.studentName,jdbcType=VARCHAR}");
        }

        if (record.getScoreList() != null) {
            sql.SET("score_list = #{record.scoreList,jdbcType=VARCHAR}");
        }

        if (record.getUsualScore() != null) {
            sql.SET("usual_score = #{record.usualScore,jdbcType=DOUBLE}");
        }

        if (record.getMidTermScore() != null) {
            sql.SET("mid_term_score = #{record.midTermScore,jdbcType=DOUBLE}");
        }

        if (record.getEndTermScore() != null) {
            sql.SET("end_term_score = #{record.endTermScore,jdbcType=DOUBLE}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("front_personal_score");

        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("teach_info_id = #{record.teachInfoId,jdbcType=VARCHAR}");
        sql.SET("student_id = #{record.studentId,jdbcType=VARCHAR}");
        sql.SET("student_name = #{record.studentName,jdbcType=VARCHAR}");
        sql.SET("score_list = #{record.scoreList,jdbcType=VARCHAR}");
        sql.SET("usual_score = #{record.usualScore,jdbcType=DOUBLE}");
        sql.SET("mid_term_score = #{record.midTermScore,jdbcType=DOUBLE}");
        sql.SET("end_term_score = #{record.endTermScore,jdbcType=DOUBLE}");

        FrontPersonalScoreExample example = (FrontPersonalScoreExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FrontPersonalScore record) {
        SQL sql = new SQL();
        sql.UPDATE("front_personal_score");

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getTeachInfoId() != null) {
            sql.SET("teach_info_id = #{teachInfoId,jdbcType=VARCHAR}");
        }

        if (record.getStudentId() != null) {
            sql.SET("student_id = #{studentId,jdbcType=VARCHAR}");
        }

        if (record.getStudentName() != null) {
            sql.SET("student_name = #{studentName,jdbcType=VARCHAR}");
        }

        if (record.getScoreList() != null) {
            sql.SET("score_list = #{scoreList,jdbcType=VARCHAR}");
        }

        if (record.getUsualScore() != null) {
            sql.SET("usual_score = #{usualScore,jdbcType=DOUBLE}");
        }

        if (record.getMidTermScore() != null) {
            sql.SET("mid_term_score = #{midTermScore,jdbcType=DOUBLE}");
        }

        if (record.getEndTermScore() != null) {
            sql.SET("end_term_score = #{endTermScore,jdbcType=DOUBLE}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, FrontPersonalScoreExample example, boolean includeExamplePhrase) {
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