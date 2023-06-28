package com.shijw.front.mapper;

import com.shijw.front.model.FrontPersonalTeachInfo;
import java.util.List;

import com.shijw.front.model.example.FrontPersonalTeachInfoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface FrontPersonalTeachInfoMapper {
    @SelectProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="countByExample")
    long countByExample(FrontPersonalTeachInfoExample example);

    @DeleteProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(FrontPersonalTeachInfoExample example);

    @Delete({
        "delete from front_personal_teach_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into front_personal_teach_info (id, create_time, ",
        "update_time, teach_info_id, ",
        "teacher_id, teacher_username, ",
        "course_id, class_id, ",
        "semester, is_score_upload)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{teachInfoId,jdbcType=VARCHAR}, ",
        "#{teacherId,jdbcType=VARCHAR}, #{teacherUsername,jdbcType=VARCHAR}, ",
        "#{courseId,jdbcType=VARCHAR}, #{classId,jdbcType=VARCHAR}, ",
        "#{semester,jdbcType=VARCHAR}, #{isScoreUpload,jdbcType=BIT})"
    })
    int insert(FrontPersonalTeachInfo record);

    @InsertProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="insertSelective")
    int insertSelective(FrontPersonalTeachInfo record);

    @SelectProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teach_info_id", property="teachInfoId", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_username", property="teacherUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="semester", property="semester", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_score_upload", property="isScoreUpload", jdbcType=JdbcType.BIT)
    })
    List<FrontPersonalTeachInfo> selectByExample(FrontPersonalTeachInfoExample example);

    @Select({
        "select",
        "id, create_time, update_time, teach_info_id, teacher_id, teacher_username, course_id, ",
        "class_id, semester, is_score_upload",
        "from front_personal_teach_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teach_info_id", property="teachInfoId", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_username", property="teacherUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="semester", property="semester", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_score_upload", property="isScoreUpload", jdbcType=JdbcType.BIT)
    })
    FrontPersonalTeachInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FrontPersonalTeachInfo record, @Param("example") FrontPersonalTeachInfoExample example);

    @UpdateProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FrontPersonalTeachInfo record, @Param("example") FrontPersonalTeachInfoExample example);

    @UpdateProvider(type=FrontPersonalTeachInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FrontPersonalTeachInfo record);

    @Update({
        "update front_personal_teach_info",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "teach_info_id = #{teachInfoId,jdbcType=VARCHAR},",
          "teacher_id = #{teacherId,jdbcType=VARCHAR},",
          "teacher_username = #{teacherUsername,jdbcType=VARCHAR},",
          "course_id = #{courseId,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "semester = #{semester,jdbcType=VARCHAR},",
          "is_score_upload = #{isScoreUpload,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FrontPersonalTeachInfo record);
}