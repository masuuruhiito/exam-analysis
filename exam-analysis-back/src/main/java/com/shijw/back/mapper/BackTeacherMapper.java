package com.shijw.back.mapper;

import com.shijw.back.model.BackTeacher;
import com.shijw.back.model.BackTeacherExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
@Mapper
public interface BackTeacherMapper {
    @SelectProvider(type=BackTeacherSqlProvider.class, method="countByExample")
    long countByExample(BackTeacherExample example);

    @DeleteProvider(type=BackTeacherSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackTeacherExample example);

    @Delete({
        "delete from back_teacher",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_teacher (id, create_time, ",
        "update_time, teacher_id, ",
        "university_id, college_id, ",
        "teacher_name, teacher_telephone, ",
        "teacher_email)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{teacherId,jdbcType=CHAR}, ",
        "#{universityId,jdbcType=CHAR}, #{collegeId,jdbcType=CHAR}, ",
        "#{teacherName,jdbcType=VARCHAR}, #{teacherTelephone,jdbcType=VARCHAR}, ",
        "#{teacherEmail,jdbcType=VARCHAR})"
    })
    int insert(BackTeacher record);

    @InsertProvider(type=BackTeacherSqlProvider.class, method="insertSelective")
    int insertSelective(BackTeacher record);

    @SelectProvider(type=BackTeacherSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.CHAR),
        @Result(column="university_id", property="universityId", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.CHAR),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_telephone", property="teacherTelephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_email", property="teacherEmail", jdbcType=JdbcType.VARCHAR)
    })
    List<BackTeacher> selectByExample(BackTeacherExample example);

    @Select({
        "select",
        "id, create_time, update_time, teacher_id, university_id, college_id, teacher_name, ",
        "teacher_telephone, teacher_email",
        "from back_teacher",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.CHAR),
        @Result(column="university_id", property="universityId", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.CHAR),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_telephone", property="teacherTelephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_email", property="teacherEmail", jdbcType=JdbcType.VARCHAR)
    })
    BackTeacher selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackTeacherSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackTeacher record, @Param("example") BackTeacherExample example);

    @UpdateProvider(type=BackTeacherSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackTeacher record, @Param("example") BackTeacherExample example);

    @UpdateProvider(type=BackTeacherSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackTeacher record);

    @Update({
        "update back_teacher",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "teacher_id = #{teacherId,jdbcType=CHAR},",
          "university_id = #{universityId,jdbcType=CHAR},",
          "college_id = #{collegeId,jdbcType=CHAR},",
          "teacher_name = #{teacherName,jdbcType=VARCHAR},",
          "teacher_telephone = #{teacherTelephone,jdbcType=VARCHAR},",
          "teacher_email = #{teacherEmail,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackTeacher record);
}