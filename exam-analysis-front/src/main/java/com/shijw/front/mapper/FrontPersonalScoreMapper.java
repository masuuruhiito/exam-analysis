package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalScore;
import java.util.List;

import com.shijw.front.model.example.FrontPersonalScoreExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontPersonalScoreMapper {
    @SelectProvider(type=FrontPersonalScoreSqlProvider.class, method="countByExample")
    long countByExample(FrontPersonalScoreExample example);

    @DeleteProvider(type=FrontPersonalScoreSqlProvider.class, method="deleteByExample")
    int deleteByExample(FrontPersonalScoreExample example);

    @Delete({
        "delete from front_personal_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into front_personal_score (id, create_time, ",
        "update_time, teach_info_id, ",
        "student_id, student_name, ",
        "score_list, usual_score, ",
        "mid_term_score, end_term_score)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{teachInfoId,jdbcType=VARCHAR}, ",
        "#{studentId,jdbcType=VARCHAR}, #{studentName,jdbcType=VARCHAR}, ",
        "#{scoreList,jdbcType=VARCHAR}, #{usualScore,jdbcType=DOUBLE}, ",
        "#{midTermScore,jdbcType=DOUBLE}, #{endTermScore,jdbcType=DOUBLE})"
    })
    int insert(FrontPersonalScore record);

    @InsertProvider(type=FrontPersonalScoreSqlProvider.class, method="insertSelective")
    int insertSelective(FrontPersonalScore record);

    @SelectProvider(type=FrontPersonalScoreSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teach_info_id", property="teachInfoId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_list", property="scoreList", jdbcType=JdbcType.VARCHAR),
        @Result(column="usual_score", property="usualScore", jdbcType=JdbcType.DOUBLE),
        @Result(column="mid_term_score", property="midTermScore", jdbcType=JdbcType.DOUBLE),
        @Result(column="end_term_score", property="endTermScore", jdbcType=JdbcType.DOUBLE)
    })
    List<FrontPersonalScore> selectByExample(FrontPersonalScoreExample example);

    @Select({
        "select",
        "id, create_time, update_time, teach_info_id, student_id, student_name, score_list, ",
        "usual_score, mid_term_score, end_term_score",
        "from front_personal_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teach_info_id", property="teachInfoId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="score_list", property="scoreList", jdbcType=JdbcType.VARCHAR),
        @Result(column="usual_score", property="usualScore", jdbcType=JdbcType.DOUBLE),
        @Result(column="mid_term_score", property="midTermScore", jdbcType=JdbcType.DOUBLE),
        @Result(column="end_term_score", property="endTermScore", jdbcType=JdbcType.DOUBLE)
    })
    FrontPersonalScore selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FrontPersonalScoreSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontPersonalScore record, @Param("example") FrontPersonalScoreExample example);

    @UpdateProvider(type=FrontPersonalScoreSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FrontPersonalScore record, @Param("example") FrontPersonalScoreExample example);

    @UpdateProvider(type=FrontPersonalScoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontPersonalScore record);

    @Update({
        "update front_personal_score",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "teach_info_id = #{teachInfoId,jdbcType=VARCHAR},",
          "student_id = #{studentId,jdbcType=VARCHAR},",
          "student_name = #{studentName,jdbcType=VARCHAR},",
          "score_list = #{scoreList,jdbcType=VARCHAR},",
          "usual_score = #{usualScore,jdbcType=DOUBLE},",
          "mid_term_score = #{midTermScore,jdbcType=DOUBLE},",
          "end_term_score = #{endTermScore,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontPersonalScore record);
}