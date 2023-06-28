package com.shijw.back.mapper;

import com.shijw.back.model.BackStudent;
import com.shijw.back.model.BackStudentExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BackStudentMapper {
    @SelectProvider(type=BackStudentSqlProvider.class, method="countByExample")
    long countByExample(BackStudentExample example);

    @DeleteProvider(type=BackStudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(BackStudentExample example);

    @Delete({
        "delete from back_student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into back_student (id, create_time, ",
        "update_time, student_id, ",
        "university_code, college_id, ",
        "class_id, student_name, ",
        "student_telephone, student_email)",
        "values (#{id,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{studentId,jdbcType=VARCHAR}, ",
        "#{universityCode,jdbcType=CHAR}, #{collegeId,jdbcType=VARCHAR}, ",
        "#{classId,jdbcType=VARCHAR}, #{studentName,jdbcType=VARCHAR}, ",
        "#{studentTelephone,jdbcType=VARCHAR}, #{studentEmail,jdbcType=VARCHAR})"
    })
    int insert(BackStudent record);

    @InsertProvider(type=BackStudentSqlProvider.class, method="insertSelective")
    int insertSelective(BackStudent record);

    @SelectProvider(type=BackStudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_telephone", property="studentTelephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_email", property="studentEmail", jdbcType=JdbcType.VARCHAR)
    })
    List<BackStudent> selectByExample(BackStudentExample example);

    @Select({
        "select",
        "id, create_time, update_time, student_id, university_code, college_id, class_id, ",
        "student_name, student_telephone, student_email",
        "from back_student",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="university_code", property="universityCode", jdbcType=JdbcType.CHAR),
        @Result(column="college_id", property="collegeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_telephone", property="studentTelephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_email", property="studentEmail", jdbcType=JdbcType.VARCHAR)
    })
    BackStudent selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BackStudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BackStudent record, @Param("example") BackStudentExample example);

    @UpdateProvider(type=BackStudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BackStudent record, @Param("example") BackStudentExample example);

    @UpdateProvider(type=BackStudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BackStudent record);

    @Update({
        "update back_student",
        "set create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "student_id = #{studentId,jdbcType=VARCHAR},",
          "university_code = #{universityCode,jdbcType=CHAR},",
          "college_id = #{collegeId,jdbcType=VARCHAR},",
          "class_id = #{classId,jdbcType=VARCHAR},",
          "student_name = #{studentName,jdbcType=VARCHAR},",
          "student_telephone = #{studentTelephone,jdbcType=VARCHAR},",
          "student_email = #{studentEmail,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BackStudent record);
}